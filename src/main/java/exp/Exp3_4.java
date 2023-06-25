package exp;

public class Exp3_4 {
    public static void main(String[] args) {
        SimpleDoor door = new SimpleDoor();
        SimpleAlarm alarm = new SimpleAlarm();
        AlarmDoor doorAlarm = new AlarmDoor();

        testDoor(door);
        testAlarm(alarm);
        testDoor(doorAlarm);
        testAlarm(doorAlarm);
    }

    public static void testDoor(Door door) {
        door.open();
        door.close();
        System.out.println("---------------------");
    }

    public static void testAlarm(Alarm alarm) {
        alarm.alarm();
        System.out.println("---------------------");
    }
}

// 门接口
interface Door {
    void open();

    void close();
}

// 警铃接口
interface Alarm {
    void alarm();
}

// 门类
class SimpleDoor implements Door {
    public void open() {
        System.out.println("SimpleDoor is opened.");
    }

    public void close() {
        System.out.println("SimpleDoor is closed.");
    }
}

// 警铃类
class SimpleAlarm implements Alarm {
    public void alarm() {
        System.out.println("SimpleAlarm is ringing.");
    }
}

// 带警铃的门类
class AlarmDoor implements Door, Alarm {
    public void open() {
        System.out.println("AlarmDoor is opened.");
    }

    public void close() {
        System.out.println("AlarmDoor is closed.");
    }

    public void alarm() {
        System.out.println("AlarmDoor is ringing.");
    }
}