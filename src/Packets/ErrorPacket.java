package Packets;

public class ErrorPacket extends Packet{
    public ErrorPacket(String[] args) {
        super(args);
        this.header = Headers.ERR.name();
    }
}
