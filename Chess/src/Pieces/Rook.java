package Pieces;

public class Rook extends Piece {

	public Rook(boolean player, int row, int column) {
		
		super(player, row, column);
	}
	
	public void updatePossibleMoves(Piece[][] chessBoard) {
		
		int newRow, newColumn;
		Piece piece;
		
		setMovesFalse();
		possibleMoves.clear();
		
		newColumn = column + 1;
		while(newColumn < 8) {
			piece = chessBoard[row][newColumn];
			if(piece == null || piece.player != player) {
				moves[row][newColumn] = true;
				possibleMoves.add(row * 10 + newColumn);
			}
			else 
				break;
			newColumn++;
		}
		newColumn = column - 1;
		while(newColumn >= 0) {
			piece = chessBoard[row][newColumn];
			if(piece == null || piece.player != player) {
				moves[row][newColumn] = true;
				possibleMoves.add(row * 10 + newColumn);
			}
			else 
				break;
			newColumn--;
		}
		newRow = row + 1;
		while(newRow < 8) {
			piece = chessBoard[newRow][column];
			if(piece == null || piece.player != player) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
			}
			else 
				break;
			newRow++;
		}
		newRow = row - 1;
		while(newRow >= 0) {
			piece = chessBoard[newRow][column];
			if(piece == null || piece.player != player) {
				moves[newRow][column] = true;
				possibleMoves.add(newRow * 10 + column);
			}
			else 
				break;
			newRow--;
		}
	}
}