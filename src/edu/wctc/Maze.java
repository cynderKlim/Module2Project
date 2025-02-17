package edu.wctc;

public class Maze {
    private Room currentRoom;
    private Player player;
    protected boolean isFinished;

    public Maze() {
        this.player = new Player();
        this.isFinished = false;

        Room exitRoom = new ExitRoom("Exit Room");

        Room hybridRoom1 = new HybridRoom("Hybrid Room");
        Room hybridRoom2 = new HybridRoom("Hybrid Room");
        Room hybridRoom3 = new HybridRoom("Hybrid Room");
        Room hybridRoom4 = new HybridRoom("Hybrid Room");

        Room puzzleRoom1 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom2 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom3 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom4 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom5 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom6 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom7 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom8 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom9 = new PuzzleRoom("Puzzle Room");
        Room puzzleRoom10 = new PuzzleRoom("Puzzle Room");

        Room startRoom = new StartRoom("Start Room");

        Room treasureRoom1 = new TreasureRoom("Treasure Room");
        Room treasureRoom2 = new TreasureRoom("Treasure Room");
        Room treasureRoom3 = new TreasureRoom("Treasure Room");
        Room treasureRoom4 = new TreasureRoom("Treasure Room");
        Room treasureRoom5 = new TreasureRoom("Treasure Room");

        //exit room connection
        exitRoom.setSouth(hybridRoom4);

        //hybrid room connections
        hybridRoom1.setDown(treasureRoom2);
        hybridRoom1.setWest(puzzleRoom5);
        hybridRoom2.setWest(puzzleRoom7);
        hybridRoom2.setUp(treasureRoom4);
        hybridRoom2.setEast(puzzleRoom2);
        hybridRoom3.setSouth(puzzleRoom8);
        hybridRoom3.setEast(puzzleRoom9);
        hybridRoom4.setSouth(puzzleRoom6);
        hybridRoom4.setWest(puzzleRoom9);
        hybridRoom4.setEast(puzzleRoom10);
        hybridRoom4.setNorth(exitRoom);

        //puzzle room connections
        puzzleRoom1.setEast(startRoom);
        puzzleRoom1.setWest(treasureRoom3);
        puzzleRoom2.setSouth(startRoom);
        puzzleRoom2.setWest(hybridRoom2);
        puzzleRoom2.setEast(puzzleRoom4);
        puzzleRoom3.setWest(treasureRoom1);
        puzzleRoom4.setSouth(treasureRoom1);
        puzzleRoom4.setWest(puzzleRoom2);
        puzzleRoom4.setEast(treasureRoom2);
        puzzleRoom5.setEast(hybridRoom1);
        puzzleRoom5.setNorth(puzzleRoom10);
        puzzleRoom5.setWest(puzzleRoom6);
        puzzleRoom6.setEast(puzzleRoom5);
        puzzleRoom6.setNorth(hybridRoom4);
        puzzleRoom7.setSouth(treasureRoom3);
        puzzleRoom7.setEast(hybridRoom2);
        puzzleRoom8.setEast(treasureRoom4);
        puzzleRoom8.setNorth(hybridRoom3);
        puzzleRoom9.setWest(hybridRoom3);
        puzzleRoom9.setEast(hybridRoom4);
        puzzleRoom10.setWest(hybridRoom4);
        puzzleRoom10.setSouth(puzzleRoom5);
        puzzleRoom10.setEast(treasureRoom5);

        //start room connections
        startRoom.setEast(treasureRoom1);
        startRoom.setWest(puzzleRoom1);
        startRoom.setNorth(puzzleRoom2);

        //treasure room connections
        treasureRoom1.setWest(startRoom);
        treasureRoom1.setNorth(puzzleRoom4);
        treasureRoom1.setEast(puzzleRoom3);
        treasureRoom2.setWest(puzzleRoom4);
        treasureRoom2.setUp(hybridRoom1);
        treasureRoom3.setNorth(puzzleRoom7);
        treasureRoom3.setEast(puzzleRoom1);
        treasureRoom4.setDown(hybridRoom2);
        treasureRoom4.setWest(puzzleRoom8);
        treasureRoom5.setWest(puzzleRoom10);

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