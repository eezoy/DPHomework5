package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            return "Preparation failed: hero, boss, and action must all be provided.";
        }

        if (!hero.isAlive()) {
            return "Preparation failed: the hero is already defeated.";
        }

        if (!boss.isAlive()) {
            return "Preparation failed: the boss is already defeated.";
        }

        return "Preparation complete: "
                + hero.getName() + " enters with " + hero.getHealth() + " HP, "
                + boss.getName() + " guards the dungeon with " + boss.getHealth() + " HP, using "
                + action.getActionName() + " for " + action.getDamage() + " damage.";
    }
}
