package Packets;

public class DirectionPacket extends Packet{

    public DirectionPacket(String[] args) {
        super(args);
        header = Headers.DIR.name();
    }
}
