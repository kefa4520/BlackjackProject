package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);

	Dealer dealer; 
	Player player;

	public static void main(String[] args) {
		BlackjackApp play = new BlackjackApp();
	
        play.dealer = new Dealer();
        play.player = new Player(null);
        play.playGame();
	
	}
     public void playGame() {
    	makePlayer();
 		dealer.shuffle();
 		dealCardsInitial();
 		showHandsInitial();
 		showBlackjack();

 		String playerChoice;
 		do {
 			System.out.println(player.getName() + ", press 1 to hit or 0 to stand?");
 			playerChoice = sc.next();
 			if (playerChoice.equals("1")) {
 				playerHit();
 				showBust();
 				if (player.getPlayerHand().getHandValue() == 21) {
 					break;
 				}
 				showPlayerHand();

 			} else if(!playerChoice.equals("0")){
 				System.out.println("Wrong input, try again");
 				continue;//playerChoice = sc.next();
 			}
 		} while (!playerChoice.equals("0"));

 		while (dealer.getDealerHand().getHandValue() < 17) {
 			hit();
 		}
 		showBust();
 		checkForWin();
 		
    	 
     }
	
	public void checkForWin() { 
		if(dealer.getDealerHand().getHandValue() > player.getPlayerHand().getHandValue()) {
			showDealerHand();
			System.out.println("Dealer wins!");
			System.exit(0);
		}
		else if(player.getPlayerHand().getHandValue() > dealer.getDealerHand().getHandValue()) {
			showDealerHand();
			System.out.println(player.getName() + " won!");
			System.exit(0);
		}
		else if (player.getPlayerHand().getHandValue() == dealer.getDealerHand().getHandValue()) {
			showDealerHand();
			System.out.println("Push!");
		}
	}


	public Player makePlayer() {
		System.out.println("What is your name?");
		System.out.println("Entry: ");
		player.setName(sc.nextLine());

		return player;
	}

	public void dealCardsInitial() {
	
		dealer.newCard(dealer.getDealerHand());
		dealer.newCard(dealer.getDealerHand());
		
		dealer.newCard(player.getPlayerHand());
		dealer.newCard(player.getPlayerHand());

	}

	public void showBlackjack() {
		if (((BlackjackHand) player.getPlayerHand()).hasBlackjack()
				&& !((BlackjackHand) dealer.getDealerHand()).hasBlackjack()) {
			showDealerHand();
			System.out.println("Blackjack! You won!");
			System.exit(0);

		} else if (((BlackjackHand) dealer.getDealerHand()).hasBlackjack()
				&& !((BlackjackHand) player.getPlayerHand()).hasBlackjack()) {
			showDealerHand();
			System.out.println("Blackjack! Dealer won!");
			System.exit(0);
		} 
	}
		
		public void showBust() {
		if (((BlackjackHand) player.getPlayerHand()).isBust()) {
			showPlayerHand();
			showDealerHand();
			System.out.println("Bust!" + player.getName()+ " exceeded 21. Dealer wins!");
			System.exit(0);
		}

		else if (((BlackjackHand) dealer.getDealerHand()).isBust()) {
			System.out.println("Bust! Dealer exceeded 21. You won!");
			showPlayerHand();
			showDealerHand();
			System.exit(0);
		}

	}
	
	public void showHandsInitial() {

		System.out.println("--------------------------------------------------------\n");
		dealer.dealersInitCards();
		System.out.println("--------------------------------------------------------\n");

		System.out.println(player.getName() + "'s " + player.getPlayerHand() + " value of the cards "
				+ player.getPlayerHand().getHandValue());
	}
	
	public void showPlayerHand() {
		
		System.out.println();
		System.out.println(player.getName() + "'s " + player.getPlayerHand() + " value of the cards "
	    + player.getPlayerHand().getHandValue());
	}
	public void showDealerHand() {
		
		System.out.println();
		System.out.println("Dealer's " + dealer.getDealerHand() 
		+ " value of the cards "+ dealer.getDealerHand().getHandValue());
	}

	public void playerHit() {
		dealer.newCard(player.getPlayerHand());
	}

	public void hit() {
		dealer.newCard(dealer.getDealerHand());
	}

}
