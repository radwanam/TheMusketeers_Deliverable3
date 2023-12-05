/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for
 * reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    private ArrayList<Card> deck;

    // Creates the deck and shuffles it
    public void intializeDeck() {
        GenerateDeck createDeck = new GenerateDeck();
        deck = createDeck.generateDeck(); // creates the deck
        shuffle(); // shuffles the deck
    }

    private int size;// the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        intializeDeck();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void removeCard(int i) {
        deck.remove(i);
        size -= 1;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}// end class
