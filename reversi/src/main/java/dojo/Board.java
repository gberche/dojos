package dojo;

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
        return null;
	}


    private Coordinate getCellPositionFromCellArrayIndex(int index) {
        return new Coordinate(index/9, index%9);
    }

    protected char getCellAt(Coordinate cellPosition) {
        return cells[9*cellPosition.x + cellPosition.y];
    }


    private void markCellAsLegalMove(Coordinate cellPosition) {
        cells[9*cellPosition.x + cellPosition.y] = LEGAL_MOVE;
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
