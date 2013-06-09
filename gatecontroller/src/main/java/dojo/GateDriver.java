package dojo;

/**
 *
 */
public class GateDriver {
    private Encoder encoder;
    private Connector connector;

    public void openGate() {
        byte[] bytes = encoder.encodeOpenGate();
        connector.sendMessage(bytes);
    }

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    public Encoder getEncoder() {
        return encoder;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public Connector getConnector() {
        return connector;
    }
}
