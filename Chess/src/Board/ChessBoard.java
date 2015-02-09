package Board;

import java.util.ArrayList;

import Pieces.*;

public class ChessBoard {

	private static Piece[][] chessBoard;				
	private static ArrayList<Piece> blkPieces;			
	private static ArrayList<Piece> whtPieces;			
	
	public ChessBoard() {
		
		chessBoard = new Piece[8][8];
		blkPieces = new ArrayList<Piece>();
		whtPieces = new ArrayList<Piece>();
	}
	
	public void initialize() {
		
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
					else if(j == 4) { King king = new King(false, i , j); chessBoard[i][j] = king; blkPieces.add(king); }
					else if (j == 3) { Queen queen = new Queen(false, i, j); chessBoard[i][j] = queen; blkPieces.add(queen); }
				}
				else if(i == 1) { Pawn pawn = new Pawn(false, i, j, 1); chessBoard[i][j] = pawn; blkPieces.add(pawn); }
				else if (i == 6) { Pawn pawn = new Pawn(true, i, j, -1); chessBoard[i][j] = pawn; whtPieces.add(pawn); }
				else if(i == 7) {
					if(j == 0 || j == 7) { Rook rook = new Rook(true, i, j); chessBoard[i][j] = rook; whtPieces.add(rook);}
					else if(j == 1 || j == 6) { Knight knight = new Knight(true, i, j); chessBoard[i][j] = knight; whtPieces.add(knight);}
					else if(j == 2 || j == 5) { Bishop bishop = new Bishop(true, i, j); chessBoard[i][j] = bishop; whtPieces.add(bishop);}
					else if(j == 4) { King king = new King(true, i, j); chessBoard[i][j] = king; whtPieces.add(king);}
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
	
	public void movePiece(int row, int column, int newRow, int newColumn, char promoChoice) {
		
		Piece piece = chessBoard[row][column];
		if(isEnPassantMove(piece, newRow, newColumn)) {
			enPassant(row, newColumn);
		}
		else if(isCastlingMove(piece, column, newColumn)) {
			castling(row, column, newColumn);
		}
		chessBoard[newRow][newColumn] = piece;
		chessBoard[row][column] = null;
		if(isPromotion(piece, newRow)) {
			promotion(promoChoice, newRow, newColumn);
		}
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
	
	public Piece[][] getChessBoard() {
		
		return chessBoard;
	}
	
	
	private void enPassant(int row, int newColumn) {
		
		chessBoard[row][newColumn] = null;
	}
	
	private void castling(int row, int column, int newColumn) {
		
		if(newColumn - column == 2) {
			chessBoard[row][column + 1] = chessBoard[row][newColumn + 1];
			chessBoard[row][newColumn + 1] = null;
		}
		else {
			chessBoard[row][column - 1] = chessBoard[row][newColumn - 2];
			chessBoard[row][newColumn - 2 ] = null;
		}
	}
	
	private void promotion(char promoChoice, int newRow, int newColumn) {
		
		boolean player = chessBoard[newRow][newColumn].player;
		
		if(promoChoice == '0' || promoChoice == 'Q') 
			chessBoard[newRow][newColumn] = new Queen(player, newRow, newColumn);
		else if(promoChoice == 'N') 
			chessBoard[newRow][newColumn] = new Knight(player, newRow, newColumn);
		else if(promoChoice == 'R') 
			chessBoard[newRow][newColumn] = new Rook(player, newRow, newColumn);
		else 
			chessBoard[newRow][newColumn] = new Bishop(player, newRow, newColumn);
	}
	
	
	private boolean isEnPassantMove(Piece piece, int newRow, int newColumn) {
		
		return piece instanceof Pawn && chessBoard[newRow][newColumn] == null;
	}
	
	private boolean isCastlingMove(Piece piece, int column, int newColumn) {
		
		return piece instanceof King && Math.abs(newColumn - column) == 2;
	}
	
	private boolean isPromotion(Piece piece, int newRow) {
		
		return piece instanceof Pawn && newRow % 7 == 0;
	}
}