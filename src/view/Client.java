package view;

import controller.NhanVienManager;
import model.NhanVien;
import model.NhanVienFullTime;
import model.NhanVienPartTime;
import storage.NhanVienFromBinary;

import java.util.ArrayList;
import java.util.Scanner;



public class Client {
 private static ArrayList<NhanVien> nhanVienClient = NhanVienFromBinary.saveFile;

    public static void main(String[] args) {
        NhanVienFullTime nhanVienFullTime1 = new NhanVienFullTime("f01","Nguyễn Văn A",25,111,"a@gmail.com",1000,500,10000);
        NhanVienFullTime nhanVienFullTime2 = new NhanVienFullTime("f02","Nguyễn Văn B",26,112,"b@gmail.com",2000,0,11000);
        NhanVienFullTime nhanVienFullTime3 = new NhanVienFullTime("f03","Nguyễn Văn C",27,113,"c@gmail.com",1500,0,10000);

        NhanVienPartTime nhanVienPartTime1 = new NhanVienPartTime("p01","Lê Văn A",20,211,"d@gmail.com",40);
        NhanVienPartTime nhanVienPartTime2 = new NhanVienPartTime("p02","Lê Văn B",21,212,"e@gmail.com",45);
        NhanVienPartTime nhanVienPartTime3 = new NhanVienPartTime("p03","Lê Văn C",22,213,"f@gmail.com",48);

        nhanVienClient.add(nhanVienFullTime1);nhanVienClient.add(nhanVienPartTime1);
        nhanVienClient.add(nhanVienFullTime2);nhanVienClient.add(nhanVienPartTime2);
        nhanVienClient.add(nhanVienFullTime3);nhanVienClient.add(nhanVienPartTime3);
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    1.Thêm Nhân Viên Mới FullTime.
                    2.Thêm Nhân Viên Mới Parttime.
                    3.Hiển thị tất cả nhân viên từ file.
                    4.Hiển thị lương thực lĩnh của nhân viên.
                    5.Hiển thị lương dưới trung bình của nhân viên toàn thời gian.
                    6.Hiển thị tổng lương phải trả cho nhân viên bán thời gian.
                    7.Hiển thị danh sách nhiên viên toàn thời gian theo lương tăng dần.
                    8.Thoát.
                     Xin hãy lựa chọn!!""");
            choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    NhanVienManager.addNewEmployeeFulltime();
                    break;
                case 2:
                    NhanVienManager.addNewEmployeePartTime();
                    break;
                case 3:
                    NhanVienManager.showAllEmployeeFromFile(nhanVienClient);
                    break;
                case 4 :
                    NhanVienManager.getNetSalary(nhanVienClient);
                    break;
                case 5 :
                    NhanVienManager.showLowWageEmployee(nhanVienClient);
                    break;
                case 6 :
                    double allMoney = NhanVienManager.showSumSalaryOfParttimeEmployee(nhanVienClient);
                    System.out.println("Tổng tiền phải trả : " + allMoney);
                    break;
                case 7 :
                    NhanVienManager.sortFullTimeEmployee(NhanVienManager.getFullTimeEmployee(nhanVienClient));
                    break;
            }
        }while (choice != 8);
    }

    public static  NhanVienFullTime creatFullTimeEmployee (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID Nhân Viên: ");
        String idEmployeeFullTime = sc.nextLine();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập Tên Nhân Viên: ");
        String nameEmployeeFullTime = sc1.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Nhập Tuổi Nhân Viên: ");
        int ageEmployeeFullTime = sc2.nextInt();
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Nhập Phone Nhân Viên: ");
        int phoneEmployeeFullTime = sc3.nextInt();
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Nhập Email Nhân Viên: ");
        String emailEmployeeFullTime = sc4.nextLine();
        Scanner sc5 = new Scanner(System.in);
        System.out.println("Nhập Tiền Thưởng Nhân Viên: ");
        double bonusEmployeeFullTime = sc5.nextDouble();
        Scanner sc6 = new Scanner(System.in);
        System.out.println("Nhập Tiền Phạt Nhân Viên: ");
        double fineEmployeeFullTime = sc6.nextDouble();
        Scanner sc7 = new Scanner(System.in);
        System.out.println("Nhập lương cứng Nhân Viên: ");
        double salaryEmployeeFullTime = sc7.nextDouble();
        NhanVienFullTime nhanVienFullTime = new NhanVienFullTime(idEmployeeFullTime,nameEmployeeFullTime,
                ageEmployeeFullTime,phoneEmployeeFullTime,
                emailEmployeeFullTime,bonusEmployeeFullTime,fineEmployeeFullTime,salaryEmployeeFullTime);
        return nhanVienFullTime;
    }
    public static NhanVienPartTime creatPartTimeEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID Nhân Viên: ");
        String idPartTimeEmployee = sc.nextLine();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập Tên Nhân Viên: ");
        String namePartTimeEmployee = sc1.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Nhập Tuổi Nhân Viên: ");
        int agePartTimeEmployee = sc2.nextInt();
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Nhập Phone Nhân Viên: ");
        int phonePartTimeEmployee = sc3.nextInt();
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Nhập Email Nhân Viên: ");
        String emailPartTimeEmployee = sc4.nextLine();
        Scanner sc5 = new Scanner(System.in);
        System.out.println("Nhập Số Giờ Làm Việc Nhân Viên: ");
        double workHourPartTimeEmployee = sc4.nextDouble();
        NhanVienPartTime nhanVienPartTime = new NhanVienPartTime(idPartTimeEmployee,namePartTimeEmployee
                ,agePartTimeEmployee,phonePartTimeEmployee
                ,emailPartTimeEmployee,workHourPartTimeEmployee);
        return nhanVienPartTime;
    }

}
