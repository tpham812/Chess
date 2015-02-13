package Game;

import java.util.ArrayList;

import Board.ChessBoard;
import Pieces.King;
import Pieces.Piece;

public class GameStateTest {
	
	private ChessBoard chessBoard;
	
	public GameStateTest() {
		
		chessBoard = new ChessBoard();
	}
	
	public void getGameState(ChessBoard chessBoardToClone, boolean player, GameState gameState) {
		
		if(player) {
			King whtKing = (King)chessBoardToClone.getWhtKing();
			if(whtKing.getIsCheck()) {
				gameState.gameState = GameState.State.CHECK;
			}
		}
		else {
			King blkKing = (King)chessBoardToClone.getBlkKing();
			if(blkKing.getIsCheck()) {
				gameState.gameState = GameState.State.CHECK;
			}
		}
	}
	/*private boolean isThereLegalMove(ChessBoard chessBoardToClone, ArrayList<Piece> pieces, Piece king, boolean player) {
		
	
		for(int i = 0; i < pieces.size(); i++) {
			Piece currPiece = pieces.get(i);
			ArrayList<Integer> possibleMoves = currPiece.getPossibleMoves();
			int row = currPiece.getRow();
			int column = currPiece.getColumn();
			for(int j = 0; j < possibleMoves.size(); j++) {
				int pieceNumber = possibleMoves.get(j);
				int newRow = pieceNumber / 10;
				int newColumn = pieceNumber % 10;
				chessBoard.movePiece(row, column, newRow, newColumn, '0');
				chessBoard.updatePossibleMoves(true);
				chessBoard.updatePossibleMoves(false);
				ArrayList<Piece> piecesToTest;
				if(player) {
					piecesToTest = chessBoard.getWhtPieces();
				}
				else {
					piecesToTest = chessBoard.getBlkPieces();
				}
				if(!isKingPositionUnderAttack(piecesToTest, king)) {
					return true;
				}
				chessBoard.cloneBoard(chessBoardToClone);
			}
		}
		return false;
	}*/
}