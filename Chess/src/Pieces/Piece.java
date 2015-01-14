package Pieces;

public abstract class Piece {

	public final char player;
	public int row;
	public int column;
	
	public Piece(char player, int row, int column) {
		
		this.player = player;
		this.row = row;
		this.column = column;
	}
}
