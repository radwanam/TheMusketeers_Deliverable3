/* Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

public class Dealer extends User {
    private Hand hand;

    public Dealer(String name, GroupOfCards deck) {
        super(name);
        hand = new Hand(deck);
    }

    public Hand getDealerHand() {
        return hand;
    }

    public void revealFirstCard() {
        System.out.println("Dealer's first card: ");
        System.out.println(hand.getCard(0) + "\n");
    }

    public void play() {
        while (hand.getHandVal() <= 16) {
            hand.drawCard();
        }
    }
}
