package services;

import interfaces.BoardGames;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
import modals.TicTacToeBoard;
import modals.TicTacToePlayer;
import modals.enums.TicTacToePieceType;

@Getter
@Setter
public class TicTacToeGame implements BoardGames {
    Deque<TicTacToePlayer> players;
    TicTacToeBoard gameBoard;

    public TicTacToeGame() {
        this.players = new LinkedList<>();
        this.gameBoard = new TicTacToeBoard(3);
    }

    public void addPlayer(TicTacToePlayer player) {
        this.players.add(player);
    }

    @Override
    public void startGame() {

        boolean noWinner = true;

        while( noWinner ) {

            //Print current board
            gameBoard.printBoard();

            //check if game is draw (as no space is left to fill in)
            if (!gameBoard.checkDraw(gameBoard.getSize())) {
                System.out.println("------<<<----GAME END---->>>-------");
                break;
            }

            //Take out player from deque to play their move
            TicTacToePlayer player = players.getFirst();
            players.removeFirst();
            Scanner scanner = new Scanner(System.in);
            System.out.println(player.getName() + ", it's your turn (enter row and col in x,y format) : ");
            String input = scanner.next();

            //Extract the row and col from input
            String[] inputVals = input.split(",");
            int row = Integer.parseInt(inputVals[0].trim());
            int col = Integer.parseInt(inputVals[1].trim());

            //Add the piece to the board
            if (!gameBoard.playMove(row, col, player.getPiece())) {
                players.addFirst(player);
                continue;
            }

            //Check if current player wins or not
            if (this.checkCurrentPlayerWinningStatus(row, col)) {
                System.out.println("Winner of this game is : " + player.getName().toUpperCase());
                System.out.println("------<<<----GAME END---->>>-------");
                noWinner = false;
            }

            //Rotate the turns b/w two players by pushing the current player in last
            players.addLast(player);
        }
    }

    @Override
    public boolean checkCurrentPlayerWinningStatus(int row, int col) {

        TicTacToePieceType pieceType = gameBoard.getBoard()[row][col];

        //row check
        boolean rowCheck = true;
        for ( int i = 0; i < gameBoard.getSize(); ++i ) {
            if (!pieceType.equals(gameBoard.getBoard()[row][i])) {
                rowCheck = false;
                break;
            }
        }

        //col check
        boolean colCheck = true;
        for ( int i = 0; i < gameBoard.getSize(); ++i ) {
            if (!pieceType.equals(gameBoard.getBoard()[i][col])) {
                colCheck = false;
                break;
            }
        }

        //right diagonal check
        boolean rightDiaCheck = true;
        for ( int i = 0, j = 0; i < gameBoard.getSize() && j < gameBoard.getSize(); ++i, ++j ) {
            if (!pieceType.equals(gameBoard.getBoard()[i][j])) {
                rightDiaCheck = false;
                break;
            }
        }


        //left diagonal check
        boolean leftDiaCheck = true;
        for ( int i = gameBoard.getSize()-1 , j = 0; i >= 0 && j < gameBoard.getSize(); --i, ++j ) {
            if (!pieceType.equals(gameBoard.getBoard()[i][j])) {
                leftDiaCheck = false;
                break;
            }
        }

        return rowCheck || colCheck || rightDiaCheck || leftDiaCheck;
    }

}
