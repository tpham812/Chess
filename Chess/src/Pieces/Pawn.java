package Pieces;

public class Pawn extends Piece {

	private boolean firstMove;
	private boolean justMoved2Ranks;
	private int direction;
	
	public Pawn(boolean player, int row, int column, int direction) {
		
		super(player, row, column);
		firstMove = false;
		this.direction = direction;
	}

	public void updatePossibleMoves(Piece[][] chessBoard) {

		int newRow, newColumn; 
		Piece piece, piece2;

		setMovesFalse();
		possibleMoves.clear();
		
		justMoved2Ranks = false;
		newRow = row + direction;
		if(newRow >= 0 && newRow < 8) {
			newColumn = column - 1;
			if(newColumn >= 0 ) {
				piece = chessBoard[newRow][newColumn];
				piece2 = chessBoard[row][newColumn];
				if(piece == null && piece2 != null && piece2.player != player) 
					enPassant(piece2, newRow, newColumn);
				else if(piece != null && piece.player != player ) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
			newColumn = column + 1;
			if(newColumn < 8  ) {
				piece = chessBoard[newRow][newColumn];
				piece2 = chessBoard[row][newColumn];
				if(piece == null && piece2 != null && piece2.player != player) 
					enPassant(piece2, newRow, newColumn);
				else if(piece != null && piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
			if(chessBoard[newRow][column] == null) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
				if(!firstMove) {
					newRow = row + (direction * 2);
					if(chessBoard[newRow][column] == null) {
						moves[newRow][column] = true;
						possibleMoves.add(newRow * 10 + column);
					}
				}
			}
		}
	}
	
	private void enPassant(Piece piece, int newRow, int newColumn) {
		
		if(piece instanceof Pawn && ((Pawn)piece).justMoved2Ranks == true) {
			moves[newRow][newColumn] = true;
			possibleMoves.add(newRow * 10 + newColumn);
		}
	}
	
	public void updatePosition(int newRow, int newColumn) {
		
		if(Math.abs(newRow - row) == 2)
			justMoved2Ranks = true;
		firstMove = true;
		row = newRow;
		column = newColumn;
	}
}