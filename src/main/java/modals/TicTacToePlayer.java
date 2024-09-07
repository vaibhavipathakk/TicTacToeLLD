package modals;

import lombok.Getter;
import lombok.Setter;
import modals.enums.TicTacToePieceType;

@Getter
@Setter
public class TicTacToePlayer {
    String name;
    TicTacToePieceType piece;

    public TicTacToePlayer(String name, TicTacToePieceType piece){
        this.name = name;
        this.piece = piece;
    }
}
