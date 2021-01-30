package com.masivian.roulette.model;

public class Bet {
	private Integer id;
	private String user;
	private TypeBet type;
	private Color color;
	private String number;
	private Integer idRoulette;
	public Integer getId() {
		
		return id;
	}
	public void setId(Integer id) {
		
		this.id = id;
	}
	public String getUser() {
		
		return user;
	}
	public void setUser(String user) {
		
		this.user = user;
	}
	public TypeBet getType() {
		
		return type;
	}
	public void setType(TypeBet type) {
		
		this.type = type;
	}
	public Color getColor() {
		
		return color;
	}
	public void setColor(Color color) {
		
		this.color = color;
	}
	public String getNumber() {
		
		return number;
	}
	public void setNumber(String number) {
		
		this.number = number;
	}
	public Integer getIdRoulette() {
		
		return idRoulette;
	}
	public void setIdRoulette(Integer idRoulette) {
		
		this.idRoulette = idRoulette;
	}
}
