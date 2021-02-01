package com.masivian.roulette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.object.RequestCreateBet;
import com.masivian.roulette.object.ResponseCreateBet;
import com.masivian.roulette.service.BetService;

@RestController
@RequestMapping("/api/bet")
public class WsBet {
	@Autowired
	BetService betService;
	@PostMapping("/create")
	public ResponseCreateBet createBet(@RequestBody RequestCreateBet createBet,@RequestHeader(name = "User",required = true) String user) {
		
		return betService.createBet(createBet,user);
	}

}
