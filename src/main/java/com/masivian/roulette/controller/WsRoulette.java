package com.masivian.roulette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.object.ResponseCloseRoulette;
import com.masivian.roulette.object.ResponseCreateRoulette;
import com.masivian.roulette.object.ResponseListRoulettes;
import com.masivian.roulette.object.ResponseOpenRoulette;
import com.masivian.roulette.service.RouletteService;

@RestController
@RequestMapping("/api/roulette")
public class WsRoulette {
	@Autowired
	private RouletteService rouletteService;
	@PostMapping("/create")
	public ResponseCreateRoulette create() {
		
		return rouletteService.createRoulette();
	}
	@PutMapping("/open/{id}")
	public ResponseOpenRoulette openRoulette(@PathVariable Integer id) {
		
		return rouletteService.openRoulette(id);
	}
	@GetMapping("/list")
	public ResponseListRoulettes listRoulettes() {
		
		return rouletteService.listRoulettes();
	}
	@PutMapping("/close/{id}")
	public ResponseCloseRoulette closeRoulette(@PathVariable Integer id) {
		
		return rouletteService.closeRoulette(id);
	}
	
}
