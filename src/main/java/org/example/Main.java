package org.example;

import modals.TicTacToePlayer;
import modals.TicTacToePlayingPiece;
import modals.enums.TicTacToePieceType;
import services.TicTacToeGame;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Welcome! Lets Play!");
        System.out.println("------>>>----Tic Tac Toe----<<<------");

        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        TicTacToePlayer player1 = new TicTacToePlayer("Himanshu", TicTacToePieceType.O);
        TicTacToePlayer player2 = new TicTacToePlayer("Mansi", TicTacToePieceType.X);
        ticTacToeGame.addPlayer(player1);
        ticTacToeGame.addPlayer(player2);

        ticTacToeGame.startGame();

    }
}
