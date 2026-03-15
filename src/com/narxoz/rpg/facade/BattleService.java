package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();

        int rounds = 0;
        while (hero.isAlive() && boss.isAlive()) {
            rounds++;
            result.addLine("Round " + rounds + " begins.");

            int heroDamage = Math.max(1, action.getDamage());
            boss.takeDamage(heroDamage);
            result.addLine(hero.getName() + " uses " + action.getActionName() + " for " + heroDamage + " damage.");

            if (boss.isAlive()) {
                int bossDamage = Math.max(1, boss.getAttackPower());
                hero.takeDamage(bossDamage);
                result.addLine(boss.getName() + " strikes back for " + bossDamage + " damage.");
            }

            result.addLine("Status: " + hero.getName() + " HP = " + hero.getHealth() + ", " + boss.getName() + " HP = " + boss.getHealth() + ".");
        }

        result.setRounds(rounds);

        if (hero.isAlive() && !boss.isAlive()) {
            result.setWinner("Hero victory: " + hero.getName());
        } 
        
        else if (!hero.isAlive() && boss.isAlive()) {
            result.setWinner("Boss victory: " + boss.getName());
        } 
        
        else if (hero.isAlive()) {
            result.setWinner("Hero survival: " + hero.getName());
        } 
        
        else {
            result.setWinner("Draw");
        }

        return result;
    }
}
