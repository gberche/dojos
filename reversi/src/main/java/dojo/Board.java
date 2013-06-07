package dojo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 *
 */
public class Board {

    private char[] cells;

    protected static final char EMPTY_CELL = '.';
    protected static final char LEGAL_MOVE = '0';

    static final Coordinate N = new Coordinate(-1, 0);
    static final Coordinate S = new Coordinate(1, 0);
    static final Coordinate E = new Coordinate(0, -1);
    static final Coordinate W = new Coordinate(0, 1);
    static final Coordinate NE = new Coordinate(-1, -1);
    static final Coordinate SE = new Coordinate(1, 1);
    static final Coordinate SW = new Coordinate(1, -1);
    static final Coordinate NW = new Coordinate(-1, -1);

    private List<Coordinate> LEGAL_DIRECTIONS = asList(N, S, E, W, NE, SE, SW, NW);

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
        char currentPlayer = getCellAt(currentPlayerCell);
        List<Coordinate> legalMoves = new ArrayList<Coordinate>();

        List<Coordinate> directions = getLegalDirections();
        for (Coordinate direction : directions) {
            int contiguousOppositePiecesWithinLine = 0;
            Coordinate neighbor = currentPlayerCell;

            boolean neighborIsOppositePlayer;

            do  {
                neighbor = getNeighbor(neighbor, direction);
                neighborIsOppositePlayer = isOppositePlayer(getCellAt(neighbor), currentPlayer);
                if (neighborIsOppositePlayer) {
                    contiguousOppositePiecesWithinLine ++;
                }
            } while (neighbor != null && neighborIsOppositePlayer);

            if (contiguousOppositePiecesWithinLine >0 && neighbor!= null && getCellAt(neighbor)==EMPTY_CELL) {
                legalMoves.add(neighbor);
            }
        }
        return legalMoves;
    }


    protected Coordinate getNeighbor(Coordinate origin, Coordinate direction) {
        int x = origin.x + direction.x;
        int y = origin.y + direction.y;
        if (x<0 || x > 7 || y <0 || y > 7) {
            return null;
        }
        return new Coordinate(x, y);
    }

    protected List<Coordinate> getCurrentPlayerCells(char player) {
        List<Coordinate> positions = new ArrayList<Coordinate>();
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == player) {
                positions.add(getCellPositionFromCellArrayIndex(i));
            }
        }
        return positions;
    }

    private Coordinate getCellPositionFromCellArrayIndex(int index) {
        return new Coordinate(index/9, index%9);
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

    protected List<Coordinate> getLegalDirections() {
        return LEGAL_DIRECTIONS;
    }

    protected char getCellAt(Coordinate cellPosition) {
        return cells[9*cellPosition.x + cellPosition.y];
    }

    protected boolean isOppositePlayer(char cell, char currentPlayer) {
        if (cell == currentPlayer) {
            return false;
        }
        if (cell != LEGAL_MOVE && cell!= EMPTY_CELL) {
            return true;
        }
        return false;
    }

}
