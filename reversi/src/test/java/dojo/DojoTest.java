package dojo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
    @Ignore
    public void it_tells_the_next_legal_moves() {
        board.initBoard(INITIAL_STATE);
        String nextState = board.getNextLegalMoves(BLACK);
        assertThat(nextState).isEqualTo(EXPECTED_STATE);
    }

    @Test
    public void guides_get_the_next_legal_moves() {
        board = Mockito.spy(board);
        board.initBoard(
                "........\n" +
                "........\n" +
                "........\n" +
                "...BW...\n" +
                "...WB...\n" +
                "........\n" +
                "........\n" +
                "........");
        when(board.getCurrentPlayerCells(BLACK)).thenReturn(asList(new Coordinate(3, 3), new Coordinate(4, 4)));
        when(board.getNextLegalMovesFromPosition(new Coordinate(3, 3))).thenReturn(
                asList(new Coordinate(3, 5), new Coordinate(5, 3)));
        when(board.getNextLegalMovesFromPosition(new Coordinate(4, 4))).thenReturn(
                asList(new Coordinate(4, 2), new Coordinate(2, 4)));

        //when
        String nextState = board.getNextLegalMoves(BLACK);
        assertThat(nextState).isEqualTo(
                "........\n" +
                "........\n" +
                "....0...\n" +
                "...BW0..\n" +
                "..0WB...\n" +
                "...0....\n" +
                "........\n" +
                "........");
    }


    @Test
    public void it_produces_outputs_in_same_format_as_input() {
        board.initBoard(INITIAL_STATE);
        org.junit.Assert.assertEquals(board.toString(),INITIAL_STATE);
    }

    @Test
    public void it_fetches_cells() {
        board.initBoard(
                "1......7\n" +
                "2.......\n" +
                "........\n" +
                "...BW...\n" +
                "...WB...\n" +
                "........\n" +
                "........\n" +
                "8......9");

        assertThat(board.getCellAt(new Coordinate(0,0))).isEqualTo('1');
        assertThat(board.getCellAt(new Coordinate(0,7))).isEqualTo('8');
        assertThat(board.getCellAt(new Coordinate(0,1))).isEqualTo('2');
        assertThat(board.getCellAt(new Coordinate(7,0))).isEqualTo('7');
        assertThat(board.getCellAt(new Coordinate(7,7))).isEqualTo('9');

    }

    @Test
    public void it_marks_cells_as_legal_move() {
        board.initBoard(INITIAL_STATE);
        board.markCellsAsLegalMove(asList(new Coordinate(0, 0), new Coordinate(1, 1), new Coordinate(2, 2), new Coordinate(0, 7)));
        org.junit.Assert.assertEquals(board.toString(),
        		"0.......\n" +
                ".0......\n" +
                "..0.....\n" +
                "...BW...\n" +
                "...WB...\n" +
                "........\n" +
                "........\n" +
                "0.......");
    }

}
