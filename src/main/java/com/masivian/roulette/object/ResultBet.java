package com.masivian.roulette.object;

import com.masivian.roulette.model.Bet;

public class ResultBet {
	private String user;
	private Boolean win;
	private Float winedMoney;
	private Integer idBet;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Boolean getWin() {
		return win;
	}
	public void setWin(Boolean win) {
		this.win = win;
	}
	public Float getWinedMoney() {
		return winedMoney;
	}
	public void setWinedMoney(Float winedMoney) {
		this.winedMoney = winedMoney;
	}
	public Integer getIdBet() {
		return idBet;
	}
	public void setIdBet(Integer idBet) {
		this.idBet = idBet;
	}
	public static ResultBet createWinerColor(Bet bet) {
		ResultBet resultBet= new ResultBet();
		resultBet.setIdBet(bet.getId());
		resultBet.setUser(bet.getUser());
		resultBet.setWin(true);
		resultBet.setWinedMoney((float) (bet.getMoney()*1.8));
		return resultBet;
	}
	public static ResultBet createWinerNumber(Bet bet) {
		ResultBet resultBet= new ResultBet();
		resultBet.setIdBet(bet.getId());
		resultBet.setUser(bet.getUser());
		resultBet.setWin(true);
		resultBet.setWinedMoney((float) (bet.getMoney()*5));
		return resultBet;
	}
	public static ResultBet createLoser(Bet bet) {
		ResultBet resultBet= new ResultBet();
		resultBet.setIdBet(bet.getId());
		resultBet.setUser(bet.getUser());
		resultBet.setWin(false);
		resultBet.setWinedMoney((float) 0);
		return resultBet;
	}
}
