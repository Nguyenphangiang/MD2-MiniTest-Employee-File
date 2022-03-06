package storage;

import model.NhanVien;
import storage.iNhanVienData;

import java.io.*;
import java.util.ArrayList;

public class NhanVienFromBinary implements iNhanVienData {
    public static final String SAVE_PATH = "nhanvien.dat";
    public static NhanVienFromBinary tool = new NhanVienFromBinary();
    public static ArrayList<NhanVien> saveFile = tool.readFile();
    @Override
    public ArrayList<NhanVien> readFile() {
        ArrayList<NhanVien> tempList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(SAVE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            tempList = (ArrayList<NhanVien>) result;
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tempList;
    }

    @Override
    public void writeFile(ArrayList<NhanVien> arrayList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(SAVE_PATH);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("Lỗi ghi file");
        }
    }
}
