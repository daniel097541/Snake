package Packets;

public class ComunicationPacket extends Packet{

    public ComunicationPacket(String[] args) {
        super(args);
        header = Headers.IDC.name();
    }
}
