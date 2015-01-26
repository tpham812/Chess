package Pieces;

public class Bishop extends Piece {

	public Bishop(boolean player, int row, int column) {
		super(player, row, column);

	}

	@Override
	public void updatePossibleMoves(Piece[][] chessBoard) {
		// TODO Auto-generated method stub
		
	}

	public void updatePosition(int newRow, int newColumn) {
	
		row = newRow;
		column = newColumn;
	}
}
