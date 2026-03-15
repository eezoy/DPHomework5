package com.narxoz.rpg.decorator;

import java.util.Random;

public class PoisonCoatingDecorator extends ActionDecorator {
    private Random random = new Random();

    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " Poison coating";
    }

    @Override
    public int getDamage() {
        int poisonDamage = random.nextInt(10);
        return super.getDamage() + poisonDamage;
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " Poison coating - adds poison damage over time.";
    }
}
