package com.masivian.roulette.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.Status;
import com.masivian.roulette.object.ResponseCreateRoulette;
import com.masivian.roulette.object.ResponseListRoulettes;
import com.masivian.roulette.object.ResponseOpenRoulette;
import com.masivian.roulette.repository.RouletteRepository;

@Service
public class RouletteServiceImp implements RouletteService {
	private static final Logger LOGGER= LoggerFactory.getLogger(RouletteServiceImp.class);
	@Autowired
	RouletteRepository rouletteRepository;
	@Override
	public ResponseCreateRoulette createRoulette() {
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
		ResponseListRoulettes response = new ResponseListRoulettes();
		try {
			response.setRoulettes(rouletteRepository.findAll());
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return response;
	}
}
