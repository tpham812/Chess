package Pieces;

public class King extends Piece {

	public King(boolean player, int row, int column) {
		
		super(player, row, column);
	}

	public void updatePossibleMoves(Piece[][] chessBoard) {

		int newRow, newColumn;
		Piece piece;
		
		setMovesFalse();
		possibleMoves.clear();
		
		newColumn = column + 1;
		if(newColumn < 8) {
			piece = chessBoard[row][newColumn];
			if(piece == null || piece.player != player) {
				moves[row][newColumn] = true;
				possibleMoves.add(row * 10 + newColumn);
			}
		}
		newColumn = column - 1;
		if(newColumn >= 0) {
			piece = chessBoard[row][newColumn];
			if(piece == null || piece.player != player) {
				moves[row][newColumn] = true;
				possibleMoves.add(row * 10 + newColumn);
			}
		}
		newRow = row + 1;
		if(newRow < 8) {
			piece = chessBoard[newRow][column];
			if(piece == null || piece.player != player) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
			}
			newColumn = column + 1;
			if(newColumn < 8) {
				piece = chessBoard[newRow][newColumn];
				if(piece == null || piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
			newColumn = column - 1;
			if(newColumn >= 0) {
				piece = chessBoard[newRow][newColumn];
				if(piece == null || piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
		}
		newRow = row - 1;
		if(newRow >= 0) {
			piece = chessBoard[newRow][column];
			if(piece == null || piece.player != player) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
			}
			newColumn = column + 1;
			if(newColumn < 8) {
				piece = chessBoard[newRow][newColumn];
				if(piece == null || piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
			newColumn = column - 1;
			if(newColumn >= 0) {
				piece = chessBoard[newRow][newColumn];
				if(piece == null || piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
		}
	}
}