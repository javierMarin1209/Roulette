package com.masivian.roulette.model;

import com.masivian.roulette.object.RequestCreateBet;

public class Bet {
	private Integer id;
	private String user;
	private TypeBet type;
	private Color color;
	private Integer number;
	private Float money;
	private Integer idRoulette;
	
	public Bet(RequestCreateBet createBet,String user) {
		this.user=user;
		this.idRoulette=createBet.getIdRoulette();
		this.type=createBet.getTypeBet();
		this.color=createBet.getColor();
		this.number=createBet.getNumber();
		this.money=createBet.getMoney();
	}
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
	public boolean validateBet() {
		boolean response=false;
		if(money!=null&&money<=10000 &&money>0&&type!=null) {
			switch (this.type) {
			case COLOR:
				response=color!=null;
				break;
			case NUMBER:
				if(number!=null&&number<=36&&number>=0) {
					response=true;
				}
				break;
			default:
				response= false;
				break;
			}
		}
		return response;
	}
	public void prepearBet() {
		switch (this.type) {
		case COLOR:
			if(color!=null) {
				number=null;
			}
			break;
		case NUMBER:
			if(number!=null&&number<=36&&number>=0) {
				if(number%2==0) {
					color=Color.RED;
				}else {
					color=Color.BLACK;
				}
			}
			break;
		default:
			break;
		}
	}
}
