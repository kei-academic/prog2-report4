package jp.ac.uryukyu.ie.e215730;

public class Main2 {
    public static void main(String[] args) {
        Hero hero = new Warrior("勇者", 10, 5); // (a)
        // Warrior hero = new Hero("勇者", 10, 5); // (2)で(a)の代わりに使用．
        Enemy enemy = new Enemy("スライム", 6, 3);

        System.out.printf("%s vs. %s\n", hero.getName(), enemy.getName());

        int turn = 0;
        while(hero.isDead() == false && enemy.isDead() == false) {
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy); // (b)
            // hero.attackWithWeponSkill(enemy); // (4)で(b)の代わりに使用．
            enemy.attack(hero);
        }
        System.out.println("戦闘終了");
        // System.out.println(hero); // (5)で使用．
    }
}