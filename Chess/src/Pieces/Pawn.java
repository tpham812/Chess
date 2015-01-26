package Pieces;

public class Pawn extends Piece {

	private boolean firstMove;
	private boolean move2Ranks;
	private int direction;
	
	public Pawn(boolean player, int row, int column, int direction) {
		
		super(player, row, column);
		firstMove = false;
		move2Ranks = false;
		this.direction = direction;
	}

	public void updatePossibleMoves(Piece[][] chessBoard) {

		int newRow = 0, newColumn = 0; 
		Piece piece;

		setMovesFalse();

		newRow = row + direction;
		if(newRow >= 0 && newRow <= 8) {
			newColumn = column - 1;
			if(newColumn >= 0 ) {
				piece = chessBoard[newRow][newColumn];
				if(piece != null && piece.player != player )
					moves[newRow][newColumn] = true;
			}
			newColumn = column + 1;
			if(newColumn < 8  ) {
				piece = chessBoard[newRow][newColumn];
				if(piece != null && piece.player != player)
					moves[newRow][newColumn] = true;
			}
			if(chessBoard[newRow][column] == null) {
				moves[newRow][column] = true;
				if(!firstMove) {
					newRow = row + (direction * 2);
					if(chessBoard[newRow][column] == null) {
						moves[newRow][column] = true;
					}
				}
			}
		}
	}
	
	public void updatePosition(int newRow, int newColumn) {
		
		row = newRow;
		column = newColumn;
	}
}