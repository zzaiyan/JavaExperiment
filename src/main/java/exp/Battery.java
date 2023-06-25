package exp;

public class Battery {
    private int percent = 100;
    private String brand;

    public Battery(String brand) {
        this.brand = brand;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getBrand() {
        return brand;
    }

    public void showPercent() {
        System.out.println(brand + "的电量为：" + percent);
    }
}
