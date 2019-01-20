package pdp.io;

import java.io.Serializable;

public class SerializableImpl implements Serializable {
    private int i;
    private String srt;
    transient int ignored;

    public SerializableImpl(int i, String srt, int ignored) {
        this.i = i;
        this.srt = srt;
        this.ignored = ignored;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getSrt() {
        return srt;
    }

    public void setSrt(String srt) {
        this.srt = srt;
    }

    public int getIgnored() {
        return ignored;
    }

    public void setIgnored(int ignored) {
        this.ignored = ignored;
    }

    @Override
    public String toString() {
        return "SerializableImpl{" +
                "i=" + i +
                ", srt='" + srt + '\'' +
                ", ignored=" + ignored +
                '}';
    }
}
