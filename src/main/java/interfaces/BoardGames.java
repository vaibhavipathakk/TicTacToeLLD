package interfaces;

import modals.TicTacToePlayer;

public interface BoardGames {

    void addPlayer(TicTacToePlayer player);

    void startGame();

    boolean checkCurrentPlayerWinningStatus(int row, int col);
    
}
