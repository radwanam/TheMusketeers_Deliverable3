/* Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

public class Player extends User {
    private Hand hand;
    private double bet;
    private String stance;

    public Player(String name, GroupOfCards deck) {
        super(name);
        hand = new Hand(deck);
    }

    public Hand getPlayerHand() {
        return hand;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public String getStance() {
        return stance;
    }

    public void setStance(String stance) {
        this.stance = stance;
    }

}
