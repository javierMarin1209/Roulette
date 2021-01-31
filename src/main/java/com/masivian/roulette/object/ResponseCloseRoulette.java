package com.masivian.roulette.object;

import java.util.ArrayList;
import java.util.List;

import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.Color;

public class ResponseCloseRoulette {
	private List<ResultBet> results;
	private Boolean success;
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<ResultBet> getResults() {
		if(results==null) {
			results= new ArrayList<>();
		}
		return results;
	}

	public void setResults(List<ResultBet> results) {
		this.results = results;
	}
	public ResponseCloseRoulette createResponse(List<Bet> bets) {
		ResponseCloseRoulette response= new ResponseCloseRoulette();
		response.setSuccess(true);
		Integer winerNumber=haveWinerNumber();
		Color color=winerNumber%2==0?Color.RED:Color.BLACK;
		for(Bet bet:bets) {
			switch (bet.getType()) {
			case COLOR:
				if(bet.getColor().equals(color)) {
					response.getResults().add(ResultBet.createWinerColor(bet));
				}else {
					response.getResults().add(ResultBet.createLoser(bet));
				}
				break;
			case NUMBER:
				if(bet.getNumber().equals(winerNumber)) {
					response.getResults().add(ResultBet.createWinerNumber(bet));
				}else {
					response.getResults().add(ResultBet.createLoser(bet));
				}
				break;
			default:
				break;
			}
		}
		return response;
	}
	private Integer haveWinerNumber() {
		return (int) (Math.random()*36);
	}
}
