package dojo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class StdoutConnectorTest {

    @Test
    public void it_receives_bytes_and_writes_to_stdout() {

        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));


            //Given
            StdoutConnector connector = new StdoutConnector();

            //when
            connector.sendMessage("OB2".getBytes());

            //then
            String writtenString = new String(out.toByteArray());
            assertThat(writtenString).isEqualTo("OB2");
        } finally {
            System.setOut(originalOut);
        }

    }
}
