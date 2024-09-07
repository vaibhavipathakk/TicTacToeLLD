package interfaces;

import modals.enums.TicTacToePieceType;

public interface Boards {

    boolean playMove(int row, int col, TicTacToePieceType pieceType);

    boolean checkDraw(int size);

    boolean checkValidMove(int row, int col);

    void printBoard();

}
