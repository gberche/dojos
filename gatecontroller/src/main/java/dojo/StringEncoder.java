package dojo;

/**
 *
 */
public class StringEncoder extends Encoder{
    @Override
    public byte[] encodeOpenGate() {
        return "OB2".getBytes();
    }
}
