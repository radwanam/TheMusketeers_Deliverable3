/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

/**
 * A class that models each Player and Dealer in the game. users have an
 * identifier,
 * which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class User {

    private String name; // the unique name for this user

    /**
     * A constructor that allows you to set the user's unique ID
     *
     * @param name the unique ID to assign to the user.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the userID is unique
     *
     * @param name the user name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
