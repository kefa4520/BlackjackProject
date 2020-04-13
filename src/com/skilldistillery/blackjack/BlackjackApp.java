package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);

	Dealer dealer; 
	Player player;

	public static void main(String[] args) {
		BlackjackApp play = new BlackjackApp();
	
        play.playGame();
	
	}
     public void playGame() {
    	 System.out.println(" --------------------------------------");
    	 System.out.println("|  Blackjack app is open for busines!  |");
    	 System.out.println("|   Press 1 to play, press 0 to quit.  | ");
    	 System.out.println(" --------------------------------------");
    	 System.out.print("Entry: ");
    	 String choice = sc.next();

    	 if(choice.equals("0")) {
    		 System.out.println("Good bye!");
    		 System.exit(0);
    	 }
    	 else if(!choice.equals("0") && !choice.equals("1")) {
    		 playGame();
         }
    	 else {
    	player = new Player(null);
    	dealer = new Dealer();
    	makePlayer();
 		dealer.shuffle();
 		dealCardsInitial();
 		showHandsInitial();
 		showBlackjack();
 		showBust();

 		String playerChoice;
 		
 		while(player.getPlayerHand().getHandValue()< 21) {
 		    System.out.println(player.getName() + ", press 1 to hit or 0 to stand?");
      		playerChoice = sc.next();
      		
 			if (playerChoice.equals("1")) {
 				playerHit();
 				if (player.getPlayerHand().getHandValue() == 21) {
 					showPlayerHand();
 					
 		 			checkForWin();
 				}
 				showBust();
 				showPlayerHand();
 				}
 			else if(!playerChoice.equals("0")){
 				System.out.println("Wrong input, try again");
 				continue;
 		    }
 			else{
 				if(playerChoice.equals("0") && player.getPlayerHand().getHandValue()< 21){
 			 			hit();
 			 			showBust();
 			 			checkForWin();
 				}
 		      }
 		  }
        }
 		
     }
     
	
	public void checkForWin() { 
		if (player.getPlayerHand().getHandValue() == dealer.getDealerHand().getHandValue()) {
			showDealerHand();
			System.out.println("Push!");
			playGame(); //System.exit(0);
		}
		else if (player.getPlayerHand().getHandValue() == 21) {
			    hit();
	 			showBust();
	 			showDealerHand();
	 			if (player.getPlayerHand().getHandValue() == dealer.getDealerHand().getHandValue()) {
	 				System.out.println("Push!");
	 				playGame(); //System.exit(0);
	 				}
	 			else {		
			System.out.println(player.getName() + " won!");
			playGame(); //System.exit(0);
	 			}
		}
		else if (dealer.getDealerHand().getHandValue() == 21) {
			showDealerHand();
			System.out.println("Dealer wins!");
			playGame(); //System.exit(0);
			
		}
		
		else if(dealer.getDealerHand().getHandValue() > player.getPlayerHand().getHandValue()) {
			showDealerHand();
			System.out.println("Dealer wins!");
			playGame(); //System.exit(0);
		}
		else if(player.getPlayerHand().getHandValue() > dealer.getDealerHand().getHandValue()) {
			showDealerHand();
			System.out.println(player.getName() + " won!");
			playGame(); //System.exit(0);
		}
	}


	public Player makePlayer() {
		sc.nextLine();
		System.out.println("What is your name?");
		System.out.print("Entry: ");
		player.setName(sc.nextLine());
		System.out.println("Welcome to the game, " + player.getName());
		System.out.println();
		

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
			playGame(); //System.exit(0);

		} else if (((BlackjackHand) dealer.getDealerHand()).hasBlackjack()
				&& !((BlackjackHand) player.getPlayerHand()).hasBlackjack()) {
			showDealerHand();
			System.out.println("Blackjack! Dealer won!");
			playGame(); //System.exit(0);
		} 
	}
		
		public void showBust() {
		if (((BlackjackHand) player.getPlayerHand()).isBust()) {
			showDealerHand();
			showPlayerHand();
			System.out.println("Bust!" + player.getName()+ " exceeded 21. Dealer wins!");
			playGame(); //System.exit(0);
		}

		else if (((BlackjackHand) dealer.getDealerHand()).isBust()) {
			showDealerHand();
			System.out.println("Bust! Dealer exceeded 21. You won!");
			playGame(); //System.exit(0);
		}

	}
	
	public void showHandsInitial() {
		dealer.dealersInitCards();

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
		while (dealer.getDealerHand().getHandValue() < 17) {
		dealer.newCard(dealer.getDealerHand());
		}
	}

}
