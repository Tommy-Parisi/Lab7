public class GameBoard {
    private int numRow;
    private int numCol;
    private BoardSquare[][] squares;

    public GameBoard(int numRows, int numCols) {
        this.numRow = numRows;
        this.numCol = numCols;
        this.squares = new BoardSquare[numRows][numCols];
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
        this.squares = new BoardSquare[i][j];
            }
        }
        setUpEmptyBoard();
    }
    public int getNumRows() {
        return this.numRow;
    }
    public int getNumCols() {
        return this.numCol;
    }
    public BoardSquare[][] getSquares() {
        return this.squares;
    }
    public boolean inBounds(int rowIndex, int colIndex) {
        if ((rowIndex >= 0 && rowIndex < getNumRows()) && (colIndex >= 0 && colIndex < getNumCols())) {
            return true;
        }
        else {
            return false;
        }
    }
    private void setUpEmptyBoard() {
        for (int i=0; i < this.numRow; ++i) {
            for (int j=0; j < this.numCol; ++j) {
                if ((i + j) % 2 == 0) {
                    squares[i][j] = new BoardSquare("white");
                }
                else {
                    squares[i][j] = new BoardSquare("black");
                }
            }
        }
    }
    public BoardSquare findRandomEmptySpace() {
        BoardSquare square = null;
        while (square == null || !square.isEmpty()) {
            square = this.squares[(int) (Math.random() * getNumRows())][(int) Math.random() * getNumCols()];
        }
        return square;
    }
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}
