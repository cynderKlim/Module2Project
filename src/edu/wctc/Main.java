package edu.wctc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);

        System.out.println("You wake up and find yourself in room alone. Your head is pounding, you feel disoriented.\nUpon getting up and looking at yourself and your surroundings\nwhen all of a sudden alarm bells start ringing and the ground begins to shake!\nThe very foundation of the building you're in is unstable!\nYou have one hour to escape, or be buried beneath the rubble.\nGood luck.");

        while (!maze.isFinished()) {
            System.out.println(maze.getCurrentRoomDescription());
            System.out.println("You have rooms to your " + maze.getCurrentRoomExits() + ".");
            System.out.print("Which way would you like to go (n/s/e/w)? You may also check your inventory (v), loot the room (l), interact with the room (i), or try to go up or down (u/d): ");
            char command = scanner.next().charAt(0);

            switch (command) {
                case 'n':
                case 's':
                case 'e':
                case 'w':
                case 'u':
                case 'd':
                    if (!maze.move(command)) {
                        System.out.println("I did tell you your options, and yet you still tried this? You're funny, I'll give you that. Not funny enough though.");
                        maze.getPlayer().removeToScore(20);
                    }
                    break;
                case 'i':
                    System.out.println(maze.interactWithCurrentRoom());
                    break;
                case 'l':
                    System.out.println(maze.lootCurrentRoom());
                    break;
                case 'x':
                    System.out.println(maze.exitCurrentRoom());
                    maze.isFinished = true;
                    break;
                case 'v':
                    System.out.println(maze.getPlayerInventory());
                    break;
                default:
                    System.out.println("This isn't going to work, why are you wasting your time? It's funny but not enough to save you.");
                    maze.getPlayer().removeToScore(20);
            }
        }

        System.out.println("You escaped! Your score: " + maze.getPlayerScore());
        scanner.close();
    }
}