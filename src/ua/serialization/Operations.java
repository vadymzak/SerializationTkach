package ua.serialization;

import java.io.*;

public class Operations {

    public static void main(String[] args) {
        DataObject object = new DataObject();
        object.setMyData("hahaha");
        File file = new File("store.bin");

        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(file);
            ObjectOutputStream so = new ObjectOutputStream(fo);
            so.writeObject(object);
            so.flush();
            so.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream si = new ObjectInputStream(fi);
            DataObject objNew = (DataObject) si.readObject();
            si.close();
            System.out.println(objNew);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
