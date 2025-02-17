package edu.wctc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class PuzzleRoom extends Room implements Interactable {
    private Map<String, String> puzzles;
    private Random random;

    public PuzzleRoom(String name) {
        super(name);
        puzzles = new HashMap<>();
        random = new Random();
        initializePuzzles();
    }

    private void initializePuzzles() {
        puzzles.put("I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?", "echo");
        puzzles.put("I have keys but no locks. I have space but no room. You can enter, but you can't go outside. What am I?", "keyboard");
        puzzles.put("What has to be broken before you can use it?", "egg");
        puzzles.put("What is 5 + 7?", "12");
        puzzles.put("What is 8 * 3?", "24");
        puzzles.put("What is 15 - 4?", "11");
        puzzles.put("What is 9 / 3?", "3");
        puzzles.put("Unscramble the word: 'elppa'", "apple");
        puzzles.put("Unscramble the word: 'naaban'", "banana");
        puzzles.put("Unscramble the word: 'egnaro'", "orange");
        puzzles.put("Unscramble the word: 'yrrehc'", "cherry");
        puzzles.put("What comes once in a minute, twice in a moment, but never in a thousand years?", "m");
        puzzles.put("What is so fragile that saying its name breaks it?", "silence");
        puzzles.put("What is the name of the cutest cat in the world?", "Nana");
        puzzles.put("Do you like waffles?", "Yeah we like waffles");
        puzzles.put("Do you like pancakes?", "Yeah we like pancakes");
        puzzles.put("Do you like french toast?", "Yeah we like french toast");
        puzzles.put("Never gonna give you up", "Never gonna let you down");
    }

    @Override
    public String getDescription() {
        return "You are in a room with a puzzle. Solve the riddle to earn points.";
    }

    @Override
    public String interact(Player player) {
        Scanner scanner = new Scanner(System.in);
        Object[] keys = puzzles.keySet().toArray();
        String puzzle = (String) keys[random.nextInt(keys.length)];
        System.out.println("Riddle: " + puzzle);
        System.out.print("Your answer: ");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals(puzzles.get(puzzle))) {
            player.addToScore(50);
            return "Correct! You solved the puzzle and earned 50 points.";
        } else {
            return "Incorrect. Please try again.";
        }
    }
}