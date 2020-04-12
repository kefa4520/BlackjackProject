package com.skilldistillery.blackjack;

public class Player {
	private Hand playerHand = new BlackjackHand();
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void cardForPlayer() {
		
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	

	@Override
	public String toString() {
		return "Player [playerHand=" + playerHand + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
