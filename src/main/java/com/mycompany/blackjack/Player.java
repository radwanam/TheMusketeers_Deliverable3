/* Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

public class Player extends User {
    // user's hand
    private Hand hand;
    // variable that stores user's bet amount
    private double bet;
    // variable that stores whether the user wants to hit or stand
    private String stance;

    public Player(String name, GroupOfCards deck) {
        super(name);
        // creates a hand
        hand = new Hand(deck);
    }

    /**
     * @return Hand
     */
    public Hand getPlayerHand() {
        return hand;
    }

    /**
     * @return double
     */
    public double getBet() {
        return bet;
    }

    /**
     * @param bet
     */
    public void setBet(Double bet) {
        this.bet = bet;
    }

    /**
     * @return String
     */
    public String getStance() {
        return stance;
    }

    /**
     * @param stance
     */
    public void setStance(String stance) {
        this.stance = stance;
    }

}
