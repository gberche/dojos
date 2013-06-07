package dojo;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class DojoTest {

    private static final char BLACK = 'B';
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
