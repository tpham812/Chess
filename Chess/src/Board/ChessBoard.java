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
		
	}
	
	private void createChessBoard() {
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i == 0) {
					if(j == 0 || j == 7) {chessBoard[i][j] = new Rook('b', i, j); blkPieces.add(chessBoard[i][j]);}
					else if(j == 1 || j == 6) {chessBoard[i][j] = new Knight('b', i, j); blkPieces.add(chessBoard[i][j]);}
					else if(j == 2 || j == 5) {chessBoard[i][j] = new Bishop('b', i, j); blkPieces.add(chessBoard[i][j]);}
					else if(j == 4) {chessBoard[i][j] = new King('b', i , j); blkPieces.add(chessBoard[i][j]);}
					else if (j == 3) { chessBoard[i][j] = new Queen('b', i, j); blkPieces.add(chessBoard[i][j]);}
				}
				else if(i == 1) {chessBoard[i][j] = new Pawn('b', i, j); blkPieces.add(chessBoard[i][j]);}
				else if (i == 6) {chessBoard[i][j] = new Pawn('w', i, j); whtPieces.add(chessBoard[i][j]);}
				else if(i == 7) {
					if(j == 0 || j == 7) {chessBoard[i][j] = new Rook('w', i, j); whtPieces.add(chessBoard[i][j]);}
					else if(j == 1 || j == 6) {chessBoard[i][j] = new Knight('w', i, j); whtPieces.add(chessBoard[i][j]);}
					else if(j == 2 || j == 5) {chessBoard[i][j] = new Bishop('w', i, j); whtPieces.add(chessBoard[i][j]);}
					else if(j == 4) {chessBoard[i][j] = new King('w', i, j); whtPieces.add(chessBoard[i][j]);}
					else if (j == 3) {chessBoard[i][j] = new Queen('w', i, j); whtPieces.add(chessBoard[i][j]);}
				}
				else if (i == 2 || i == 3 || i == 4 || i == 5) {chessBoard[i][j] = null;}
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
					if(chessBoard[i][j] instanceof Pawn) {if(chessBoard[i][j].player == 'b') System.out.print("bp "); else System.out.print("wp ");}
					else if(chessBoard[i][j] instanceof Rook) {if(chessBoard[i][j].player == 'b') System.out.print("bR "); else System.out.print("wR ");}
					else if(chessBoard[i][j] instanceof Knight) {if(chessBoard[i][j].player == 'b') System.out.print("bN "); else System.out.print("wN ");}
					else if(chessBoard[i][j] instanceof Bishop) {if(chessBoard[i][j].player == 'b') System.out.print("bB "); else System.out.print("wB ");}
					else if(chessBoard[i][j] instanceof Queen) {if(chessBoard[i][j].player == 'b') System.out.print("bQ "); else System.out.print("wQ ");}
					else if(chessBoard[i][j] instanceof King) {if(chessBoard[i][j].player == 'b') System.out.print("bK "); else System.out.print("wK ");}
				}
				else {
					if(i == 0 || i == 2 || i == 4 || i == 6) {if(j == 0 || j % 2 == 0) System.out.print("   "); else System.out.print("## ");}
					else if(i == 1 || i == 3 || i == 5 || i == 7) {if(j == 0 || j % 2 == 0) System.out.print("## "); else System.out.print("   ");}
				}
			}
			System.out.println();
		}
	}
}
