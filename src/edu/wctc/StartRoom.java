package edu.wctc;

public class StartRoom extends Room implements Exitable {
    public StartRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You are in the starting room.";
    }

    @Override
    public String exit(Player player) {
        return "You have escaped the maze, against all odds!";
    }
}