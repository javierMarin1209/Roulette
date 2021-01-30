package com.masivian.roulette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.service.RouletteService;

@RestController
@RequestMapping("/api")
public class WsRoulette {
	@Autowired
	private RouletteService rouletteService;
	@GetMapping("/create")
	public Integer create() {
		return rouletteService.createRoulette();
	}
	
}
