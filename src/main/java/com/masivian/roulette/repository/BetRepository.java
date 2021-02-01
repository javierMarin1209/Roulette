package com.masivian.roulette.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masivian.roulette.model.Bet;
@Repository
public class BetRepository {
	private static final String BET="BET";
	private HashOperations<String, Integer, Bet> hashOperations;
	public BetRepository(RedisTemplate<String, Bet> redisTemplate) {
		this.hashOperations=redisTemplate.opsForHash();
	}
	public void saveBet(Bet bet) {
		hashOperations.put(BET,bet.getId(),bet);
	}
	public List<Bet> findAll(){
		
		return hashOperations.values(BET);
	}
	public Bet findById(Integer id) {
		
		return hashOperations.get(BET, id);
	}
	public void update(Bet bet) {
		saveBet(bet);
	}
	public void delete(Integer id) {
		hashOperations.delete(BET, id);
	}
	public int findNextId() {
		Long i= hashOperations.size(BET);
		
		return i.intValue();
	}
	public void updateByRoulette(Map<Integer,Bet> bets) {
		hashOperations.putAll(BET,bets);
	}
}
