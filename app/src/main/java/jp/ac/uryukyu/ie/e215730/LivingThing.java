package jp.ac.uryukyu.ie.e215730;

/**
 * LivingThingクラス．
 * String name; //LivingThingの名前
 * int hitPoint; //LivingThingのHP
 * int attack; //LivingThingの攻撃力
 * boolean dead; //LivingThingの生死状態．true=死亡．
 * @author kei-academic
 */
public abstract class LivingThing {
    private String name;
    /**
     * フィールド name のgetterメソッド．
     * @return 自身の名前
     */
    public String getName() {
        return this.name;
    }
    /**
     * フィールド name のsetterメソッド．
     */
    public void setName(String name) {
        this.name = name;
    }


    private int hitPoint;
    /**
     * フィールド hitPoint のgetterメソッド．
     * @return 自身のHP
     */
    public int getHitPoint() {
        return this.hitPoint;
    }
    /**
     * フィールド hitPoint の setterメソッド．
     */
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }


    private int attack;
    /**
     * フィールド attack のgetterメソッド．
     * @return 自身の攻撃力
     */
    public int getAttack() {
        return this.attack;
    }
    /**
     * フィールド attack のsetterメソッド．
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }


    private boolean dead;
    /**
     * フィールド dead のgetterメソッド．
     * @return 自身の生死状態
     */
    public boolean isDead() {
        return this.dead;
    }
    /**
     * フィールド dead のsetterメソッド．
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }


    /**
     * コンストラクタ．名前，最大HP，攻撃力を指定する．
     * @param name LivingThingの名前
     * @param maximumHP LivingThingの最大HP
     * @param attack LivingThingの攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    /**
     * LivingThingへ攻撃するメソッド．
     * attackに応じて乱数でダメージを算出し，opponent.wounded()によりダメージ処理を実行．
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent) {
        if (!dead) {
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }


    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド．
     * 指定されたダメージを hitPoint から引き，死亡判定を行う．
     * @param damage 受けたダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
