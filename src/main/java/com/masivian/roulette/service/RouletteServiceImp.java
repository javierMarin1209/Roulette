package com.masivian.roulette.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.Status;
import com.masivian.roulette.repository.RouletteRespository;

@Service
public class RouletteServiceImp implements RouletteService {
	private static final Logger LOGGER= LoggerFactory.getLogger(RouletteServiceImp.class);
	@Autowired
	RouletteRespository rouletteRepository;
	@Override
	public Integer createRoulette() {
		Roulette roulette= new Roulette();
		roulette.setStatus(Status.CLOSE);
		try {
			roulette.setId(rouletteRepository.findNextId());
			rouletteRepository.saveRoulette(roulette);
			return roulette.getId();
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			return -1;
		}
		
	}
	@Override
	public Boolean openRoulette(Integer id) {
		Boolean res=false;
		Roulette roulette= new Roulette();
		roulette.setStatus(Status.OPEN);
		roulette.setId(id);
		try {
			if(rouletteRepository.findById(id)!=null) {
				rouletteRepository.update(roulette);
				res= true;
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return res;
	}
	@Override
	public List<Roulette> listRoulettes() {
		try {
			return rouletteRepository.findAll();
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

}
