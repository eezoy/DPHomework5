package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward.";
        }

        String winner = battleResult.getWinner();
        if (winner == null || winner.isEmpty()) {
            return "No reward.";
        }

        if (winner.startsWith("Hero victory:") || winner.startsWith("Hero survival:")) {
            if (battleResult.getRounds() <= 3) {
                return "Epic chest: 150 gold and magic gem.";
            }
            return "Adventurer's cache: 90 gold and healing potion.";
        }

        if ("Draw".equals(winner) || "No contest".equals(winner)) {
            return "No reward.";
        }

        return "Consolation prize: 20 gold for surviving.";
    }
}
