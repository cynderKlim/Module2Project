package edu.wctc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HybridRoom extends Room implements Lootable, Interactable {
    private Random random;

    public HybridRoom(String name) {
        super(name);
        random = new Random();
    }

    @Override
    public String getDescription() {
        return "You see a room filled with treasure, and a treasure chest! Must be your lucky day.";
    }

    @Override
    public String loot(Player player) {
        player.addToInventory("Treasure");
        player.addToScore(100);
        return "You looted the treasure!";
    }

    @Override
    public String interact(Player player) {
        if (random.nextInt(100) < 12) { // 12% chance
            player.addToInventory("Treasure");
            player.addToScore(100);
            return "The chest opened! You looted the treasure and earned 100 points.";
        } else {
            return "The chest is still locked. Try again!";
        }
    }
}