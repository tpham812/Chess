package Board;

import java.util.ArrayList;

import Pieces.*;

public class ChessBoard {

	private static Piece[][] chessBoard;
	private static Piece blkKing;
	private static Piece whtKing;
	private static ArrayList<Piece> blkPieces;
	private static ArrayList<Piece> whtPieces;
	
	public ChessBoard() {
		
		chessBoard = new Piece[8][8];
		blkPieces = new ArrayList<Piece>();
		whtPieces = new ArrayList<Piece>();
		blkKing = null;
		whtKing = null;
		createChessBoard();
		updatePossibleMoves(false);
		updatePossibleMoves(true);
	}
	
	private void createChessBoard() {
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if (i > 1 && i < 6) {chessBoard[i][j] = null;}
				else if(i == 0) {
					if(j == 0 || j == 7) { Rook rook = new Rook(false, i, j); chessBoard[i][j] = rook; blkPieces.add(rook); }
					else if(j == 1 || j == 6) { Knight knight = new Knight(false, i, j); chessBoard[i][j] = knight; blkPieces.add(knight); }
					else if(j == 2 || j == 5) { Bishop bishop = new Bishop(false, i, j); chessBoard[i][j] = bishop; blkPieces.add(bishop); }
					else if(j == 4) { King king = new King(false, i , j); chessBoard[i][j] = king; blkKing = king; blkPieces.add(king); }
					else if (j == 3) { Queen queen = new Queen(false, i, j); chessBoard[i][j] = queen; blkPieces.add(queen); }
				}
				else if(i == 1) { Pawn pawn = new Pawn(false, i, j, 1); chessBoard[i][j] = pawn; blkPieces.add(pawn); }
				else if (i == 6) { Pawn pawn = new Pawn(true, i, j, -1); chessBoard[i][j] = pawn; whtPieces.add(pawn); }
				else if(i == 7) {
					if(j == 0 || j == 7) { Rook rook = new Rook(true, i, j); chessBoard[i][j] = rook; whtPieces.add(rook);}
					else if(j == 1 || j == 6) { Knight knight = new Knight(true, i, j); chessBoard[i][j] = knight; whtPieces.add(knight);}
					else if(j == 2 || j == 5) { Bishop bishop = new Bishop(true, i, j); chessBoard[i][j] = bishop; whtPieces.add(bishop);}
					else if(j == 4) { King king = new King(true, i, j); chessBoard[i][j] = king; whtKing = king; whtPieces.add(king);}
					else if (j == 3) { Queen queen = new Queen(true, i, j); chessBoard[i][j] = queen; whtPieces.add(queen);}
				}
			}
		}
	}
	
	public void displayChessBoard() {
		
		char alpha = 'a';
		int num = (int)alpha;
		int num2 = 8;
		
		System.out.println();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i == 8 && j == 8) continue;
				if(i == 8) {System.out.print(" " + alpha + " "); num = num + 1; alpha = (char)num;}
				else if(j == 8) {System.out.print(num2--);}
				else if(chessBoard[i][j] != null) {
					if(chessBoard[i][j] instanceof Pawn) {if(!chessBoard[i][j].player) System.out.print("bp "); else System.out.print("wp ");}
					else if(chessBoard[i][j] instanceof Rook) {if(!chessBoard[i][j].player) System.out.print("bR "); else System.out.print("wR ");}
					else if(chessBoard[i][j] instanceof Knight) {if(!chessBoard[i][j].player) System.out.print("bN "); else System.out.print("wN ");}
					else if(chessBoard[i][j] instanceof Bishop) {if(!chessBoard[i][j].player) System.out.print("bB "); else System.out.print("wB ");}
					else if(chessBoard[i][j] instanceof Queen) {if(!chessBoard[i][j].player) System.out.print("bQ "); else System.out.print("wQ ");}
					else if(chessBoard[i][j] instanceof King) {if(!chessBoard[i][j].player) System.out.print("bK "); else System.out.print("wK ");}
				}
				else {
					if(i % 2 == 0) {
						if(j % 2 == 0) System.out.print("   "); else System.out.print("## ");}
					else {if(j % 2 == 0) System.out.print("## "); else System.out.print("   ");}
				}
			}
			System.out.println();
		}
	}
	
	public void updatePossibleMoves(boolean player) {
		
		if(player) {
			for(int i = 0; i < whtPieces.size(); i++) 
				whtPieces.get(i).updatePossibleMoves(chessBoard);
		}
		else {
			for(int i = 0; i < blkPieces.size(); i++) 
				blkPieces.get(i).updatePossibleMoves(chessBoard);
		}
	}
	
	public void movePiece(int row, int column, int newRow, int newColumn) {
		
		Piece piece = chessBoard[row][column];
		chessBoard[newRow][newColumn] = piece;
		chessBoard[row][column] = null;
		piece.updatePosition(newRow, newColumn);
	}
	
	public boolean isPieceAtLocation(int row, int column) {
		
		if(chessBoard[row][column] != null)
			return true;
		
		return false;
	}
	
	public Piece getPiece(int row, int column) {
		
		return chessBoard[row][column];
	}
		
	public Piece getKing(boolean player) {
		
		if(player)
			return whtKing;
		
		return blkKing;
	}
	
	public void printPossibleMoves(int row, int column) {
		chessBoard[row][column].printPossibleMoves();
	}
}