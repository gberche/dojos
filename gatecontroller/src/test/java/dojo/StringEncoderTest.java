package dojo;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class StringEncoderTest {

    @Test
    public void it_encodes_as_default_platform_encoding_string() {
        StringEncoder stringEncoder = new StringEncoder();
        byte[] bytes = stringEncoder.encodeOpenGate();
        assertThat(bytes).isEqualTo("OB2".getBytes());
    }
}
