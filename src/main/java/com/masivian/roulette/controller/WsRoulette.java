package com.masivian.roulette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.service.RouletteService;

@RestController
@RequestMapping("/api")
public class WsRoulette {
	@Autowired
	private RouletteService rouletteService;
	@PostMapping("/create")
	public Integer create() {
		return rouletteService.createRoulette();
	}
	@PostMapping("/openRoulette/{id}")
	public Boolean openRoulette(@PathVariable Integer id) {
		return rouletteService.openRoulette(id);
	}
	
}
