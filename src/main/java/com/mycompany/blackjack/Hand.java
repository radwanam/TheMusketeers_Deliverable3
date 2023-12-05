/* Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

import java.util.ArrayList;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;
    private int handVal = 0;
    private GroupOfCards deck;

    public Hand(GroupOfCards deck) {
        this.deck = deck;
        hand = new ArrayList<>();
        drawCard();
        drawCard();
    }

    public int getHandVal() {
        return handVal;
    }

    public void printDeck() {
        for (int i = 0; i < deck.getSize(); i++) {
            System.out.println(deck.getDeck().get(i));
        }
    }

    // Used at the beginning to have two cards in the hand and used when player
    // decides to hit
    public void drawCard() {
        Card card = deck.getDeck().get(deck.getSize() - 1);
        addCard(card);
        deck.removeCard(deck.getSize() - 1);
        handVal += card.getValue().getNum();
    }

    // adds cards to the arraylist upon call
    public void addCard(Card card) {
        hand.add(card);
    }

    // Returns a card at a specific index in the hand
    public Card getCard(int i) {
        return hand.get(i);
    }

    //
    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        String printCards = "";
        for (int i = 0; i < hand.size(); i++) {
            printCards += hand.get(i).getValue() + " of " + hand.get(i).getSuit() + "\n";
        }
        printCards += "Total value of hand is: " + handVal;
        return printCards;
    }

    @Override
    public int compareTo(Hand other) {
        if (this.handVal == other.handVal) {
            return 0;
        } else if (this.handVal < other.handVal) {
            return -1;
        } else {
            return 1;
        }
    }

}
