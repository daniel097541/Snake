package Packets;

public class PointsPacket extends Packet{
    public PointsPacket(String[] args) {
        super(args);
        header = Headers.PTS.name();
    }
}
