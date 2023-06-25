package exp;

public class Exp1_9 {
    public static void main(String[] args) {
        double start = -1, end = 1; // 曲线的范围
        double area = calculateArea(start, end);
        System.out.println("面积为: " + area);
    }

    public static double calculateArea(double start, double end) {
        double deltaX = 0.0001; // 步长，用于控制求和的精度
        double sum = 0;
        for (double x = start; x <= end; x += deltaX) {
            double y1 = x * x;
            double y2 = 2 - x * x;
            double stripArea = deltaX * (y2 - y1);
            sum += stripArea;
        }
        return sum;
    }
}
