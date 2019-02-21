package com.javatask;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "./src/main/resources/movie list.txt";

        List<String> movieNames = Game.readMoviesFromFile(fileName);
        String movieTitle = Game.getRandomMovie(movieNames);
        String currentTitle = Game.hiddenMovieName(movieTitle);

        int wrongTries = 0;
        boolean isGuessed = false;
        List<Character> wrongLetters = new ArrayList<>();

        while (isGuessed == false && wrongTries < 10) {
            Game.printMainMessage(currentTitle, wrongTries);
            Game.printWrongLetters(wrongLetters);

            char inputtedLetter = Game.usersInput();

            String attemptResult = Game.revealGuessedLetter(inputtedLetter, currentTitle, movieTitle);
            if (attemptResult.equals(movieTitle)) {
                isGuessed = true;
                System.out.println("You win!");
                System.out.println("You have guessed: '" + movieTitle + "' correctly.");
            } else if (!attemptResult.equals(currentTitle)) {
                currentTitle = attemptResult;
            } else {
                wrongTries++;
                wrongLetters.add(inputtedLetter);
            }
        }
    }
}