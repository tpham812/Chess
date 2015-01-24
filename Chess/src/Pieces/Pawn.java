package Pieces;

public class Pawn extends Piece {

	private boolean firstMove;
	private boolean move2Ranks;
	private int direction;
	
	public Pawn(char player, int row, int column, int direction) {
		
		super(player, row, column);
		firstMove = false;
		move2Ranks = false;
		this.direction = direction;
	}

	public void updatePossibleMoves(Piece[][] chessBoard) {
	
		int newRow = 0;
		int newColumn = 0;
		Piece piece;
		
		setMovesFalse();
		possibleMoves.clear();
		
		newRow = row + (direction * 1);
		if(chessBoard[newRow][column] != null) {
			moves[newRow][column] = true;
			possibleMoves.add(newRow * 10 + column);
		}
		newColumn = column - 1;
		piece = chessBoard[newRow][newColumn];
		if(newColumn >= 0 && piece != null && piece.player != player ) {
			moves[newRow][newColumn] = true;
			possibleMoves.add(newRow * 10 + newColumn);
		}
		newColumn = column + 1;
		piece = chessBoard[newRow][newColumn];
		if(newColumn < 8  && piece != null && piece.player != player) {
			moves[newRow][newColumn] = true;
			possibleMoves.add(newRow * 10 + newColumn);
		}
		if(!firstMove) {
			newRow = row + (direction * 2);
			if(chessBoard[newRow][column] != null) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
			}
		}
	}

	public void updatePosition(int newRow, int newColumn) {
		
		row = newRow;
		column = newColumn;
	}
}