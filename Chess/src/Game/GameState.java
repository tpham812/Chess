package Game;

import java.util.ArrayList;

import Pieces.Piece;

public class GameState {
	
	private Piece[][] possibleChessBoard;
	private ArrayList<Piece> blkPieces;
	private ArrayList<Piece> whtPieces;
	
	
	public GameState() {
		
		possibleChessBoard = new Piece[8][8];
		blkPieces = new ArrayList<Piece>();
		whtPieces = new ArrayList<Piece>();
	}
	
	public boolean gameState() {
		
		return false;
	}
	
	private void cloneBoard() {
		
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
