/* Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

import java.util.ArrayList;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand; // creates a hand
    private int handVal = 0; // value of the cards in the hand
    private GroupOfCards deck; // deck - will be used to create the hand

    public Hand(GroupOfCards deck) {
        this.deck = deck;
        hand = new ArrayList<>();
        drawCard();
        drawCard();
    }

    public int getHandVal() {
        return handVal;
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

    // returns the hand arraylist
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

    // compareTo method which compares two hands using their hand value (total value
    // of cards in the hand)
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
