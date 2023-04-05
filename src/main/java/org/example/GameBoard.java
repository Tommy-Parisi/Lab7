package org.example;
/**
 * This class is for creating the Game Board
 * @Author Joey Dare & Tommy Parisi
 * @Version 1.0
 */
public class GameBoard {
    private int numRow;
    private int numCol;
    private BoardSquare[][] squares;
    /**
     * This constructor creates the Game Board using two-dimensional array with numRows and numCols
     * Sets properties numRow, numCol to the numbers passed and sets squares to the 2D Array created
     * @param numRows sets the number of rows on the game board
     * @param numCols sets the number of columns on the game board
     */
    public GameBoard(int numRows, int numCols) {
        this.numRow = numRows;
        this.numCol = numCols;
        this.squares = new BoardSquare[numRows][numCols];
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                this.squares[i][j] = new BoardSquare("");
            }
        }
        setUpEmptyBoard();
    }
    //Returns the number of rows on game board
    public int getNumRows() {
        return this.numRow;
    }
    //Returns the number of columns on game board
    public int getNumColumns() {
        return this.numCol;
    }
    //Returns the squares 2D Array
    public BoardSquare[][] getSquares() {
        return this.squares;
    }
    /**
     * This method accepts row index and column index and returns a boolean value
     *representing whether the location of this space is within the bounds of the board
     * @param rowIndex the row location on the game board
     * @param colIndex the column location on the game board
     * @return boolean true if within bounds, false if not
     */
    public boolean inBounds(int rowIndex, int colIndex) {
        if ((rowIndex >= 0 && rowIndex < getNumRows()) && (colIndex >= 0 && colIndex < getNumColumns())) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is used to create an empty board with alternating colors "red" and "black"
     */
    private void setUpEmptyBoard() {
        for (int i=0; i < this.numRow; ++i) {
            for (int j=0; j < this.numCol; ++j) {
                if ((i + j) % 2 == 0) {
                    squares[i][j] = new BoardSquare("red");
                }
                else {
                    squares[i][j] = new BoardSquare("black");
                }
            }
        }
    }

    /**
     * This method finds a random empty space on the game board
     * @return a BoardSquare that is empty on the game board
     */
    public BoardSquare findRandomEmptySpace() {
        BoardSquare square = null;
        while (square == null || !square.isEmpty()) {
            square = this.squares[(int) (Math.random() * getNumRows())][(int) Math.random() * getNumColumns()];
        }
        return square;
    }

    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col : ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + " ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + " ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + " ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
