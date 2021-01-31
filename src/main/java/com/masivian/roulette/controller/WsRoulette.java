package com.masivian.roulette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.object.RequestCreateBet;
import com.masivian.roulette.object.ResponseCreateBet;
import com.masivian.roulette.object.ResponseCreateRoulette;
import com.masivian.roulette.object.ResponseListRoulettes;
import com.masivian.roulette.object.ResponseOpenRoulette;
import com.masivian.roulette.service.RouletteService;

@RestController
@RequestMapping("/api")
public class WsRoulette {
	@Autowired
	private RouletteService rouletteService;
	@PostMapping("/create")
	public ResponseCreateRoulette create() {
		return rouletteService.createRoulette();
	}
	@PostMapping("/openRoulette/{id}")
	public ResponseOpenRoulette openRoulette(@PathVariable Integer id) {
		return rouletteService.openRoulette(id);
	}
	@GetMapping("/listRoulette")
	public ResponseListRoulettes listRoulettes() {
		return rouletteService.listRoulettes();
	}
	@PostMapping("/createBet")
	public ResponseCreateBet createBet(@RequestBody RequestCreateBet createBet,@RequestHeader(name = "User",required = true) String user) {
		return rouletteService.createBet(createBet,user);
	}
	
}
