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
        return null;
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
