package edu.wctc;

public class ExitRoom extends Room implements Exitable{
    public ExitRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You are in the exit room. You can escape from here, or return back, for some reason.";
    }

    @Override
    public String exit(Player player) {
        return "Congratulations! You have successfully escaped!";
    }
}
