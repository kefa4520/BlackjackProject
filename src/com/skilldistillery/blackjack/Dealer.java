package com.skilldistillery.blackjack;

public class Dealer {
	
	private Hand dealerHand = new BlackjackHand();
	private Deck newDeck = new Deck();
	
	
	public void newCard(Hand hand) {
		newDeck.dealCard(hand);  
		
	}
	
	public void dealersInitCards() {
		for(int i = 1; i < dealerHand.cardsInHand.size(); i++) {
			int value = dealerHand.cardsInHand.get(1).getValue();
			
			System.out.println("Dealer's hand: [" + dealerHand.cardsInHand.get(1) + "] value of the card " + value+ "\n");
		}
	}

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}
	
	public void shuffle() {
		newDeck.shuffle();
	}
	
	public int checkDeck() {
		int size = newDeck.checkDeckSize();
		return size;
	}
	

	
}
