package controller;

import model.NhanVien;
import model.NhanVienFullTime;
import model.NhanVienPartTime;
import storage.NhanVienFromBinary;
import storage.iNhanVienData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static view.Client.creatFullTimeEmployee;
import static view.Client.creatPartTimeEmployee;

public class NhanVienManager  {
    public static final int AVERAGE_WAGE = 12000;
    public static iNhanVienData nhanVienData = new NhanVienFromBinary();
    public static ArrayList<NhanVien> nhanvienList = NhanVienFromBinary.saveFile;

    public static void showAllEmployeeFromFile(ArrayList<NhanVien> emp){
        try {
            nhanVienData.writeFile(emp);
            for (NhanVien nv : nhanvienList){
                System.out.println(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addEmployee(NhanVien newEmployee){
        nhanvienList.add(newEmployee);
        try {
            nhanVienData.writeFile(nhanvienList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addNewEmployeeFulltime(){
        NhanVienFullTime nhanVienFullTime = creatFullTimeEmployee();
        NhanVienManager.addEmployee(nhanVienFullTime);
    }
    public static void addNewEmployeePartTime(){
        NhanVienPartTime nhanVienPartTime = creatPartTimeEmployee();
        NhanVienManager.addEmployee(nhanVienPartTime);
    }
    public static void getNetSalary(ArrayList<NhanVien> emp){
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i) instanceof NhanVienFullTime){
               double netSalary =  ((NhanVienFullTime)emp.get(i)).getNetSalary();
               System.out.println(emp.get(i).getName() +" "+ netSalary);
            }else{
                double netSalary = ((NhanVienPartTime)emp.get(i)).getNetSalary();
                System.out.println(emp.get(i).getName() + " " + netSalary);
            }
        }
    }
    public static void showLowWageEmployee(ArrayList<NhanVien> emp){
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i) instanceof NhanVienFullTime){
                NhanVienFullTime empFullTime = (NhanVienFullTime) emp.get(i);
                if (empFullTime.getNetSalary() < AVERAGE_WAGE){
                    System.out.println(empFullTime);
                }
                
            }
        }
    }
    public static double showSumSalaryOfParttimeEmployee(ArrayList<NhanVien> emp){
        double sum = 0;
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i) instanceof NhanVienPartTime){
                sum += ((NhanVienPartTime) emp.get(i)).getNetSalary();
            }
        }return sum;
    }
    public static List<NhanVienFullTime>  getFullTimeEmployee(ArrayList<NhanVien> emp) {
        List<NhanVienFullTime> sortList = new ArrayList<>();
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i) instanceof NhanVienFullTime){
                sortList.add((NhanVienFullTime) emp.get(i));
            }
        }return sortList;
    }
    public static void sortFullTimeEmployee(List<NhanVienFullTime> emp){
        Collections.sort(emp, new Comparator<NhanVienFullTime>() {

            @Override
            public int compare(NhanVienFullTime o1, NhanVienFullTime o2) {
                return (int) (o1.getNetSalary() - o2.getNetSalary());
            }
        });for (NhanVienFullTime nv : emp ){
            System.out.println(nv);
        }
    }
}