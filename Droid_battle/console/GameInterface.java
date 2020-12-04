package com.lazyelf.console;

import com.lazyelf.battle.Battle;
import com.lazyelf.battle.TeamBattle;
import com.lazyelf.droid.Droid;

import java.util.Scanner;

public class GameInterface {
    private static int counter = 1;
    private static int droidCounter = 1;
    private boolean flagCreate = true;
    private boolean flagShow;
    private int droidAmount = 0;

    public int getAction() {
        System.out.print("\nChoose:\n" +
                "1 --> create droid\n" +
                "2 --> show droids\n" +
                "3 --> start battle\n" +
                "4 --> exit\n");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void showDroids(Droid[] arr) {
        if (droidAmount == 0) {
            System.out.println("You have no droids,");
        }
        for (int i = 0; i < droidAmount; ++i) {
            System.out.println(Integer.toString(i + 1) + ". " + arr[i].toString());
        }
    }

    public void createDroid(Droid[] arr) {
        arr[droidAmount] = new Droid(getName());
        setDroid(arr[droidAmount]);
        ++droidAmount;
    }

    public Droid chooseDroid(Droid[] arr) {
        System.out.println("\nPlease, choose droid:");
        if (flagShow) {
            showDroids(arr);
        }
        Scanner in = new Scanner(System.in);
        return arr[in.nextInt() - 1];
    }

    public boolean getMode() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter game mode (1 - team, 2 - solo): ");
        int mode = in.nextInt();
        return mode == 1;
    }

    public int getTeamAmount(Droid[] arr) {
        while (droidAmount < 4) {
            System.out.println("You need to create minimum 4 droids.");
            createDroid(arr);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter droids amount in team: ");
        int amount;
        while ((amount = in.nextInt()) < (droidAmount / 2)) {
            System.out.print("\nYou haven't so much droids: ");
        }
        return amount;
    }

    private boolean isInTeam(Droid droid, int counter, TeamBattle teamBattle) {
        for (int j = counter - 1; j >= 0; --j) {
            if (droid == teamBattle.getSecondTeamDroid(j) || droid == teamBattle.getFirstTeamDroid(j)) {
                System.out.println("Choose another one");
                return true;
            }
        }
        return false;
    }

    public void setTeams(Droid[] arr, TeamBattle teamBattle) {
        System.out.print("\nPlease, enter droid names for first team:");
        for (int i = 0; i < teamBattle.getFirstTeamAmount(); ++i) {
            Droid droid;
            do {
                droid = chooseDroid(arr);
            }
            while (isInTeam(droid, i, teamBattle));
            teamBattle.setFirstTeam(i, droid);
        }
        System.out.print("\nPlease, enter droid names for second team:");
        for (int i = 0; i < teamBattle.getSecondTeamAmount(); ++i) {
            Droid droid;
            do {
                droid = chooseDroid(arr);
            }
            while (isInTeam(droid, i, teamBattle));
            teamBattle.setSecondTeam(i, droid);
        }
    }

    private String getName() {
        System.out.print("Please, enter " + droidCounter + " droid name: ");
        ++droidCounter;
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private void setDroid(Droid droid) {
        if (flagCreate) {
            System.out.print("\nPlease, choose three attributes of Droid\n" +
                    "1 --> Increase hp by 20%\n" +
                    "2 --> Increase damage by 20%\n" +
                    "3 --> Increase heal abilities by 20%\n" +
                    "4 --> Increase tactic abilities by 20%\n" +
                    "5 --> Increase hp steal steal by 15%\n" +
                    "6 --> Increase buff probability by 15%\n" +
                    "7 --> Increase debuff probability by 15%\n" +
                    "8 --> Increase self destroy probability by 20%\n" +
                    "9 --> Increase desire to fight by 20%\n" +
                    "10 --> Create DD\n" +
                    "11 --> Create Heal\n" +
                    "12 --> Create Tank\n");
            flagCreate = false;
        }
        Scanner in = new Scanner(System.in);
        int characteristic1, characteristic2, characteristic3;
        System.out.print("Choose three attributes: ");
        characteristic1 = in.nextInt();
        if (characteristic1 == 10 || characteristic1 == 11 || characteristic1 == 12) {
            droid = droid.setDefaultDroid(characteristic1);
            return;
        }
        characteristic2 = in.nextInt();
        characteristic3 = in.nextInt();

        droid.setDroid(characteristic1, characteristic2, characteristic3);
    }

    private void printRoundInformation(Battle battle) {
        System.out.println("\n-----------------------------------\n" +
                "Round " + counter
                + "\n-----------------------------------\n" +
                battle.getDamager().getName() + " has hp: " +
                +battle.getDamager().getHp() + " \n" +
                battle.getTarget().getName() + " has hp: "
                + battle.getTarget().getHp() + " \n");
        ++counter;
    }

    private void printRoundInformation(TeamBattle teamBattle) {
        System.out.print("\n-----------------------------------\n" +
                "Round " + counter
                + "\n-----------------------------------\n");

        System.out.println("First team:");
        for (int i = 0; i < teamBattle.getAmount(); ++i) {
            System.out.print((teamBattle.getFirstTeamDroid(i)).getName());
            if (teamBattle.getFirstTeamDroid(i).isAlive()) {
                System.out.print("'s hp is " + teamBattle.getFirstTeamDroid(i).getHp() + ".\n");
            } else {
                System.out.print(" is dead.\n");
            }
        }

        System.out.println("Second team:");
        for (int i = 0; i < teamBattle.getAmount(); ++i) {
            System.out.print((teamBattle.getSecondTeamDroid(i)).getName());
            if (teamBattle.getSecondTeamDroid(i).isAlive()) {
                System.out.print("'s hp is " + teamBattle.getSecondTeamDroid(i).getHp() + ".\n");
            } else {
                System.out.print(" is dead.\n");
            }
        }
        System.out.print("\n");
        ++counter;
    }

    private void round(Battle battle) {
        printRoundInformation(battle);
        battle.makeFirstRound();
        showRound(battle);
        battle.makeSecondRound();
        showRound(battle);
    }

    private void round(TeamBattle teamBattle) {
        printRoundInformation(teamBattle);
        teamBattle.makeFirstRound();
        showRound(teamBattle.getCurrentBattle());
        teamBattle.makeSecondRound();
        showRound(teamBattle.getCurrentBattle());
    }

    private void showRound(Battle battle) {

        if (battle.isSpirit()) {
            System.out.print(battle.getDamager().getName() + " do not have the desire to fight.\n");
            return;
        }
        if (battle.isBuff()) {
            System.out.print(battle.getDamager().getName() + " was buffed.\n");
        }
        if (battle.isDebuff()) {
            System.out.print(battle.getTarget().getName() + " was debuffed.\n");
        }
        if (battle.isHeal()) {
            System.out.print(battle.getDamager().getName() + " was healed.\n");
        }
        if (battle.isSteal()) {
            System.out.print(battle.getDamager().getName() + " steal hp from " + battle.getTarget().getName() + ".\n");
            if (!battle.getTarget().isAlive())
                return;
        }
        if (battle.isSelfDestroy()) {
            System.out.print(battle.getDamager().getName() + " DESTROY ITSELF.\n");
            return;
        }
        if (battle.isTactic()) {
            System.out.print(battle.getTarget().getName() + " avoids damage.\n");
            return;
        }
        System.out.print(battle.getDamager().getName() + " damages "
                + battle.getTarget().getName() + " by "
                + battle.getDamager().getDamage() + " points.\n");
    }

    private void showResults(TeamBattle teamBattle) {
        if (teamBattle.getFirstTeamAmount() == 0 && teamBattle.getSecondTeamAmount() == 0) {
            System.out.println("All droids are dead.");
            return;
        }
        if (teamBattle.getFirstTeamAmount() == 0) {
            System.out.println("Second team won the battle.");
            return;
        }
        System.out.println("First team won the battle.");
    }

    private void showResults(Battle battle) {
        if (!battle.getDamager().isAlive() && !battle.getTarget().isAlive()) {
            System.out.println("All droids are dead.");
            return;
        }
        if (!battle.getDamager().isAlive()) {
            System.out.println("Second droid won the battle.");
            return;
        }
        System.out.println("First droid won the battle.");
    }

    public void battle(TeamBattle teamBattle) {
        while (teamBattle.canContinue()) {
            round(teamBattle);
        }
        showResults(teamBattle);
    }

    public void reset(Droid[] arr) {
        for (int i = 0; i < droidAmount; ++i) {
            arr[i].reset();
        }
    }

    public void battle(Battle battle) {
        if (battle.getTarget() == battle.getDamager()) {
            System.out.println("Droid " + battle.getTarget().getName()
                    + " has killed itself.");
            return;
        }
        while (battle.canContinue()) {
            round(battle);
        }
        showResults(battle);
    }

    public int getDroidAmount() {
        return droidAmount;
    }

    public void showNotifications(boolean flagShow) {
        this.flagShow = flagShow;
    }
}
