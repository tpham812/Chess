package Game;

import java.util.ArrayList;

import Board.ChessBoard;
import Pieces.Piece;

public class GameState {
	
	private ChessBoard chessBoard;
	
	public GameState() {
		
		chessBoard = new ChessBoard();
	}
	
	public boolean getGameState(ChessBoard chessBoard, boolean player) {
		
		cloneBoard(chessBoard, player);
		
		return false;
	}
	
	private void cloneBoard(ChessBoard chessBoard, boolean player) {
		
		
	}
	
	private boolean isCheck(ArrayList<Piece> pieces, Piece king) {
		
		return isKingPositionUnderAttack(pieces, king);
	}
	
	private boolean isCheckMate() {
		
		return false;
	}
	
	private boolean isStaleMate() {
	
		return false;
	}	
	
	private boolean isKingPositionUnderAttack(ArrayList<Piece> pieces, Piece king) {
		
		int kingRowPosition = king.getRow();
		int kingColumnPosition = king.getColumn();
		
		for(int i = 0; i < pieces.size(); i++) {
			Piece piece = pieces.get(i);
			ArrayList<Integer> possibleMoves = piece.getPossibleMoves();
			for(int j = 0; j < possibleMoves.size(); j++) {
				int number = possibleMoves.get(j);
				int row = number / 10;
				int column = number % 10;
				if(row == kingRowPosition && column == kingColumnPosition) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isKingPossibleMovePositionUnderAttack(ArrayList<Piece> pieces, Piece king) {
		
		//To be implemented
		return false;
	}
}