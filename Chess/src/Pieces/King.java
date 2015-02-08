package Pieces;

public class King extends Piece {

	private boolean firstMove;
	
	public King(boolean player, int row, int column) {
		
		super(player, row, column);
		firstMove = false;
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
		if(!firstMove)
			castling(chessBoard);
	}
	
	private void castling(Piece[][] chessBoard) {
		
		Piece piece = chessBoard[row][0];
		if(piece != null && piece instanceof Rook && !((Rook)piece).firstMove) {
			boolean check = true;
			int i = 1;
			while(i < 4) {
				if(chessBoard[row][i] != null) {
					check = false;
					break;
				}
				i++;
			}
			if(check) {
				moves[row][2] = true;
				possibleMoves.add(row * 10 + 2);
			}
		}
		piece = chessBoard[row][7];
		if(piece != null & piece instanceof Rook && !((Rook)piece).firstMove) {
			boolean check = true;
			int i = 6;
			while(i > 4) {
				if(chessBoard[row][i] != null) {
					check = false;
					break;
				}
				i--;
			}
			if(check) {
				moves[row][6] = true;
				possibleMoves.add(row * 10 + 6);
			}
		}
	}
	
	public void updatePosition(int newRow, int newColumn) {
		
		firstMove = true;
		row = newRow;
		column = newColumn;
	}
}