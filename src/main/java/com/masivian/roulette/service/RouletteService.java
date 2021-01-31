package com.masivian.roulette.service;

import com.masivian.roulette.object.ResponseCreateRoulette;
import com.masivian.roulette.object.ResponseListRoulettes;
import com.masivian.roulette.object.ResponseOpenRoulette;

public interface RouletteService {
	public ResponseCreateRoulette createRoulette();
	public ResponseOpenRoulette openRoulette(Integer id);
	public ResponseListRoulettes listRoulettes();
}
