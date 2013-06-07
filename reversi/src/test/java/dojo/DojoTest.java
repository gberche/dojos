package dojo;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class DojoTest {

    private static final char BLACK = 'B';
    Coordinate N = new Coordinate(-1, 0);
    Coordinate S = new Coordinate(1, 0);
    Coordinate W = new Coordinate(0, -1);
    Coordinate E = new Coordinate(0, 1);
    Coordinate NE = new Coordinate(-1, -1);
    Coordinate SE = new Coordinate(1, 1);
    Coordinate SW = new Coordinate(1, -1);
    Coordinate NW = new Coordinate(-1, -1);

    private static final String EXPECTED_STATE = "........\n" +
            "........\n" +
            "....0...\n" +
            "...BW0..\n" +
            "..0WB...\n" +
            "...0....\n" +
            "........\n" +
            "........";
    private static final String INITIAL_STATE ="........\n" +
            "........\n" +
            "........\n" +
            "...BW...\n" +
            "...WB...\n" +
            "........\n" +
            "........\n" +
            "........";

    Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void it_tells_the_next_legal_moves() {
        board.initBoard(INITIAL_STATE);
        String nextState = board.getNextLegalMoves(BLACK);
        assertThat(nextState).isEqualTo(EXPECTED_STATE);
    }

    @Test
    public void it_fetches_neighbor_cell_or_null_if_out_of_board() {
        assertThat(board.getNeighbor(new Coordinate(0,0), new Coordinate(0, 1))).isEqualTo(new Coordinate(0, 1));
        assertThat(board.getNeighbor(new Coordinate(0,0), new Coordinate(0, -1))).isNull();
        assertThat(board.getNeighbor(new Coordinate(0,0), new Coordinate(-1, 0))).isNull();
        assertThat(board.getNeighbor(new Coordinate(0,7), new Coordinate(0, 1))).isNull();
        assertThat(board.getNeighbor(new Coordinate(7,7), new Coordinate(0, 1))).isNull();
    }

    @Test
    public void it_computes_next_possible_moves_from_a_position() {
        board.initBoard(
                "........\n" +
                "........\n" +
                "........\n" +
                "...BW...\n" +
                "...WB...\n" +
                "........\n" +
                "........\n" +
                "........");
        Coordinate currentPlayerCell = new Coordinate(3, 3);
        List<Coordinate> expected = asList(new Coordinate(5, 3), new Coordinate(3, 5));
        assertThat(board.getNextLegalMovesFromPosition(currentPlayerCell)).isEqualTo(expected);
    }



    @Test
    public void it_compares_cells_content_to_determine_opposite_players() {
        assertThat(board.isOppositePlayer('B', 'B')).isFalse();
        assertThat(board.isOppositePlayer('W', 'W')).isFalse();
        assertThat(board.isOppositePlayer('B', 'W')).isTrue();
        assertThat(board.isOppositePlayer('W', 'B')).isTrue();
        assertThat(board.isOppositePlayer(Board.EMPTY_CELL, 'W')).isFalse();
        assertThat(board.isOppositePlayer(Board.EMPTY_CELL, 'W')).isFalse();
        assertThat(board.isOppositePlayer(Board.LEGAL_MOVE, 'W')).isFalse();
        assertThat(board.isOppositePlayer(Board.LEGAL_MOVE, 'B')).isFalse();
    }

    @Test
    public void it_defines_legal_directions() {
        List<Coordinate> legalDirections = board.getLegalDirections();

        assertThat(legalDirections).isEqualTo(asList(N, S, W, E, NE, SE, SW, NW));
    }

    @Test
    public void it_lists_current_player_cells() {
        board.initBoard(INITIAL_STATE);
        org.junit.Assert.assertEquals(asList(new Coordinate(3, 3), new Coordinate(4, 4)), board.getCurrentPlayerCells('B'));
    }

    @Test
    public void it_produces_outputs_in_same_format_as_input() {
        board.initBoard(INITIAL_STATE);
        org.junit.Assert.assertEquals(board.toString(),INITIAL_STATE);
    }

    @Test
    public void it_marks_cells_as_legal_move() {
        board.initBoard(INITIAL_STATE);
        board.markCellsAsLegalMove(asList(new Coordinate(1, 1), new Coordinate(2, 2), new Coordinate(0, 7)));
        org.junit.Assert.assertEquals(board.toString(),
        		".......0\n" +
                ".0......\n" +
                "..0.....\n" +
                "...BW...\n" +
                "...WB...\n" +
                "........\n" +
                "........\n" +
                "........");
    }

}
