package com.masivian.roulette.service;

import com.masivian.roulette.object.RequestCreateBet;
import com.masivian.roulette.object.ResponseCreateBet;

public interface BetService {
	public ResponseCreateBet createBet(RequestCreateBet bet,String user);
}
