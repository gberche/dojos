package dojo;

/**
 *
 */
public class StdoutConnector extends Connector{

    @Override
    public void sendMessage(byte[] message) {
        System.out.print(new String(message));
    }
}
