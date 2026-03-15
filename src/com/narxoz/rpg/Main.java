package com.narxoz.rpg;

import com.narxoz.rpg.decorator.*;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        AttackAction basic = new BasicAttack("Strike", 10);
        AttackAction fireStrike = new FireRuneDecorator(new BasicAttack("Strike", 10));
        AttackAction venomStrike = new PoisonCoatingDecorator(new BasicAttack("Strike", 10));
        AttackAction combo = new FireRuneDecorator(new PoisonCoatingDecorator(new CriticalFocusDecorator(new BasicAttack("Strike", 10))));

        System.out.println("--- Decorator Preview ---");
        System.out.println("Base:");
        System.out.println("  Name: " + basic.getActionName());
        System.out.println("  Damage preview: " + basic.getDamage());
        System.out.println("  Effects: " + basic.getEffectSummary());
        System.out.println();

        System.out.println("Fire Upgrade:");
        System.out.println("  Name: " + fireStrike.getActionName());
        System.out.println("  Damage preview: " + fireStrike.getDamage());
        System.out.println("  Effects: " + fireStrike.getEffectSummary());
        System.out.println();

        System.out.println("Poison Upgrade:");
        System.out.println("  Name: " + venomStrike.getActionName());
        System.out.println("  Damage preview: " + venomStrike.getDamage());
        System.out.println("  Effects: " + venomStrike.getEffectSummary());
        System.out.println();

        System.out.println("Stacked Combo:");
        System.out.println("  Name: " + combo.getActionName());
        System.out.println("  Damage preview: " + combo.getDamage());
        System.out.println("  Effects: " + combo.getEffectSummary());
        System.out.println();

        System.out.println("--- Facade Preview ---");
        HeroProfile hero = new HeroProfile("Warrior", 95);
        BossEnemy boss = new BossEnemy("Orc Warlord", 110, 14);
        DungeonFacade facade = new DungeonFacade().setRandomSeed(67L);
        AdventureResult result = facade.runAdventure(hero, boss, combo);

        System.out.println("Adventure log:");
        for (String line : result.getLog()) System.out.println("- " + line);

        System.out.println();
        System.out.println("Final Summary:");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
    
        System.out.println("=== Demo Complete ===");
    }
}
