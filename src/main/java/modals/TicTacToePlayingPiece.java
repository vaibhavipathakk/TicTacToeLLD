package modals;

import lombok.Getter;
import lombok.Setter;
import modals.enums.TicTacToePieceType;

@Getter
@Setter
public class TicTacToePlayingPiece {
    TicTacToePieceType piece;

    TicTacToePlayingPiece(TicTacToePieceType type) {
        this.piece = type;
    }
}


