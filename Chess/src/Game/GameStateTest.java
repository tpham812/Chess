package Game;

import java.util.ArrayList;

import Board.ChessBoard;
import Pieces.Piece;

public class GameStateTest {
	
	private static ChessBoard chessBoard;
	
	public GameStateTest() {
		
		chessBoard = new ChessBoard();
	}
	
	public void getGameState(ChessBoard chessBoardToClone, boolean player, GameState gameState) {
		
		if(player) {
			Piece blkKing = chessBoardToClone.getBlkKing();
			ArrayList<Piece> blkPieces = chessBoardToClone.getBlkPieces();
			if(isKingPositionUnderAttack(blkPieces, blkKing)) {
				if(isKingPossibleMovePositionUnderAttack(blkPieces, blkKing)) {
					chessBoard.cloneBoard(chessBoardToClone);
				}
				else {
					gameState.gameState = GameState.State.CHECK;
				}
			}
			else {
				if(isKingPossibleMovePositionUnderAttack(blkPieces, blkKing)) {
					chessBoard.cloneBoard(chessBoardToClone);
				}
				else {
					gameState.gameState = GameState.State.NONE;
				}
			}
		}
		else {
			Piece whtKing = chessBoardToClone.getWhtKing();
			ArrayList<Piece> whtPieces = chessBoardToClone.getWhtPieces();
			if(isKingPositionUnderAttack(whtPieces, whtKing)) {
				if(isKingPossibleMovePositionUnderAttack(whtPieces, whtKing)) {
					chessBoard.cloneBoard(chessBoardToClone);
				}
				else {
					gameState.gameState = GameState.State.CHECK;
				}
			}
			else {
				if(isKingPossibleMovePositionUnderAttack(whtPieces, whtKing)) {
					chessBoard.cloneBoard(chessBoardToClone);
				}
				else {
					gameState.gameState = GameState.State.NONE;
				}
			}
		}
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