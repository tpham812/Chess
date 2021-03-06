package Board;

import java.util.ArrayList;

import Pieces.*;

public class ChessBoard {

	private Piece[][] chessBoard;				
	private ArrayList<Piece> blkPieces;			
	private ArrayList<Piece> whtPieces;	
	private King blkKing;
	private King whtKing;
	
	public ChessBoard() {
		
		chessBoard = new Piece[8][8];
		blkPieces = new ArrayList<Piece>();
		whtPieces = new ArrayList<Piece>();
	}
	
	public void initialize() {
		
		createChessBoard();
		updatePossibleMoves();	
	}
	
	private void createChessBoard() {
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if (i > 1 && i < 6) {chessBoard[i][j] = null;}
				else if(i == 0) {
					if(j == 0 || j == 7) { Rook rook = new Rook(false, i, j); chessBoard[i][j] = rook; blkPieces.add(rook); }
					else if(j == 1 || j == 6) { Knight knight = new Knight(false, i, j); chessBoard[i][j] = knight; blkPieces.add(knight); }
					else if(j == 2 || j == 5) { Bishop bishop = new Bishop(false, i, j); chessBoard[i][j] = bishop; blkPieces.add(bishop); }
					else if(j == 4) { King king = new King(false, i , j); chessBoard[i][j] = king; blkKing = king; blkPieces.add(king);}
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
	
	public void cloneBoard(ChessBoard chessBoardToClone) {
		
		Piece[][] board = chessBoardToClone.getChessBoard();
		setChessBoardEmpty();
		whtPieces.clear();
		blkPieces.clear();
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Piece piece = board[i][j];
				if(piece == null) continue;
				Piece newPiece = null;
				boolean player = piece.getPlayer();
				if(piece instanceof Pawn) {
					Pawn castPiece = (Pawn)piece;
					newPiece = new Pawn(player, i, j, castPiece.getDirection());
					Pawn castPawn = (Pawn)newPiece;
					castPawn.setFirstMove(castPiece.getFirstMove());
					castPawn.setJustMoved2Ranks(castPiece.getJustMoved2Ranks());
				}
				else if(piece instanceof Rook) {
					newPiece = new Rook(player, i, j);
					Rook castRook = (Rook)newPiece;
					Rook castPiece = (Rook)piece;
					castRook.setFirstMove(castPiece.getFirstMove());
				}
				else if(piece instanceof Bishop) {
					newPiece = new Bishop(player, i, j);
				}
				else if(piece instanceof Knight) {
					newPiece = new Knight(player, i, j);
				}
				else if(piece instanceof Queen) {
					newPiece = new Queen(player, i, j);
				}
				else {
					newPiece = new King(player, i, j);
					King castKing = (King)newPiece;
					King castPiece = (King)piece;
					castKing.setFirstMove(castPiece.getFirstMove());
					if(player){
						whtKing = (King)newPiece;
					}
					else {
						blkKing = (King)newPiece;
					}
				}
				if(player) {
					whtPieces.add(newPiece);
				}
				else {
					blkPieces.add(newPiece);
				}
				chessBoard[i][j] = newPiece;
			}
		}
		updatePossibleMoves();
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
					if(chessBoard[i][j] instanceof Pawn) {if(!chessBoard[i][j].getPlayer()) System.out.print("bp "); else System.out.print("wp ");}
					else if(chessBoard[i][j] instanceof Rook) {if(!chessBoard[i][j].getPlayer()) System.out.print("bR "); else System.out.print("wR ");}
					else if(chessBoard[i][j] instanceof Knight) {if(!chessBoard[i][j].getPlayer()) System.out.print("bN "); else System.out.print("wN ");}
					else if(chessBoard[i][j] instanceof Bishop) {if(!chessBoard[i][j].getPlayer()) System.out.print("bB "); else System.out.print("wB ");}
					else if(chessBoard[i][j] instanceof Queen) {if(!chessBoard[i][j].getPlayer()) System.out.print("bQ "); else System.out.print("wQ ");}
					else if(chessBoard[i][j] instanceof King) {if(!chessBoard[i][j].getPlayer()) System.out.print("bK "); else System.out.print("wK ");}
				}
				else {
					if(i % 2 == 0) {
						if(j % 2 == 0) System.out.print("   "); else System.out.print("## ");}
					else {
						if(j % 2 == 0) System.out.print("## "); else System.out.print("   ");}
				}
			}
			System.out.println();
		}
	}
	
	public void updatePossibleMoves() {
		
		for(int i = 0; i < whtPieces.size(); i++) {
			whtPieces.get(i).updatePossibleMoves(chessBoard);
		}
		for(int i = 0; i < blkPieces.size(); i++) { 
			blkPieces.get(i).updatePossibleMoves(chessBoard);
		}
		whtKing.testForCheck(blkPieces);
		blkKing.testForCheck(whtPieces);
		whtKing.updateCastlingPossibleMoves(chessBoard);
		blkKing.updateCastlingPossibleMoves(chessBoard);
		whtKing.removePossibleMovesUnderAttack(blkPieces);
		blkKing.removePossibleMovesUnderAttack(whtPieces);
	}
	
	public void movePiece(int row, int column, int newRow, int newColumn, char promoChoice) {
		
		Piece piece = chessBoard[row][column];
		Piece targetPiece = chessBoard[newRow][newColumn];
		
		if(isEnPassantMove(piece, row, column, newColumn)) {
			enPassant(row, newColumn);
		}
		else if(isCastlingMove(piece, column, newColumn)) {
			castling(row, column, newColumn);
		}
		else if(isPromotion(piece, newRow)) {
			removePieceFromCollections(piece.getPlayer(), piece);
			piece = promotion(piece, promoChoice, row, column);
		}	
		if(targetPiece != null) {
			removePieceFromCollections(targetPiece.getPlayer(), targetPiece);
		}
		chessBoard[newRow][newColumn] = piece;
		chessBoard[row][column] = null;
		piece.updatePosition(newRow, newColumn);
	}
	
	public boolean isPieceAtLocation(int row, int column) {
		
		if(chessBoard[row][column] != null) {
			return true;
		}
		return false;
	}
	
	public Piece getPiece(int row, int column) {
		
		return chessBoard[row][column];
	}
	
	public Piece[][] getChessBoard() {
		
		return chessBoard;
	}
	
	public Piece getWhtKing() {
		
		return whtKing;
	}
	
	public Piece getBlkKing() {
		
		return blkKing;
	}
	
	public ArrayList<Piece> getWhtPieces() {
		
		return whtPieces;
	}
	
	public ArrayList<Piece> getBlkPieces() {
	
		return blkPieces;
	}
	
	private void enPassant(int row, int newColumn) {
		
		Piece piece = chessBoard[row][newColumn];
		removePieceFromCollections(piece.getPlayer(), piece);
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
	
	private Piece promotion(Piece piece, char promoChoice, int row, int column) {
		
		boolean player = piece.getPlayer();
		
		if(promoChoice == '0' || promoChoice == 'Q') { 
			Queen queen = new Queen(player, row, column);
			addPieceToCollections(player, queen);
			return queen;
		}
		else if(promoChoice == 'N') {
			Knight knight =  new Knight(player, row, column);
			addPieceToCollections(player, knight);
			return knight;
		}
		else if(promoChoice == 'R') {
			Rook rook = new Rook(player, row, column);
			addPieceToCollections(player, rook);
			return rook;
		}
		else {
			Bishop bishop = new Bishop(player, row, column);
			addPieceToCollections(player, bishop);
			return bishop;
		}
	}
	
	private boolean isEnPassantMove(Piece piece, int row, int column, int newColumn) {
		
		Piece testingPiece = chessBoard[row][newColumn];
		return piece instanceof Pawn && Math.abs(column - newColumn) == 1 && testingPiece != null && testingPiece instanceof Pawn;
	}
	
	private boolean isCastlingMove(Piece piece, int column, int newColumn) {
		
		return piece instanceof King && Math.abs(newColumn - column) == 2;
	}
	
	private boolean isPromotion(Piece piece, int newRow) {
	
		return piece instanceof Pawn && newRow % 7 == 0;
	}
	
	private void addPieceToCollections(boolean player, Piece piece) {
		
		if(player) {
			whtPieces.add(piece);
		}
		else {
			blkPieces.add(piece);
		}
	}
	private void removePieceFromCollections(boolean player, Piece piece) {
		
		if(player) {
			whtPieces.remove(piece);
		}
		else {
			blkPieces.remove(piece);
		}
	}
	
	private void setChessBoardEmpty() {
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				chessBoard[i][j] = null;
			}
		}
	}
}