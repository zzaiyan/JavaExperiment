package exp;

public class Exp2_1 {
    public static void main(String[] args) {
        AppConfig obj1 = AppConfig.getInstance();
        obj1.showMessage();
        obj1.showAddress();
        AppConfig obj2 = AppConfig.getInstance();
        obj2.showMessage();
        obj2.showAddress();
    }
}

class AppConfig{
    private AppConfig(){
        System.out.println("AppConfig Constructed.");
    }
    private static final AppConfig instance = new AppConfig();

    public static AppConfig getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("showMessage() calls.");
    }

    public void showAddress(){
        System.out.println(this);
    }
}
