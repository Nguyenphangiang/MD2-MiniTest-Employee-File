package storage;


import model.NhanVien;

import java.util.ArrayList;

public interface iNhanVienData {
    ArrayList<NhanVien> readFile();
    void writeFile(ArrayList<NhanVien> arrayList)throws Exception;
}
