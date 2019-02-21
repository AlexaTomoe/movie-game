package com.javatask;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Game {
    public static String hiddenMovieName(String movieTitle) {
        int titleLength = movieTitle.length();
        char[] chars = new char[titleLength];
        Arrays.fill(chars, '_');
        for (int i = 0; i < titleLength; i++) {
            if (movieTitle.charAt(i) == ' ') {
                chars[i] = ' ';
            }
        }
        String hiddenMovie = new String(chars);
        return hiddenMovie;
    }

    public static char usersInput() {
        Scanner usersInput = new Scanner(System.in);
        char usersGuess = usersInput.next().charAt(0);
        return usersGuess;
    }

    public static String revealGuessedLetter(char guessedLetter, String currentMovie, String movieTitle) {
        StringBuilder guessedWord = new StringBuilder(currentMovie);
        for (int i = 0; i < movieTitle.length(); i++) {
            if (movieTitle.charAt(i) == guessedLetter) {
                guessedWord.setCharAt(i, guessedLetter);
            }
        }
        return guessedWord.toString();
    }

    public static void printWrongLetters(List<Character> wrongLetters) {
        for (int i = 0; i < wrongLetters.size(); i++) {
            System.out.print(wrongLetters.get(i) + " ");
        }
        System.out.println();
        System.out.println("Guess a letter: ");
    }

    public static void printMainMessage(String currentTitle, int wrongTries) {
        System.out.println("You are guessing:" + currentTitle);
        System.out.print("You have guessed (" + wrongTries + ") wrong letters: ");
    }

    public static List<String> readMoviesFromFile(String fileName) throws Exception {
        Path filePath = Paths.get(fileName);
        Scanner scanner = new Scanner(filePath);
        List<String> movieNames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movieNames.add(line);
        }
        return movieNames;
    }

    public static String getRandomMovie(List<String> movieNames) {
        Random random = new Random();
        int num = random.nextInt(movieNames.size() + 1);
        return movieNames.get(num);
    }
}
