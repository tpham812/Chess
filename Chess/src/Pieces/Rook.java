package Pieces;

public class Rook extends Piece {


	public boolean firstMove;
	
	public Rook(boolean player, int row, int column) {
		
		super(player, row, column);
		firstMove = false;
	}
	
	public void updatePossibleMoves(Piece[][] chessBoard) {
		
		int newRow, newColumn;
		Piece piece;
		
		setMovesFalse();
		possibleMoves.clear();
		
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
	
	public void updatePosition(int newRow, int newColumn) {
		
		firstMove = true;
		row = newRow;
		column = newColumn;
	}
}