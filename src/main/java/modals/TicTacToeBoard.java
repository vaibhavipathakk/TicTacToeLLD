package modals;

import interfaces.Boards;
import lombok.Getter;
import lombok.Setter;
import modals.enums.TicTacToePieceType;

@Getter
@Setter
public class TicTacToeBoard implements Boards {
    private int size;
    private TicTacToePieceType[][] board;

    public TicTacToeBoard(int size) {
        this.size = size;
        this.board = new TicTacToePieceType[size][size];
    }

    public boolean checkValidMove(int row, int col) {
        return row < this.size && row >= 0 && col < this.size && col >= 0;
    }

    public boolean playMove(int row, int col, TicTacToePieceType piece) {

        if (!checkValidMove(row, col)) {
            System.out.println("Invalid Move, try again!");
            return false;
        }
        if ( this.board[row][col] == null ) {
            this.board[row][col] = piece;
            return true;
        }
        System.out.println("This field is already filled, try again!");
        return false;
    }

    public boolean checkDraw(int size) {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if ( this.board[i][j] == null) {
                    System.out.println("Free cells present, moving ahead");
                    return true;
                }
            }
        }
        System.out.println("!! DRAW !!");
        return false;
    }

    public void printBoard(){
        System.out.println("Board Status : ");
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(this.board[i][j] + " | ");
            }
            System.out.println();
        }
    }


}
