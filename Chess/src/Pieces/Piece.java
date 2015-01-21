package Pieces;

public abstract class Piece {

	public char player;
	public int row;
	public int column;
	protected boolean[][] possibleMoves;
	
	public Piece(char player, int row, int column) {
		
		this.player = player;
		this.row = row;
		this.column = column;
		possibleMoves= new boolean[8][8];
		setPMFalse();
	}
	
	protected void setPMFalse() {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				possibleMoves[i][j] = false;
			}
		}
	}
	
	public abstract void updatePossibleMoves();
	public abstract void updatePosition(int newRow, int newColumn);
}
