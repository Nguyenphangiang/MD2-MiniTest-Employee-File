package model;

public class NhanVienPartTime extends NhanVien implements iNetSalary{
    private double workHour;

    public NhanVienPartTime() {
    }

    public NhanVienPartTime(String id, String name, int age, int phone, String email, double workHour) {
        super(id, name, age, phone, email);
        this.workHour = workHour;
    }

    public NhanVienPartTime(double workHour) {
        this.workHour = workHour;
    }

    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    @Override
    public String toString() {
        return "model.NhanVienPartTime{" + super.toString() +
                "workHour=" + workHour +
                '}';
    }

    @Override
    public double getNetSalary() {
        return workHour* 100;
    }
}
