package com.narxoz.rpg.decorator;

import java.util.Random;

public class FireRuneDecorator extends ActionDecorator {
    private Random random = new Random();

    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " Fire rune";
    }

    @Override
    public int getDamage() {
        int fireDamage = random.nextInt(15);
        return super.getDamage() + fireDamage;
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " Fire rune - adds fire damage on hit.";
    }
}
