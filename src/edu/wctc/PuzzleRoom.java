package edu.wctc;

public class PuzzleRoom extends Room implements Interactable {
    public PuzzleRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You are in a room with a puzzle.";
    }

    @Override
    public String interact(Player player) {
        player.addToScore(50);
        return "You solved the puzzle!";
    }
}