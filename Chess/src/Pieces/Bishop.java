package Pieces;

public class Bishop extends Piece {

	public Bishop(boolean player, int row, int column) {
		
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
			if(piece == null || piece.player != player) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
			}
			else {
				break;
			}
			newRow--;
			newColumn--;
		}
		newRow = row - 1;
		newColumn = column + 1;
		while(newRow >= 0 && newColumn < 8) {
			piece = chessBoard[newRow][newColumn];
			if(piece == null || piece.player != player) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
			}
			else {
				break;
			}
			newRow--;
			newColumn++;
		}
		newRow = row + 1;
		newColumn = column - 1;
		while(newRow < 8 && newColumn >= 0) {
			piece = chessBoard[newRow][newColumn];
			if(piece == null || piece.player != player) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
			}
			else {
				break;
			}
			newRow++;
			newColumn--;
		}
		newRow = row + 1;
		newColumn = column + 1;
		while(newRow < 8 && newColumn < 8) {
			piece = chessBoard[newRow][newColumn];
			if(piece == null || piece.player != player) {
				moves[newRow][newColumn] = true;
				possibleMoves.add(newRow * 10 + newColumn);
			}
			else {
				break;
			}
			newRow++;
			newColumn++;
		}
	}
}