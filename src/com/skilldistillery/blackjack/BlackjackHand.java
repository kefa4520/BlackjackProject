package com.skilldistillery.blackjack;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}
	
@Override
public int getHandValue() {
	  int handValue = 0;

	  for(int i = 0; i < cardsInHand.size(); i++) {
		  handValue += cardsInHand.get(i).getValue(); 
		  
	  }
	return handValue;
	  
}  
  public boolean hasBlackjack() {
	  
		 if(cardsInHand.size() == 2 && getHandValue() == 21) {
			
			 return true;
		 }
		 return false;
	  }
  public boolean isBust() {
	  if (getHandValue() > 21) {
		 
		  return true;
	  }
	  return false;
  }
  
}
