package Pieces;

public class King extends Piece {

	public King(char player, int row, int column) {
		super(player, row, column);
		// TODO Auto-generated constructor stub
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
