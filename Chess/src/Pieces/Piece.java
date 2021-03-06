package Pieces;

import java.util.ArrayList;


public abstract class Piece {

	protected boolean player;
	protected int row;
	protected int column;
	protected boolean[][] moves;
	protected ArrayList<Integer> possibleMoves;
	
	public Piece(boolean player, int row, int column) {
		
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
	
	protected void resetMovesFalse() {
		
		int num, row, column; 
		for(int i = 0; i < possibleMoves.size(); i++) {
			num = possibleMoves.get(i);
			row = num / 10;
			column = num % 10;
			moves[row][column] = false;
		}
	}
	
	public boolean isVaildMove(int newRow, int newColumn) {
		
		return moves[newRow][newColumn];
	}
	
	public void updatePosition(int newRow, int newColumn) {
		
		row = newRow;
		column = newColumn;
	}

	
	public ArrayList<Integer> getPossibleMoves() {
		
		return possibleMoves;
	}
	
	public boolean getPlayer() {
	
		return player;
	}
	
	public int getRow() {
		
		return row;
	}
	
	public int getColumn() {
		
		return column;
	}
	
	public abstract void updatePossibleMoves(Piece[][] chessBoard);
}