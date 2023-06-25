package exp;

public class Exp2_5 {
    public static void main(String[] args) {
        SIM sim1 = new SIM("13333333333");
        MobileTelephone phone = new MobileTelephone(sim1);
        System.out.println(phone.getNumber());
        SIM sim2 = new SIM("13555555555");
        phone.setSIM(sim2);
        System.out.println(phone.getNumber());
    }
}
