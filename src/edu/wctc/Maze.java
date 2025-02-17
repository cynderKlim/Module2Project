package edu.wctc;

public class Maze {
    private Room currentRoom;
    private Player player;
    protected boolean isFinished;

    public Maze() {
        this.player = new Player();
        this.isFinished = false;

        Room startRoom = new StartRoom("Start Room");
        Room treasureRoom = new TreasureRoom("Treasure Room");
        Room puzzleRoom = new PuzzleRoom("Puzzle Room");

        startRoom.setEast(treasureRoom);
        treasureRoom.setWest(startRoom);
        treasureRoom.setNorth(puzzleRoom);
        puzzleRoom.setSouth(treasureRoom);

        this.currentRoom = startRoom;
    }

    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable) {
            return ((Exitable) currentRoom).exit(player);
        }
        return "You cannot escape right now.";
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable) {
            return ((Interactable) currentRoom).interact(player);
        }
        return "No interactions possible.";
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable) {
            return ((Lootable) currentRoom).loot(player);
        }
        return "This room has nothing of value.";
    }

    public boolean move(char direction) {
        if (currentRoom.isValidDirection(direction)) {
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public boolean isFinished() {
        return isFinished;
    }
}