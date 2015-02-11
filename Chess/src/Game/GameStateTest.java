package Game;

import java.util.ArrayList;

import Board.ChessBoard;
import Pieces.Piece;

public class GameStateTest {
	
	private ChessBoard chessBoard;
	
	public GameStateTest() {
		
		chessBoard = new ChessBoard();
	}
	
	public void getGameState(ChessBoard chessBoardToClone, boolean player, GameState gameState) {
		
		ArrayList<Piece> whtPieces = chessBoardToClone.getWhtPieces();
		ArrayList<Piece> blkPieces = chessBoardToClone.getBlkPieces();
		if(player) {
			Piece blkKing = chessBoardToClone.getBlkKing();
			if(isKingPositionUnderAttack(whtPieces, blkKing)) {
				if(isKingPossibleMovePositionUnderAttack(whtPieces, blkKing)) {
					chessBoard.cloneBoard(chessBoardToClone);
					if(isThereLegalMove(chessBoardToClone, blkPieces, blkKing, player)) {
						gameState.gameState = GameState.State.CHECK;
					}
					else {
						gameState.gameState = GameState.State.CHECKMATE;
					}
				}
				else {
					gameState.gameState = GameState.State.CHECK;
				}
			}
			else {
				if(isKingPossibleMovePositionUnderAttack(whtPieces, blkKing)) {
					chessBoard.cloneBoard(chessBoardToClone);
					if(isThereLegalMove(chessBoardToClone, blkPieces, blkKing, player)) {
						gameState.gameState = GameState.State.NONE;
					}
					else {
						gameState.gameState = GameState.State.STALEMATE;
					}
				}
				else {
					gameState.gameState = GameState.State.NONE;
				}
			}
		}
		else {
			Piece whtKing = chessBoardToClone.getWhtKing();
			if(isKingPositionUnderAttack(blkPieces, whtKing)) {
				if(isKingPossibleMovePositionUnderAttack(blkPieces, whtKing)) {
					chessBoard.cloneBoard(chessBoardToClone);
					if(isThereLegalMove(chessBoardToClone, whtPieces, whtKing, player)) {
						gameState.gameState = GameState.State.CHECK;
					}
					else {
						gameState.gameState = GameState.State.CHECKMATE;
					}
				}
				else {
					gameState.gameState = GameState.State.CHECK;
				}
			}
			else {
				if(isKingPossibleMovePositionUnderAttack(blkPieces, whtKing)) {
					chessBoard.cloneBoard(chessBoardToClone);
					if(isThereLegalMove(chessBoardToClone, whtPieces, whtKing, player)) {
						gameState.gameState = GameState.State.NONE;
					}
					else {
						gameState.gameState = GameState.State.STALEMATE;
					}
				}
				else {
					gameState.gameState = GameState.State.NONE;
				}
			}
		}
	}
	
	private boolean isThereLegalMove(ChessBoard chessBoardToClone, ArrayList<Piece> pieces, Piece king, boolean player) {
		
	
		for(int i = 0; i < pieces.size(); i++) {
			Piece currPiece = pieces.get(i);
			ArrayList<Integer> possibleMoves = currPiece.getPossibleMoves();
			int row = currPiece.getRow();
			int column = currPiece.getColumn();
			for(int j = 0; j < possibleMoves.size(); j++) {
				int pieceNumber = possibleMoves.get(j);
				int newRow = pieceNumber / 10;
				int newColumn = pieceNumber % 10;
				chessBoard.movePiece(row, column, newRow, newColumn, '0');
				chessBoard.updatePossibleMoves(true);
				chessBoard.updatePossibleMoves(false);
				ArrayList<Piece> piecesToTest;
				if(player) {
					piecesToTest = chessBoard.getWhtPieces();
				}
				else {
					piecesToTest = chessBoard.getBlkPieces();
				}
				if(!isKingPositionUnderAttack(piecesToTest, king)) {
					return true;
				}
				chessBoard.cloneBoard(chessBoardToClone);
			}
		}
		return false;
	}
			
	private boolean isKingPositionUnderAttack(ArrayList<Piece> pieces, Piece king) {
		
		return isPositionUnderAttack(pieces, king.getRow(), king.getColumn());
	}
	
	private boolean isKingPossibleMovePositionUnderAttack(ArrayList<Piece> pieces, Piece king) {
		
		ArrayList<Integer> kingPossibleMoves = king.getPossibleMoves();
		int kingPossibleMovesSize = kingPossibleMoves.size();
		int numberOfPossibleMovesUnderAttack = 0;
		
		for(int i = 0; i < kingPossibleMovesSize; i++) {
			int kingNumber = kingPossibleMoves.get(i);
			int kingPossibleRow = kingNumber / 10;
			int kingPossibleColumn = kingNumber % 10;
			if(isPositionUnderAttack(pieces, kingPossibleRow, kingPossibleColumn)) {
				numberOfPossibleMovesUnderAttack++;
			}
		}
		return numberOfPossibleMovesUnderAttack == kingPossibleMovesSize;
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
}