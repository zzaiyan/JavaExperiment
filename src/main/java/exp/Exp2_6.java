package exp;

import java.util.ArrayList;

public class Exp2_6 {
    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 3; i++) {
            String name = "玩家" + (i + 1);
            People p = new People(name);
            game.addPeople(p);
            game.showPopulation();
        }
        game.showPeople();
    }
}

class People {
    String name;

    public People(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}


class Game {
    ArrayList<People> list = new ArrayList<>();

    void addPeople(People people) {
        System.out.println(people.name + " 加入游戏，");
        this.list.add(people);
    }

    void showPopulation() {
        System.out.println("当前共有：" + list.size() + "人");
    }

    void showPeople() {
        System.out.println("\n当前场上有以下玩家：\n" + list);
    }
}
