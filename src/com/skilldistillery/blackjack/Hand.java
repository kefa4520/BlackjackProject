package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cardsInHand = new ArrayList<>();

	public Hand() {
		
	}
	
	
	public List<Card> getCardsInHand() {
		return cardsInHand;
	}


	public void setCardsInHand(List<Card> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}


	public void addCard(Card card) {
		cardsInHand.add(card);
	}
	
	public void clearHand() {
		
	}

	@Override
	public String toString() {
		return "hand: " + cardsInHand;
	}

	public abstract int getHandValue();
	
}
