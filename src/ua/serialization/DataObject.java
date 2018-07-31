package ua.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class DataObject extends NonSerializable implements Serializable {

    private int i = 5;

    private String s = "aaa";

    transient private String[] def = {"aaa", "bbb", "cccc"};

    private CustomObject customObject = new CustomObject();

    public DataObject() {
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String[] getDef() {
        return def;
    }

    public void setDef(String[] def) {
        this.def = def;
    }

    public CustomObject getCustomObject() {
        return customObject;
    }

    public void setCustomObject(CustomObject customObject) {
        this.customObject = customObject;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", def=" + Arrays.toString(def) +
                ", customObject=" + customObject +
                ", getMyData=" + getMyData() +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeObject(getMyData());

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        setMyData((String)in.readObject());
    };
}
