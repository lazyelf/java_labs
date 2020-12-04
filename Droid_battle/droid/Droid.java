package com.lazyelf.droid;

import com.lazyelf.Rand;

public class Droid {
    protected final String name;
    protected int hp;
    protected int damage;
    protected int heal;
    protected int tactic;
    protected int steal;
    protected int buff;
    protected int debuff;
    protected int selfDestroy;
    protected int fightSpirit;
    protected int[] arcitecture;

    public Droid(String name) {
        if (name.equals("")) {
            this.name = "Droid" + Rand.rand(1, 1000);
        } else {
            this.name = name;
        }

        hp = Rand.rand(1000, 1500);
        damage = Rand.rand(70, 150);
        heal = Rand.rand(1, 5);
        tactic = Rand.rand(1, 5);
        steal = Rand.rand(1, 5);
        buff = Rand.rand(1, 10);
        debuff = Rand.rand(1, 10);
        selfDestroy = Rand.rand(1, 3);
        fightSpirit = 70;
        int[] buf = {hp, damage, heal, tactic, steal, buff, debuff, selfDestroy, fightSpirit};
        arcitecture = new int[9];
        System.arraycopy(buf, 0, arcitecture, 0, 9);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void increaseHP(int hp) {
        this.hp += hp;
    }

    public void decreaseHP(int hp) {
        this.hp -= hp;
    }

    public void increaseDamage(int damage) {
        this.damage += damage;
    }

    public void decreaseDamage(int damage) {
        this.damage -= damage;
    }

    protected void set(int number) {
        switch (number) {
            case 1:
                hp += (int) (0.2 * hp + 0.5);
                break;
            case 2:
                damage += (int) (0.2 * damage + 0.5);
                break;
            case 3:
                heal += 20;
                break;
            case 4:
                tactic += 20;
                break;
            case 5:
                steal += 15;
                break;
            case 6:
                buff += 15;
                break;
            case 7:
                debuff += 15;
                break;
            case 8:
                selfDestroy += 20;
                break;
            case 9:
                fightSpirit += 20;
                break;

        }

    }

    public void setDroid(int characteristic1, int characteristic2, int characteristic3) {
        set(characteristic1);
        set(characteristic2);
        set(characteristic3);
    }

    public Droid setDefaultDroid(int characteristic) {
        switch (characteristic) {
            case 10:
                return new DD(this.getName());
            case 11:
                return new Heal(this.getName());
            case 12:
                return new Tank(this.getName());
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getHeal() {
        return heal;
    }

    public int getTactic() {
        return tactic;
    }

    public int getSteal() {
        return steal;
    }

    public int getBuff() {
        return buff;
    }

    public int getDebuff() {
        return debuff;
    }

    public int getSelfDestroy() {
        return selfDestroy;
    }

    public int getFightSpirit() {
        return fightSpirit;
    }

    public void reset() {
        hp = arcitecture[0];
        damage = arcitecture[1];
        heal = arcitecture[2];
        tactic = arcitecture[3];
        steal = arcitecture[4];
        buff = arcitecture[5];
        debuff = arcitecture[6];
        selfDestroy = arcitecture[7];
        fightSpirit = arcitecture[8];
    }

    @Override
    public String toString() {
        return "Droid " + name + '\n' +
                "hp = " + hp +
                "\tdamage = " + damage +
                "\nheal = " + heal +
                "\ttactic = " + tactic +
                "\tsteal = " + steal +
                "\tbuff = " + buff +
                "\ndebuff = " + debuff +
                "\tself destroy = " + selfDestroy +
                "\tfight spirit = " + fightSpirit +
                '\n';
    }
}
