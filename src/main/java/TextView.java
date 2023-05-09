/**
 This class provides the text view for the player to enter their input and play the game
 @author
 Joey Dare
 @version 1.0
 */
import java.util.Scanner;

public class TextView {
        private int fromSquareRow;
        private int fromSquareCol;
        private int toSquareRow;
        private int toSquareCol;
        private char actionType;

        public int getFromSquareRow() {
            return this.fromSquareRow;
        }

        public int getFromSquareCol() {
            return this.fromSquareCol;
        }

        public int getToSquareRow() {
            return this.toSquareRow;
        }

        public int getToSquareCol() {
            return this.toSquareCol;
        }

        public char getActionType() {
            return this.actionType;
        }

        //Gets the players action
        public char getUsersNextActionType() {
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter action type (M, R, A, S): ");
            String input = scn.nextLine();
            input = input.toUpperCase();
            if (input.length() == 0 || ((input.charAt(0) != 'M') && (input.charAt(0) != 'R') && (input.charAt(0) != 'A') && (input.charAt(0) != 'S'))) {
                return getUsersNextActionType();
            }
            else {
                actionType = input.charAt(0);
                return input.charAt(0);
            }
        }
        //Checks for valid integer
        public int getValidInt(Game game) {
            Scanner scn = new Scanner(System.in);
            int value = 0;
            boolean valid = false;
            while (!valid) {
                try {
                    value = Integer.parseInt(scn.nextLine());
                    int max = game.getGameBoard().getNumRows();
                    if (value < 0 || value >= max) {
                        System.out.println("Invalid input. Enter a number between 0 and " + (max - 1) + ": ");
                    } else {
                        valid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a valid number: ");
                }
            }
            return value;
        }

        //Prompts player to get location of fromUnit and toUnit
        public void getNextPlayersAction(Game game) {
            char actionType = getUsersNextActionType();
            System.out.println("Enter the row your unit is on (0-" + (game.getGameBoard().getNumRows() - 1) + "): ");
            fromSquareRow = getValidInt(game);
            System.out.println("Enter the column your unit is on (0-" + (game.getGameBoard().getNumColumns() - 1) + "): ");
            fromSquareCol = getValidInt(game);
            System.out.println("Enter the row you want your unit to go (0-" + (game.getGameBoard().getNumRows() - 1) + "): ");
            toSquareRow = getValidInt(game);
            System.out.println("Enter the column you want your unit to go (0-" + (game.getGameBoard().getNumColumns() - 1) + "): ");
            toSquareCol = getValidInt(game);
        }

    public void updateView(Game game) {
        System.out.println(game);
    }

    //Prints result of game
    public void printEndOfGameMessage(Game game) {
        System.out.println("Game over. " + game.getCurrentPlayer().getTeam() + " wins!");
    }




}
