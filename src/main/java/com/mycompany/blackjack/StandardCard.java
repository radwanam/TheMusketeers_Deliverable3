/* Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

public class StandardCard extends Card {

    public StandardCard(Suit s, Value v) {
        setValue(v);
        setSuit(s);
    }

    public String toString() {
        return getValue() + " of " + getSuit();
    }
}
