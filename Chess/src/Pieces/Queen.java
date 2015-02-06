package Pieces;

public class Queen extends Piece {

	public Queen(boolean player, int row, int column) {
		
		super(player, row, column);
	}

	public void updatePossibleMoves(Piece[][] chessBoard) {
		
		int newRow, newColumn;
		Piece piece;
		
		setMovesFalse();
		possibleMoves.clear();
		
		newRow = row - 1;
		newColumn = column - 1;
		while(newRow >= 0 && newColumn >= 0) {
			piece = chessBoard[newRow][newColumn];
			if(piece == null) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
			}
			else if(piece.player != player) { 
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
				break;
			}
			else 
				break;
			newRow--;
			newColumn--;
		}
		newRow = row - 1;
		newColumn = column + 1;
		while(newRow >= 0 && newColumn < 8) {
			piece = chessBoard[newRow][newColumn];
			if(piece == null) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
			}
			else if(piece.player != player) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
				break;
			}
			else 
				break;
			newRow--;
			newColumn++;
		}
		newRow = row + 1;
		newColumn = column - 1;
		while(newRow < 8 && newColumn >= 0) {
			piece = chessBoard[newRow][newColumn];
			if(piece == null) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
			}
			else if(piece.player != player) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
				break;
			}
			else 
				break;
			newRow++;
			newColumn--;
		}
		newRow = row + 1;
		newColumn = column + 1;
		while(newRow < 8 && newColumn < 8) {
			piece = chessBoard[newRow][newColumn];
			if(piece == null) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
			}
			else if(piece.player != player) { 
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
				break;
			}
			else 
				break;
			newRow++;
			newColumn++;
		}
		newColumn = column + 1;
		while(newColumn < 8) {
			piece = chessBoard[row][newColumn];
			if(piece == null) {
				moves[row][newColumn] = true;
				possibleMoves.add(row * 10 + newColumn);
			}
			else if(piece.player != player) {
				moves[row][newColumn] = true;
				possibleMoves.add(row * 10 + newColumn);
				break;
			}
			else 
				break;
			newColumn++;
		}
		newColumn = column - 1;
		while(newColumn >= 0) {
			piece = chessBoard[row][newColumn];
			if(piece == null) {
				moves[row][newColumn] = true;
				possibleMoves.add(row * 10 + newColumn);
			}
			else if(piece.player != player) {
				moves[row][newColumn] = true;
				possibleMoves.add(row * 10 + newColumn);
				break;
			}
			else
				break;
			newColumn--;
		}
		newRow = row + 1;
		while(newRow < 8) {
			piece = chessBoard[newRow][column];
			if(piece == null) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
			}
			else if(piece.player != player) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
				break;
			}
			else 
				break;
			newRow++;
		}
		newRow = row - 1;
		while(newRow >= 0) {
			piece = chessBoard[newRow][column];
			if(piece == null) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
			}
			else if(piece.player != player) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
				break;
			}
			else
				break;
			newRow--;
		}
	}
}