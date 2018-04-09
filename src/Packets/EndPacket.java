package Packets;

public class EndPacket extends Packet{
    public EndPacket(String[] args) {
        super(args);
        header = Headers.FIN.name();
    }
}
