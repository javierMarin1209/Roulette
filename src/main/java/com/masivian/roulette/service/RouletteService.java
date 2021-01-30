package com.masivian.roulette.service;

import java.util.List;

import com.masivian.roulette.model.Roulette;

public interface RouletteService {
	public Integer createRoulette();
	public Boolean openRoulette(Integer id);
	public List<Roulette> listRoulettes();

}
