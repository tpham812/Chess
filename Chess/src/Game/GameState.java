package Game;

import java.util.ArrayList;

import Board.ChessBoard;
import Pieces.Piece;

public class GameState {
	
	private ChessBoard chessBoard;
	
	public GameState() {
		
		chessBoard = new ChessBoard();
	}
	
	public boolean getGameState(Piece[][] chessBoard, ArrayList<Piece> blkPieces, ArrayList<Piece> whtPieces) {
		
		cloneBoard(chessBoard, blkPieces, whtPieces);
		
		return false;
	}
	
	private void cloneBoard(Piece[][] chessBoard, ArrayList<Piece> blkPieces, ArrayList<Piece> whtPieces) {
		
		
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
