package edu.wctc;

public class TreasureRoom extends Room implements Lootable {
    public TreasureRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You see a room filled with treasure.";
    }

    @Override
    public String loot(Player player) {
        player.addToInventory("Treasure");
        player.addToScore(100);
        return "You looted the treasure!";
    }
}