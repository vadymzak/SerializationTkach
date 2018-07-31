package ua.serialization;

public class CustomObject {

    transient private boolean b;

    public CustomObject() {
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
