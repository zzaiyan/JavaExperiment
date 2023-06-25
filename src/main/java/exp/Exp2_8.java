package exp;

public class Exp2_8 {
    public static void main(String[] args) {
        Student student = new Student();
        // setter
        student.setName("张三");
        student.setNumber(12345);
        student.setScore(90.53);
        // getter
        System.out.println("Name: " + student.getName());
        System.out.println("Number: " + student.getNumber());
        System.out.println("Score: " + student.getScore());
    }
}

class Student {
    private String name;
    private int number;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
