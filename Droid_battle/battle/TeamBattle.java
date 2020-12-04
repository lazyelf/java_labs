package com.lazyelf.battle;

import com.lazyelf.Rand;
import com.lazyelf.droid.Droid;

public class TeamBattle {
    Battle currentBattle;
    int amount;
    private int firstTeamAmount;
    private int secondTeamAmount;
    private final Droid[] firstTeam;
    private final Droid[] secondTeam;

    public TeamBattle(int amount) {
        this.amount = amount;
        currentBattle = new Battle();
        firstTeamAmount = secondTeamAmount = amount;
        firstTeam = new Droid[amount + 1];
        secondTeam = new Droid[amount + 1];
    }

    public boolean canContinue() {
        return firstTeamAmount != 0 && secondTeamAmount != 0;
    }

    public void makeFirstRound() {
        Droid first, second;
        do {
            int counter = Rand.rand(0, amount - 1);
            first = firstTeam[counter];
        } while (!first.isAlive());
        do {
            int counter = Rand.rand(0, amount - 1);
            second = secondTeam[counter];
        } while (!second.isAlive());
        currentBattle.setDamager(first);
        currentBattle.setTarget(second);
        currentBattle.makeFirstRound();
    }

    public void makeSecondRound() {
        currentBattle.makeSecondRound();
        if (!currentBattle.getDamager().isAlive()) {
            --firstTeamAmount;
        }
        if (!currentBattle.getTarget().isAlive()) {
            --secondTeamAmount;
        }
    }

    public void setFirstTeam(int counter, Droid droid) {
        firstTeam[counter] = droid;
    }

    public void setSecondTeam(int counter, Droid droid) {
        secondTeam[counter] = droid;
    }

    public Battle getCurrentBattle() {
        return currentBattle;
    }

    public int getFirstTeamAmount() {
        return firstTeamAmount;
    }

    public int getSecondTeamAmount() {
        return secondTeamAmount;
    }

    public Droid getFirstTeamDroid(int i) {
        return firstTeam[i];
    }

    public Droid getSecondTeamDroid(int i) {
        return secondTeam[i];
    }

    public int getAmount() {
        return amount;
    }
}
