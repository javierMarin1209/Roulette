package com.masivian.roulette.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.Status;
import com.masivian.roulette.object.ResponseCloseRoulette;
import com.masivian.roulette.object.ResponseCreateRoulette;
import com.masivian.roulette.object.ResponseListRoulettes;
import com.masivian.roulette.object.ResponseOpenRoulette;
import com.masivian.roulette.repository.BetRepository;
import com.masivian.roulette.repository.RouletteRepository;

@Service
public class RouletteServiceImp implements RouletteService {
	private static final Logger LOGGER= LoggerFactory.getLogger(RouletteServiceImp.class);
	@Autowired
	RouletteRepository rouletteRepository;
	@Autowired
	BetRepository betRepository;
	@Override
	public ResponseCreateRoulette createRoulette() {
		LOGGER.info("--------CREATE A ROULETTE-----");
		ResponseCreateRoulette response= new ResponseCreateRoulette();
		Roulette roulette= new Roulette();
		roulette.setStatus(Status.CLOSE);
		try {
			roulette.setId(rouletteRepository.findNextId());
			rouletteRepository.saveRoulette(roulette);
			response.setId(roulette.getId());
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return response;
	}
	@Override
	public ResponseOpenRoulette openRoulette(Integer id) {
		LOGGER.info("--------OPEN A ROULETTE-----ID:"+id);
		ResponseOpenRoulette response= new ResponseOpenRoulette();
		Roulette roulette= new Roulette();
		response.setStatus(false);
		roulette.setStatus(Status.OPEN);
		roulette.setId(id);
		try {
			if(rouletteRepository.findById(id)!=null) {
				rouletteRepository.update(roulette);
				response.setStatus(true);
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return response;
	}
	@Override
	public ResponseListRoulettes listRoulettes() {
		LOGGER.info("--------LIST ROULETTES-----");
		ResponseListRoulettes response = new ResponseListRoulettes();
		try {
			response.setRoulettes(rouletteRepository.findAll());
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return response;
	}
	@Override
	@Transactional
	public ResponseCloseRoulette closeRoulette(Integer id) {
		LOGGER.info("--------CLOSE A ROULETTE-----ID:"+id);
		ResponseCloseRoulette response= new ResponseCloseRoulette();
		Roulette roulette;
		response.setSuccess(false);
		try {
			roulette=rouletteRepository.findById(id);
			if(roulette!=null && roulette.getStatus()==Status.OPEN) {
				roulette.setStatus(Status.CLOSE);
				rouletteRepository.saveRoulette(roulette);
				List<Bet> betsByRoulette=betRepository.findAll().stream()
						.filter(bet->( bet.getIdRoulette().equals(id)&&bet.getStatus()==Status.OPEN)).collect(Collectors.toList());
				closeBets(betsByRoulette);
				response=response.createResponse(betsByRoulette);
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return response;
	}
	private void closeBets(List<Bet> bets) {
		Map<Integer, Bet> betClose= new HashMap<>();
		for(Bet bet:bets) {
			bet.setStatus(Status.CLOSE);
			betClose.put(bet.getId(), bet);
		}
		betRepository.updateByRoulette(betClose);
	}
}
