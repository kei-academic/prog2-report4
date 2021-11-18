package jp.ac.uryukyu.ie.e215730;

/**
 * 敵クラス。
 * String name; //敵の名前
 * int hitPoint; //敵のHP
 * int attack; //敵の攻撃力
 * boolean dead; //敵の生死状態．true=死亡．
 * @author kei-academic
 */
public class Enemy {
    private String name;

    /**
     * getNameメソッド．
     * フィールド値`name`を取り出す．
     * @return this.name - 自分自身のインスタンスの`name`フィールド
     */
    public String getName() {
        return this.name;
    }

    /**
     * setNameメソッド．
     * フィールド値`name`に値を代入する．
     * @param name 敵の名前
     */
    public void setName(String name) {
        this.name = name;
    }

    private int hitPoint;

    /**
     * getHitPointメソッド．
     * フィールド値`hitPoint`を取り出す．
     * @return this.hitPoint - 自分自身のインスタンスの`hitPoint`フィールド
     */
    public int getHitPoint() {
        return this.hitPoint;
    }

    /**
     * setHitPointメソッド．
     * フィールド値`hitPoint`に値を代入する．
     * @param hitPoint 敵のHP
     */
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    private int attack;

    /**
     * getAttackメソッド．
     * フィールド値`attack`を取り出す．
     * @return this.attack - 自分自身のインスタンスの`attack`フィールド
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * setAttackメソッド．
     * フィールド値`attack`に値を代入する．
     * @param attack 敵の攻撃力
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    private boolean dead;

    /**
     * isDeadメソッド．
     * フィールド値`dead`を取り出す．
     * @return this.dead - 自分自身のインスタンスの`dead`フィールド
     */
    public boolean isDead() {
        return this.dead;
    }

    /**
     * setDeadメソッド．
     * フィールド値`dead`に値を代入する．
     * @param dead 敵の生死状態．true=死亡．
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * コンストラクタ．名前，最大HP，攻撃力を指定する．
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド．
     * attackに応じて乱数でダメージを算出し，hero.wounded()によりダメージ処理を実行．
     * @param hero 攻撃対象
     */
    public void attack(Hero hero) {
        if (!(dead)) {
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド．
     * 指定されたダメージを hitPoint から引き，死亡判定を行う．
     * @param damage 受けたダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}