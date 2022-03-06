package model;

public class NhanVienFullTime extends NhanVien implements iNetSalary{
    private double bonus;
    private double fineMoney;
    private double baseSalary;

    public NhanVienFullTime(String id, String name, int age, int phone, String email, double bonus, double fineMoney, double baseSalary) {
        super(id, name, age, phone, email);
        this.bonus = bonus;
        this.fineMoney = fineMoney;
        this.baseSalary = baseSalary;
    }

    public NhanVienFullTime(double bonus, double fineMoney, double baseSalary) {
        this.bonus = bonus;
        this.fineMoney = fineMoney;
        this.baseSalary = baseSalary;
    }

    public NhanVienFullTime() {
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFineMoney() {
        return fineMoney;
    }

    public void setFineMoney(double fineMoney) {
        this.fineMoney = fineMoney;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "model.NhanVienFullTime{" + super.toString() +
                "bonus=" + bonus +
                ", fineMoney=" + fineMoney +
                ", baseSalary=" + baseSalary +
                '}';
    }

    @Override
    public double getNetSalary() {
        return baseSalary + (bonus - fineMoney);
    }
}
