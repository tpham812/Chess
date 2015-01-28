package Game;

import java.util.ArrayList;

import Pieces.Piece;

public class GameState {
	
	private Piece[][] possibleChessBoard;
	private ArrayList<Piece> possibleBlkPieces;
	private ArrayList<Piece> possibleWhtPieces;
	
	public GameState() {
		
		possibleChessBoard = new Piece[8][8];
		possibleBlkPieces = new ArrayList<Piece>();
		possibleWhtPieces = new ArrayList<Piece>();
	}
	
	public boolean gameState(Piece[][] chessBoard, ArrayList<Piece> blkPieces, ArrayList<Piece> whtPieces) {
		
		cloneBoard(chessBoard, blkPieces, whtPieces);
		
		return false;
	}
	
	private void cloneBoard(Piece[][] chessBoard, ArrayList<Piece> blkPieces, ArrayList<Piece> whtPieces) {
		
		possibleBlkPieces.clear();
		possibleWhtPieces.clear();
		
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
