package symposium;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BlackjackScreen extends FullFunctionScreen {
	/*
	 * Outline for Game
	 *   DONE: Create and shuffle a deck of cards
         DONE: Create two BlackjackHands, userHand and dealerHand
         DONE: Deal two cards into each hand
         Check if dealer has blackjack (if so, game ends)
         Check if user has blackjack (if so, game ends)
         User draws cards (if user goes over 21, game ends)
         Dealer draws cards
         DONE: Check for winner
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -944093183881757273L;
	public static final int ACE = 1, JACK = 11, QUEEN = 12, KING = 13;
	public static final String[] CARD_RANKS = {"JOKER", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	public static final String[] CARD_SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	public static final int[] CARD_VALUES = {1,2,3,4,5,6,7,8,9,10,10,10,10};
	public ArrayList<Card> deck;
	public static final int CLUB = 0, DIAMOND = 1, HEART = 2, SPADE = 3;
	public ArrayList<Card> pHand;
	public boolean isPlayerTurn;
	public ArrayList<Card> dHand;

	public BlackjackScreen(int width, int height) {
		super(width,height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		isPlayerTurn = true;
		pHand = new ArrayList<Card>();
		dHand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		generateRegDeck(deck);
		shuffleDeck(deck, getRandomInteger(1,4));
		dealInitHand(deck,pHand,2);
		dealInitHand(deck,dHand,2);
		//make function later to show the card images
		
		
		
		
		
		/*if(winner()) {
			System.out.println("Yay! You won the round.");
		}
		else
			System.out.println("Oh no! You lost the round");*/
	}
	
	public ArrayList<Card> generateRegDeck(ArrayList<Card> cardArr) {
		deck = cardArr;
		
		for (int r = ACE; r <= KING; r++) {
			for(int s = 0; s <= 13; s++) {
				for (int t = CLUB; s <= SPADE; s++){
				
					Card card = new Card(r,t,r + "-" + t + ".png",s);
					
					cardArr.add(card);
				}
			}
		}	
		return cardArr;
	}
	
	public ArrayList<Card> shuffleDeck(ArrayList<Card> cardArr, int shuffleTime){
		
			ArrayList<Card> shuffledDeck = new ArrayList<Card>();
			
			for(int i = 0; i < shuffleTime;i++) {
				while (deck.size() > 0)
				{
					
					int idx = getRandomInteger(0, deck.size() - 1);
					
					ArrayList<Card> removedCardArray = delete(deck,idx);
					Card card = removedCardArray.get(0);
					
					
					shuffledDeck.add(card);
				}
			}
			deck = shuffledDeck;
			return deck;
	}
	
	public int getRandomInteger(int lower, int upper) {
		
		int multiplier = upper - (lower - 1);
		int rnd = (int)((Math.random() * multiplier) + lower);
		
		return rnd;
	}
	public ArrayList<Card> delete(ArrayList<Card> cardArr,int index) {
		cardArr.remove(index);
		return cardArr;
	}
	
	public void deal(ArrayList<Card> hand) {
		hand.add(deck.get(0));
		deck.remove(0);
		if(checkBust(hand)) {
			System.out.println("You Lost!");
		}
	}
	public boolean checkBust(ArrayList<Card> hand) {
		return countSum(hand) > 21;
	}
	public void hit(ArrayList<Card> hand) {
		if(countSum(hand) <= 21) {
			deal(hand);
		}
	}
	
	public void stand() {
		if(isPlayerTurn) {
			isPlayerTurn = false;
		}
		else
			isPlayerTurn = true;
	}
	public int countSum(ArrayList<Card> hand) {
		int sum = 0;
		for(int i = 0; i < hand.size(); i++) {
			sum += hand.get(i).getValue();
		}
		return sum;
	}
	
	public boolean winner() {
		return countSum(pHand) > countSum(dHand);
	}
	
	public void dealInitHand(ArrayList<Card> d, ArrayList<Card> hand, int initSize) {
		for(int i = 0; i < initSize; i++) {
			hand.add(d.get(i));
			delete(d,i);
		}
	}
}
