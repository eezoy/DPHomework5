package com.narxoz.rpg.decorator;

import java.util.Random;

public class CriticalFocusDecorator extends ActionDecorator {
    private Random random = new Random();

    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " Critical strike";
    }

    @Override
    public int getDamage() {
        double criticalMultiplier = random.nextDouble() + 1;
        return (int) (super.getDamage() * criticalMultiplier);
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " Critical strike - damage is multiplied.";
    }
}
