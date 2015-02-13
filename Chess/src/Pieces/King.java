package Pieces;

import java.util.ArrayList;

public class King extends Piece {

	private boolean firstMove;
	private boolean isCheck;
	
	public King(boolean player, int row, int column) {
		
		super(player, row, column);
		setMovesFalse();
		firstMove = false;
		isCheck = false;
	}

	public void updatePossibleMoves(Piece[][] chessBoard) {

		int newRow, newColumn;
		Piece piece;
		
		resetMovesFalse();
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
	
	public void updateCastlingPossibleMoves(Piece[][] chessBoard) {
		
		if(firstMove && isCheck) return;
		
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
	
	public void testForCheck(ArrayList<Piece> enemyPieces) {
		
		if(isPositionUnderAttack(enemyPieces, row, column)) {
			isCheck = true;
		}
		else {
			isCheck = false;
		}
	}
	
	public void removePossibleMovesUnderAttack(ArrayList<Piece> enemyPieces) {
		
		for(int i = 0; i < possibleMoves.size(); i++) {
			int kingNumber = possibleMoves.get(i);
			int possibleRow = kingNumber / 10;
			int possibleColumn = kingNumber % 10;
			if(isPositionUnderAttack(enemyPieces, possibleRow, possibleColumn)) {
				possibleMoves.remove(i);
				moves[possibleRow][possibleColumn] = false;
				i--;
			}
		}
	}
	private boolean isPositionUnderAttack(ArrayList<Piece> pieces, int row, int column) {
		
		for(int i = 0; i < pieces.size(); i++) {
			Piece piece = pieces.get(i);
			ArrayList<Integer> possibleMoves = piece.getPossibleMoves();
			for(int j = 0; j < possibleMoves.size(); j++) {
				int pieceNumber = possibleMoves.get(j);
				int pieceRow = pieceNumber / 10;
				int pieceColumn = pieceNumber % 10;
				if(row == pieceRow && column == pieceColumn) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void updatePosition(int newRow, int newColumn) {
		
		firstMove = true;
		row = newRow;
		column = newColumn;
	}
	
	public boolean getFirstMove() {
		
		return firstMove;
	}
	
	public void setFirstMove(boolean firstMove) {
		
		this.firstMove = firstMove;
	}
	
	public boolean getIsCheck() {
		
		return isCheck;
	}
}