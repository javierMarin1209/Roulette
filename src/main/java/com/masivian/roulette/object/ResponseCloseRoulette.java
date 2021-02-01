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
		
		for(Bet bet:bets) {
			switch (bet.getType()) {
			case COLOR:
				response.getResults().add(createResponseBetColor(bet,winerNumber));
				break;
			case NUMBER:
				response.getResults().add(createResponseBetNumber(bet,winerNumber));
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
	private ResultBet createResponseBetColor(Bet bet,int winerNumber) {
		ResultBet response;
		Color color=winerNumber%2==0?Color.RED:Color.BLACK;
		if(bet.getColor().equals(color)) {
			response=ResultBet.createWinerColor(bet);
		}else {
			response=ResultBet.createLoser(bet);
		}
		
		return response;
	}
	private ResultBet createResponseBetNumber(Bet bet,int winerNumber) {
		ResultBet response;
		if(bet.getNumber().equals(winerNumber)) {
			response=ResultBet.createWinerNumber(bet);
		}else {
			response=ResultBet.createLoser(bet);
		}
		
		return response;
	}
}
