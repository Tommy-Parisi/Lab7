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

        public char getUsersNextActionType() {
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter action type (M, R, A, S): ");
            String input = scn.nextLine();
            if (input.length() == 0 || (!(input.equals('M'))) || (!(input.equals('R'))) || (!(input.equals('A'))) || (!(input.equals('S')))) {
                return getUsersNextActionType();
            }
            return input.charAt(0);
        }

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

    public void printEndOfGameMessage(Game game) {
        System.out.println("Game over. " + game.getCurrentPlayer().getTeam() + " wins!");
    }




}
