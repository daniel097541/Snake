package Packets;

public class MovementPacket extends Packet{
    public MovementPacket(String[] args) {
        super(args);
        header = Headers.MOV.name();
    }
}
