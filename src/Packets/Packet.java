package Packets;

public abstract class Packet {


    private String[] args;
    String header;

    public Packet(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getCraftedPacket(){
        StringBuilder returned = new StringBuilder(header);
        for (String arg : args) {
            returned.append(";").append(arg);
        }
        return returned.toString();
    }
}
