package com.masivian.roulette.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.Status;
import com.masivian.roulette.object.RequestCreateBet;
import com.masivian.roulette.object.ResponseCreateBet;
import com.masivian.roulette.repository.BetRepository;
import com.masivian.roulette.repository.RouletteRepository;
@Service
public class BetServiceImp implements BetService {
	private static final Logger LOGGER= LoggerFactory.getLogger(BetServiceImp.class);
	@Autowired
	RouletteRepository rouletteRepository;
	@Autowired
	BetRepository betRepository;
	@Override
	public ResponseCreateBet createBet(RequestCreateBet requestCreateBet,String user) {
		LOGGER.info("--------CREATE A BET-----USER: "+user);
		Bet bet= new Bet(requestCreateBet,user);
		ResponseCreateBet responseCreateBet= new ResponseCreateBet();
		responseCreateBet.setSuccess(false);
		try {
			if(bet.validateBet()) {
				Roulette roulette=rouletteRepository.findById(requestCreateBet.getIdRoulette());
				if(roulette!=null && roulette.getStatus()==Status.OPEN) {
					bet.setId(betRepository.findNextId());
					bet.prepearBet();
					betRepository.saveBet(bet);
					responseCreateBet.setSuccess(true);
				}
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		return responseCreateBet;
	}
}
