package exp;

import exp.Battery;

public class Radio {
    private static final int openComsuption = 10;

    public void openRadio(Battery battery) {
        System.out.println("收音机开始使用" + battery.getBrand());
        battery.setPercent(battery.getPercent() - openComsuption);
    }
}
