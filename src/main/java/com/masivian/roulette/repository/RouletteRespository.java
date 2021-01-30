package com.masivian.roulette.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masivian.roulette.model.Roulette;
@Repository
public class RouletteRespository {
	
	private static final String ROULETTE="ROULETTE";
	private HashOperations<String, Integer, Roulette> hashOperations;
	
	public RouletteRespository(RedisTemplate<String, Roulette> redisTemplate) {
		this.hashOperations=redisTemplate.opsForHash();
	}
	public void saveRoulette(Roulette roulette) {
		hashOperations.put(ROULETTE,roulette.getId(),roulette);
	}
	public List<Roulette> findAll(){
		return hashOperations.values(ROULETTE);
	}
	public Roulette findById(Integer id) {
		return hashOperations.get(ROULETTE, id);
	}
	public void update(Roulette roulette) {
		saveRoulette(roulette);
	}
	public void delete(Integer id) {
		hashOperations.delete(ROULETTE, id);
	}
	public int findNextId() {
		Long i= hashOperations.size(ROULETTE);
		return i.intValue();
	}
	
}