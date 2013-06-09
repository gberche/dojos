package dojo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 */
public class GateDriverTest {

    @Test
    public void it_receives_open_gate_request_and_writes_to_stdout() {

        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));


            //Given
            Encoder encoder = mock(Encoder.class);
            Connector connector = mock(Connector.class);

            byte[] openGateBytes = "OB2".getBytes();
            when(encoder.encodeOpenGate()).thenReturn(openGateBytes);

            GateDriver gateDriver = new GateDriver();
            gateDriver.setEncoder(encoder);

            //when
            gateDriver.openGate();

            //then
            String writtenString = new String(out.toByteArray());
            verify(encoder.encodeOpenGate());
            verify(connector).sendMessage(openGateBytes);

            assertThat(writtenString).isEqualTo("OB2");
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void guiding_test() {
        //Given
        Encoder encoder = mock(Encoder.class);
        Connector connector = mock(Connector.class);

        byte[] openGateBytes = "OB2".getBytes();
        when(encoder.encodeOpenGate()).thenReturn(openGateBytes);

        GateDriver gateDriver = new GateDriver();
        gateDriver.setEncoder(encoder);
        gateDriver.setConnector(connector);

        //when
        gateDriver.openGate();

        //then
        verify(encoder).encodeOpenGate();
        verify(connector).sendMessage(openGateBytes);
    }
}
