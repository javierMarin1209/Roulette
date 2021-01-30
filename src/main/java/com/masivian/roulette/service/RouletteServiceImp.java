package com.masivian.roulette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.Status;
import com.masivian.roulette.repository.RouletteRespository;

@Service
public class RouletteServiceImp implements RouletteService {
	@Autowired
	RouletteRespository rouletteRepository;
	@Override
	public Integer createRoulette() {
		Roulette roulette= new Roulette();
		roulette.setStatus(Status.CLOSE);
		roulette.setId(rouletteRepository.findNextId());
		rouletteRepository.saveRoulette(roulette);
		return roulette.getId();
	}

}
