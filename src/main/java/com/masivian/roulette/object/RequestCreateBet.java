package com.masivian.roulette.object;

import com.masivian.roulette.model.Color;
import com.masivian.roulette.model.TypeBet;

public class RequestCreateBet {
	private Color color;
	private TypeBet typeBet;
	private Integer number;
	private Integer idRoulette;
	private Float money;
	public Color getColor() {
		
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public TypeBet getTypeBet() {
		
		return typeBet;
	}
	public void setTypeBet(TypeBet typeBet) {
		this.typeBet = typeBet;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getIdRoulette() {
		return idRoulette;
	}
	public void setIdRoulette(Integer idRoulette) {
		this.idRoulette = idRoulette;
	}
	public Float getMoney() {
		
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
}
