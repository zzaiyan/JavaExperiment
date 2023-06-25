package exp;

public class Exp2_4 {
    public static void main(String[] args) {
        Battery nanfu = new Battery("南孚电池");
        Radio radio = new Radio();
        nanfu.showPercent();
        radio.openRadio(nanfu);
        nanfu.showPercent();
    }
}


