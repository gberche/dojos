package dojo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class GateControllerTest {

    @Test
    public void it_receives_open_gate_request_and_writes_to_stdout() {

        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            GateController gateController = new GateController();
            gateController.openGate();


            String writtenString = new String(out.toByteArray());

            assertThat(writtenString).isEqualTo("OB2");
        } finally {
            System.setOut(originalOut);
        }
    }
}
