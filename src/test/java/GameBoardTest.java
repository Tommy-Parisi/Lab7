import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GameBoardTest {
    public static String boardString(int numRows, int numColumns){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col : ");
        for(int col = 0; col < numColumns; col++){
            boardString.append(col + " ");
        }
        boardString.append("\n");
        for(int row = 0; row < numRows; row++){
            boardString.append("Row : " + row + " ");
            for(int col = 0; col < numColumns; col++){
                boardString.append("-------" + " ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
    @Test
    public void testingBoard() {
        System.out.println("Testing Board Class");
        int numRows = 6;
        int numCols = 10;
        GameBoard testGameBoard = new GameBoard(numRows,numCols);
// print the GameBoard all spaces should be empty
        System.out.println(testGameBoard.toString());
        assertEquals(boardString(numRows,numCols),testGameBoard.toString());
        assertEquals(numRows,testGameBoard.getNumRows());
        assertEquals(numCols,testGameBoard.getNumCols());
        assertTrue(testGameBoard.inBounds(0,0));
        assertTrue(testGameBoard.inBounds(numRows-1, numCols-1));
        assertFalse(testGameBoard.inBounds(numRows, numCols));
        assertFalse(testGameBoard.inBounds(-1,-1));
// place some Units on the GameBoard
        Unit tj = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0, 4, 3, 1, 0, true, true, false);
        testGameBoard.getSquares()[0][0].setUnit(tj);
        Unit bart = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0, 5, 4, 2, 0, 0, true, true);
        testGameBoard.getSquares()[numRows-1][numCols-1].setUnit(bart);
        System.out.println(testGameBoard.toString());
// testing random empty space method
        BoardSquare emptySpace = testGameBoard.findRandomEmptySpace();
        assertTrue(emptySpace.isEmpty());
        assertNull(emptySpace.getUnit());
        emptySpace.setUnit(tj);
        emptySpace = testGameBoard.findRandomEmptySpace();
        assertTrue(emptySpace.isEmpty());
        assertNull(emptySpace.getUnit());
        emptySpace.setUnit(bart);
        System.out.println(testGameBoard.toString());
//spawn a Unit and place on the GameBoard
        Unit lilbart = bart.spawn();
        assertTrue(lilbart instanceof BartSimpsonUnit);
        testGameBoard.getSquares()[numRows-3][numCols-3].setUnit(lilbart);
        System.out.println(testGameBoard.toString());
    }
}
