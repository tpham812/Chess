package Pieces;

import java.util.ArrayList;

public abstract class Piece {

	public char player;
	public int row;
	public int column;
	protected boolean[][] moves;
	protected ArrayList<Integer> possibleMoves;
	
	public Piece(char player, int row, int column) {
		
		this.player = player;
		this.row = row;
		this.column = column;
		moves= new boolean[8][8];
		possibleMoves = new ArrayList<Integer>();
	}
	
	protected void setMovesFalse() {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				moves[i][j] = false;
			}
		}
	}
	
	public boolean isVaildMove(int newRow, int newColumn) {
		
		return moves[newRow][newColumn];
	}
	
	public abstract void updatePossibleMoves(Piece[][] chessBoard);
	public abstract void updatePosition(int newRow, int newColumn);
}
