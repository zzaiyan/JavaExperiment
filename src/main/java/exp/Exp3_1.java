package exp;

public class Exp3_1 {
    public static void main(String[] args) {
        MobileShop shop = new MobileShop("测试店铺");
        shop.promoteProducts();
    }
}

class MobileShop {
    private String shopName;

    public MobileShop(String shopName) {
        this.shopName = shopName;
    }

    public void promoteProducts() {
        InnerPurchaseMoney purchaseMoney = new InnerPurchaseMoney();
        System.out.println("欢迎来到 " + shopName);
        // 使用购物券购买商品
        System.out.println("使用折扣券，");
        double discount = purchaseMoney.getDiscount();
        System.out.println("折扣力度 " + discount + "%");
    }

    private class InnerPurchaseMoney {
        // 假设购物券提供10%的折扣
        private double discount = 10.0;

        public double getDiscount() {
            return discount;
        }
    }
}