package exp;

public class Exp3_3 {
    public static void main(String[] args) {
        // 创建用户
        NormalUser user1 = new NormalUser();
        VIPUser user2 = new VIPUser();
        TrailUser user3 = new TrailUser();
        // 测试功能
        user1.normal();
        user2.VIP();
        user3.normal();
        user3.VIP();
    }
}

interface NormalConsume {
    void normal();
}

interface VIPConsume {
    void VIP();
}

class NormalUser implements NormalConsume{
    public void normal() {
        System.out.println("NormalUser consumes in NormalRestaurant.");
    }
}

class VIPUser implements VIPConsume{
    public void VIP(){
        System.out.println("VIPUser consumes in VIPRestaurant.");
    }
}

class TrailUser implements NormalConsume, VIPConsume{
    public void normal() {
        System.out.println("TrailUser consumes in NormalRestaurant.");
    }

    public void VIP(){
        System.out.println("TrailUser consumes in VIPRestaurant.");
    }
}
