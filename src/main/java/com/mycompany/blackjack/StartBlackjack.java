/* Amr Radwan 02/12/2023
 * NsikakAbasi Ibangha 02/12/2023
 * Lyndsy Musyoki 02/12/2023
 */
package com.mycompany.blackjack;

import java.util.Scanner;

public class StartBlackjack extends Game {

    public StartBlackjack() {
        super("Blackjack");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        Scanner inp = new Scanner(System.in);
        StartBlackjack blackjack = new StartBlackjack();

        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")) {
            // creating a deck
            GroupOfCards sharedDeck = new GroupOfCards(52);
            // creating a dealer instance and passing the deck
            Dealer dealer = new Dealer("Dealer", sharedDeck);
            // creating a player instance and passing the deck
            Player player = new Player("Player", sharedDeck);

            blackjack.play(player, dealer);

            System.out.println("Please enter bet amount:");
            player.setBet(inp.nextDouble());

            // outputs player's hand and bet amount
            System.out.println(
                    "This is your hand: \n" + player.getPlayerHand().toString() + "\nBet amount: $" + player.getBet());

            // shows dealer's first card as in the real game
            dealer.revealFirstCard();

            System.out.println("Do you want to hit or stand?");
            player.setStance(inp.next());

            // validating input to see if it matches hit or stand otherwise take input again
            while (!(player.getStance().equalsIgnoreCase("hit")) && !(player.getStance().equalsIgnoreCase("stand"))) {
                System.out.println("Invalid input. Please enter hit or stand");
                player.setStance(inp.next());
            }

            // loop to be repeated while player's hand is below 21 and player wants to hit
            while (player.getPlayerHand().getHandVal() < 21 && player.getStance().equalsIgnoreCase("hit")) {
                System.out.println("\nYou chose to hit.\n");
                player.getPlayerHand().drawCard();
                System.out.println("Card drew:");
                System.out.println(
                        player.getPlayerHand().getCard(player.getPlayerHand().getHand().size() - 1).toString() + "\n");
                System.out.println(
                        "This is your hand: \n" + player.getPlayerHand().toString() + "\nBet amount: $"
                                + player.getBet());
                System.out.println();
                if (player.getPlayerHand().getHandVal() < 21) {
                    System.out.println("If you want to hit again, enter hit. Otherwise, enter stand:");
                    player.setStance(inp.next());
                    System.out.println();
                }
            }

            // if player chooses to stand their hand and bet amount is output
            if (player.getStance().equalsIgnoreCase("stand")) {
                System.out.println("\nYou chose to stand.");
                System.out.println(
                        "This is your hand: \n" + player.getPlayerHand().toString() + "\nBet amount: $"
                                + player.getBet());
                System.out.println();
            }
            // finding the winner
            blackjack.declareWinner(player, dealer);
            System.out.println("Do you want to play again?");
            playAgain = inp.next();
            // Clears the screen
            System.out.print("\033[H\033[2J");
        }
        inp.close();

    }

    @Override
    public void play(Player player, Dealer dealer) {
        dealer.play();
    }

    // returns true if player's hand is above 21 (because they bust)
    public static boolean isPlayerHandBust(int playerHandVal) {
        if (playerHandVal > 21) {
            return true;
        }
        return false;
    }

    // returns true if dealer's hand is above 21 (because they bust)
    public static boolean isDealerHandBust(int dealerHandVal) {
        if (dealerHandVal > 21) {
            return true;
        }
        return false;
    }

    // returns true if player's hand is 21 and dealer's hand is not 21
    // which means player's hand is blackjack and they win
    public static boolean isPlayerHandBlackjack(int playerHandVal, int dealerHandVal) {
        if (playerHandVal == 21 && dealerHandVal != 21) {
            return true;
        }
        return false;
    }

    public void declareWinner(Player player, Dealer dealer) {
        // Player's hand greater than 21 - bust without looking at dealer's hand because
        // if both player and dealer bust, the player loses
        if (isPlayerHandBust(player.getPlayerHand().getHandVal())) {
            System.out.println("Bust because your hand is greater than 21");
            System.out.println("You lose your wagered money.");
        }
        // Player gets blackjack and dealer doesn't - player wins
        else if (isPlayerHandBlackjack(player.getPlayerHand().getHandVal(), dealer.getDealerHand().getHandVal())) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString() + "\n");
            System.out.println("Blackjack. You win!");
            System.out.println("Your earnings: $" + player.getBet() * 2);
        }
        // Dealers hand greater than 21 - bust
        else if (isDealerHandBust(dealer.getDealerHand().getHandVal())) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString() + "\n");
            System.out.println("Dealer busts. You win!");
            System.out.println("Your earnings: $" + player.getBet() * 1.5);
        }
        // Player's hand closer to 21 than dealer's hand
        else if (player.getPlayerHand().compareTo(dealer.getDealerHand()) == 1) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString() + "\n");
            System.out.println("Your hand is better than dealer's hand, you win!");
            System.out.println("Your earnings: $" + player.getBet() * 1.5);
        }
        // Player's hand equal to dealer's hand
        else if (player.getPlayerHand().compareTo(dealer.getDealerHand()) == 0) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString() + "\n");
            System.out.println("Your hand is equal to dealer's hand. It's a draw.");
            System.out.println("You get back your bet amount of $" + player.getBet());
        }
        // Dealer's hand closer to 21 than player's hand
        else {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString() + "\n");
            System.out.println("Dealer's hand is better than your hand");
            System.out.println("You lose your wagered money. Better luck next time");
        }
    }
}