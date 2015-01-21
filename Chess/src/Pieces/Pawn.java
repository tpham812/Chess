package Pieces;

public class Pawn extends Piece {

	private boolean firstMove;
	private boolean move2Ranks;
	
	public Pawn(char player, int row, int column) {
		
		super(player, row, column);
		firstMove = false;
		move2Ranks = false;
	}

	public void updatePossibleMoves() {
	
		
	}
	
	
}