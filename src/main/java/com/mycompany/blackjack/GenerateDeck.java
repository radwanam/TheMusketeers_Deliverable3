/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/* Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

import java.util.ArrayList;

/**
 *
 * @author amrra
 */
public class GenerateDeck {

    public ArrayList<Card> generateDeck() {

        ArrayList<Card> deck = new ArrayList<Card>();

        for (int i = 0; i < Card.Suit.values().length; i++) {
            for (int j = 0; j < Card.Value.values().length; j++) {
                Card card = new StandardCard(Card.Suit.values()[i], Card.Value.values()[j]);
                deck.add(card);
            }
        }

        return deck;
    }
}
