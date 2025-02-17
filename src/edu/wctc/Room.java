package edu.wctc;

public abstract class Room {
    protected String name;
    protected Room north, south, east, west, up, down;

    public Room(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public Room getAdjoiningRoom(char direction) {
        switch (direction) {
            case 'n': return north;
            case 's': return south;
            case 'e': return east;
            case 'w': return west;
            case 'u': return up;
            case 'd': return down;
        }
        return null;
    }

    public String getExits() {
        StringBuilder exits = new StringBuilder();
        if (north != null) exits.append("north ");
        if (south != null) exits.append("south ");
        if (east != null) exits.append("east ");
        if (west != null) exits.append("west ");
        if (up != null) exits.append("up the ladder ");
        if (down != null) exits.append("down the ladder ");
        return exits.toString().trim();
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(char direction) {
        return getAdjoiningRoom(direction) != null;
    }

    public void setNorth(Room north) { this.north = north; }
    public void setSouth(Room south) { this.south = south; }
    public void setEast(Room east) { this.east = east; }
    public void setWest(Room west) { this.west = west; }
    public void setUp(Room up) { this.up = up; }
    public void setDown(Room down) { this.down = down; }
}