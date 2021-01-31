package com.masivian.roulette.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.masivian.roulette.model.Bet;
import com.masivian.roulette.object.RequestCreateBet;
import com.masivian.roulette.object.ResponseCreateBet;
import com.masivian.roulette.repository.BetRepository;
import com.masivian.roulette.repository.RouletteRepository;

public class BetServiceImp implements BetService {
	private static final Logger LOGGER= LoggerFactory.getLogger(BetServiceImp.class);
	@Autowired
	RouletteRepository rouletteRepository;
	@Autowired
	BetRepository betRepository;
	@Override
	public ResponseCreateBet createBet(RequestCreateBet requestCreateBet,String user) {
		Bet bet= new Bet(requestCreateBet,user);
		ResponseCreateBet responseCreateBet= new ResponseCreateBet();
		try {
			if(bet.validateBet()&&rouletteRepository.findById(requestCreateBet.getIdRoulette())!=null) {
				bet.setId(betRepository.findNextId());
				bet.prepearBet();
				betRepository.saveBet(bet);
				responseCreateBet.setSuccess(true);
			}else {
				responseCreateBet.setSuccess(false);
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseCreateBet.setSuccess(false);
		}
		
		return responseCreateBet;
	}

}
