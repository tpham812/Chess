package Pieces;

public class Knight extends Piece {

	public Knight(char player, int row, int column) {
		super(player, row, column);
	
	}

	@Override
	public void updatePossibleMoves() {
		// TODO Auto-generated method stub
		
	}

	public void updatePosition(int newRow, int newColumn) {
		
		row = newRow;
		column = newColumn;
	}
}
