package dojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Board {

    private char[] cells;

    protected static final char EMPTY_CELL = '.';
    protected static final char LEGAL_MOVE = '0';

    public void initBoard(String initialState) {
    	cells = initialState.toCharArray();
    }
    
	public String getNextLegalMoves(char currentPlayer) {
        Board boardWithLegalMoves = new Board();
        boardWithLegalMoves.initBoard(this.toString());

        List<Coordinate> positionList = getCurrentPlayerCells(currentPlayer);

        for (Coordinate currentPlayerCell : positionList) {
            List<Coordinate> cellPositions = getNextLegalMovesFromPosition(currentPlayerCell);

            boardWithLegalMoves.markCellsAsLegalMove(cellPositions);
        }
        return boardWithLegalMoves.toString();
	}

    protected List<Coordinate> getNextLegalMovesFromPosition(Coordinate currentPlayerCell) {
        return null;
    }

    protected List<Coordinate> getCurrentPlayerCells(char currentPlayer) {
        ArrayList<Coordinate> currentPlayerCells = new ArrayList<Coordinate>();
        for (int y=0; y<8; y++) {
            for (int x=0; x<8; x++) {
                Coordinate cellPosition = new Coordinate(x, y);
                if (getCellAt(cellPosition) == currentPlayer) {
                    currentPlayerCells.add(cellPosition);
                }
            }
        }
        return currentPlayerCells;
    }


    private Coordinate getCellPositionFromCellArrayIndex(int index) {
        return new Coordinate(index/9, index%9);
    }

    protected char getCellAt(Coordinate cellPosition) {
        return cells[cellPosition.x + 9*cellPosition.y];
    }


    private void markCellAsLegalMove(Coordinate cellPosition) {
        cells[cellPosition.x + 9*cellPosition.y] = LEGAL_MOVE;
    }

    protected void markCellsAsLegalMove(List<Coordinate> cellPositions) {
        for (Coordinate coordinate : cellPositions) {
            markCellAsLegalMove(coordinate);
        }
    }

    @Override
    public String toString() {
    	return new String(cells);
    }

}
