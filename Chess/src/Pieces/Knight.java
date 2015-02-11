package Pieces;

public class Knight extends Piece {

	public Knight(boolean player, int row, int column) {
		
		super(player, row, column);
		setMovesFalse();
	}

	public void updatePossibleMoves(Piece[][] chessBoard) {

		int newRow, newColumn;
		Piece piece;
		
		resetMovesFalse();
		possibleMoves.clear();
		
		newColumn = column + 2;
		if(newColumn < 8) {
			newRow = row + 1;
			if(newRow < 8) {
				piece = chessBoard[newRow][newColumn];
				if(piece == null || piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
			newRow = row - 1;
			if(newRow >= 0) {
				piece = chessBoard[newRow][newColumn];
				if(piece == null || piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
		}
		newColumn = column - 2;
		if(newColumn >= 0) {
			newRow = row + 1;
			if(newRow < 8) {
				piece = chessBoard[newRow][newColumn];
				if(piece == null || piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
			newRow = row - 1;
			if(newRow >= 0) {
				piece = chessBoard[newRow][newColumn];
				if(piece == null || piece.player != player) {
					moves[newRow][newColumn] = true;
					possibleMoves.add(newRow * 10 + newColumn);
				}
			}
		}
		newRow = row + 2;
		if(newRow < 8) {
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
		newRow = row - 2;
		if(newRow >= 0) {
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