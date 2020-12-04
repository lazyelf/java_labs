package com.lazyelf.battle;

import com.lazyelf.Rand;
import com.lazyelf.droid.Droid;

public class Battle {
    private Droid damager;
    private Droid target;
    private boolean spirit = false;
    private boolean buff = false;
    private boolean debuff = false;
    private boolean heal = false;
    private boolean steal = false;
    private boolean selfDestroy = false;
    private boolean tactic = false;

    public Battle() {
    }

    public Battle(Droid first, Droid second) {
        this.damager = first;
        this.target = second;
    }

    public boolean canContinue() {
        return damager.isAlive() && target.isAlive();
    }

    public void makeFirstRound() {
        Droid temp = damager;
        damager = target;
        target = temp;
        round(damager, target);
    }

    public void makeSecondRound() {
        Droid temp = damager;
        damager = target;
        target = temp;
        if (target.isAlive()) {
            round(damager, target);
        }
    }

    private boolean checkSpirit(Droid droid) {
        int rand = Rand.rand(1, 100);
        if (rand > droid.getFightSpirit()) {
            spirit = true;
            return true;
        } else spirit = false;
        return false;
    }

    private void checkBuff(Droid droid) {
        int rand = Rand.rand(1, 100);
        if (rand <= droid.getBuff()) {
            droid.increaseDamage((int) (droid.getDamage() * 0.15));
            buff = true;
        } else buff = false;
    }

    private void checkDebuff(Droid first, Droid second) {
        int rand = Rand.rand(1, 100);
        if (rand <= first.getDebuff()) {
            second.decreaseDamage((int) (second.getDamage() * 0.15));
            debuff = true;
        } else debuff = false;
    }

    private void checkHeal(Droid droid) {
        int rand = Rand.rand(1, 100);
        if (rand <= droid.getHeal()) {
            droid.increaseHP(200);
            heal = true;
        } else heal = false;
    }

    private boolean checkSteal(Droid first, Droid second) {
        int rand = Rand.rand(1, 100);
        if (rand <= first.getSteal()) {
            second.decreaseHP(100);
            first.increaseHP(100);
            steal = true;
            return !second.isAlive();
        } else steal = false;
        return false;
    }

    private boolean checkSelfDestroy(Droid first, Droid second) {
        int rand = Rand.rand(1, 100);
        if (rand <= first.getSelfDestroy()) {
            if (first.getHp() < 200) {
                second.decreaseHP(500);
                first.setHp(0);
                selfDestroy = true;
                return true;
            }
        } else selfDestroy = false;
        return false;
    }

    private boolean checkTactic(Droid droid) {
        int rand = Rand.rand(1, 100);
        if (rand <= droid.getTactic()) {
            tactic = true;
            return true;
        } else
            tactic = false;
        return false;
    }

    private void round(Droid first, Droid second) {
        if (checkSpirit(first)) {
            return;
        }
        checkBuff(first);
        checkDebuff(first, second);
        checkHeal(first);
        if (checkSteal(first, second)) {
            return;
        }
        if (checkSelfDestroy(first, second)) {
            return;
        }
        if (checkTactic(second)) {
            return;
        }
        second.decreaseHP(first.getDamage());
    }

    public void setDamager(Droid damager) {
        this.damager = damager;
    }

    public void setTarget(Droid target) {
        this.target = target;
    }

    public boolean isSpirit() {
        return spirit;
    }

    public boolean isBuff() {
        return buff;
    }

    public boolean isDebuff() {
        return debuff;
    }

    public boolean isHeal() {
        return heal;
    }

    public boolean isSteal() {
        return steal;
    }

    public boolean isSelfDestroy() {
        return selfDestroy;
    }

    public boolean isTactic() {
        return tactic;
    }

    public Droid getDamager() {
        return damager;
    }

    public Droid getTarget() {
        return target;
    }
}
