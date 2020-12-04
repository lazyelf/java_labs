package com.lazyelf;

import com.lazyelf.battle.Battle;
import com.lazyelf.battle.TeamBattle;
import com.lazyelf.console.GameInterface;
import com.lazyelf.droid.Droid;

public class Main {

    public static void main(String[] args) {
        GameInterface game = new GameInterface();
        Droid[] arr = new Droid[10];
        while (true) {

            switch (game.getAction()) {
                case 1:
                    game.createDroid(arr);
                    break;
                case 2:
                    game.showDroids(arr);
                    break;
                case 3:
                    game.showNotifications(true);
                    if (game.getMode()) {
                        TeamBattle teamBattle = new TeamBattle(game.getTeamAmount(arr));
                        game.setTeams(arr, teamBattle);
                        game.battle(teamBattle);

                    } else {
                        while (game.getDroidAmount() < 2) {
                            System.out.println("You need to create minimum 2 droids.");
                            game.createDroid(arr);
                        }
                        Battle battle = new Battle(game.chooseDroid(arr), game.chooseDroid(arr));
                        game.battle(battle);
                    }
                    game.reset(arr);
                    break;
                case 4:
                   return;
            }
        }
    }
}