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
	
	private boolean isCheck() {
		
		return false;
	}
	
	private boolean isCheckMate() {
		
		return false;
	}
	
	private boolean isStaleMate() {
	
		return false;
	}	
}
