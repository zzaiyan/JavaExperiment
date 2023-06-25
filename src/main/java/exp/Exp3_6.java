/*  input
5
1 运动鞋 Adidas 300.80 10
2 蓝球服 李宁 268.00 10
3 苹果 栖霞 5.00 500
4 智能手表 苹果 4888.00 10
5 鼠标 罗技 120.00 50
9
1 5 1
3 5 1
4 1 1
3 2 2
5 2 1
1 2 1
5 0 3
3 1 1
3 5 2
 */
package exp;

import java.util.*;

public class Exp3_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 哈希表，记录商品ID
        Map<Integer, Product> products = new HashMap<>();
        // 读取商品数量
        int numProducts = scanner.nextInt();
        for (int i = 0; i < numProducts; i++) {
            // 读取商品信息
            int id = scanner.nextInt();
            String name = scanner.next();
            String manufacturer = scanner.next();
            double price = scanner.nextDouble();
            int stock = scanner.nextInt();
            Product product = new Product(id, name, manufacturer, price, stock);
            products.put(id, product);
        }
        System.out.println("商品信息读取完毕。");

        // 购物车
        ShoppingCart cart = new ShoppingCart();
        // 交易数量
        int numActions = scanner.nextInt();
        for (int i = 0; i < numActions; i++) {
            // 读取交易内容
            int ID = scanner.nextInt();
            int num = scanner.nextInt();
            int how = scanner.nextInt();
            // 由商品ID获取商品对象
            Product product = products.get(ID);

            if (how == 1) {
                cart.addToCart(product, num);
            } else if (how == 2) {
                cart.removeFromCart(product, num);
            } else if (how == 3) {
                cart.removeFromCart(product, cart.getTotalNum());
            }
        }
        System.out.println("交易信息读取完毕。");

        System.out.println(cart.getTotalNum());
        cart.printCartItems(products);
        System.out.println(cart.getTotalPrice(products));

        scanner.close();
    }
}


class Product {
    private int id;
    private String name;
    private String maker;
    private double price;
    private int num;

    public Product(int id, String name, String maker, double price, int num) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMaker() {
        return maker;
    }

    public double getPrice() {
        return price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class ShoppingCart {
    private Map<Integer, Integer> cartItems = new HashMap<>();

    public void addToCart(Product product, int Num) {
        int productId = product.getId();
        int currentNum = cartItems.getOrDefault(productId, 0);
        cartItems.put(productId, currentNum + Num);
        product.setNum(product.getNum() - Num);
    }

    public void removeFromCart(Product product, int Num) {
        int productId = product.getId();
        int currentNum = cartItems.getOrDefault(productId, 0);
        int newNum = currentNum - Num;
        if (newNum <= 0) {
            cartItems.remove(productId);
            newNum = 0;
        } else {
            cartItems.put(productId, newNum);
        }
        product.setNum(product.getNum() + Num);
    }

    public int getTotalNum() {
        return cartItems.size();
    }

    public double getTotalPrice(Map<Integer, Product> products) {
        double totalPrice = 0.0;
        for (int productId : cartItems.keySet()) {
            Product product = products.get(productId);
            int num = cartItems.get(productId);
            double price = product.getPrice();
            totalPrice += price * num;
        }
        return totalPrice;
    }

    public void printCartItems(Map<Integer, Product> products) {
        for (int productId : cartItems.keySet()) {
            Product product = products.get(productId);
            int Num = cartItems.get(productId);
            System.out.println(product.getId() + " " + product.getName() + " " + product.getMaker() + " " + product.getPrice() + " " + product.getNum() + " " + Num);
        }
    }
}
