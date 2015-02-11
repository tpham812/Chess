package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Board.ChessBoard;
import Pieces.Piece;

public class ChessGame {

	private static ChessBoard chessBoard;
	private static boolean player;
	private static boolean draw;
	private static boolean wantsDraw;
	private static boolean badInput;
	private static int row;
	private static int column;
	private static int newRow;
	private static int newColumn;
	private static char promoChoice;
	private static GameState gameState;
	private static GameStateTest gameStateTest;
	private static BufferedReader br; 
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		chessBoard = new ChessBoard();
		chessBoard.initialize();
		gameState = new GameState();
		gameStateTest = new GameStateTest();
		draw = false;
		player = true;
		startGame();
	}
	
	private static void startGame() throws IOException {
		
		while(gameState.gameState != GameState.State.CHECKMATE && gameState.gameState != GameState.State.STALEMATE) {
			badInput = false;
			promoChoice = '0';
			chessBoard.displayChessBoard();
			if(player) 
				System.out.print("\nWhite's Move: ");
			else 
				System.out.print("\nBlack's Move: ");
			String input = br.readLine();
			if(input.trim().equals(""))
				continue;
			parsePlayerInput(input);
			if(!isValidRowAndColumn()) 
				badInput = true;
			if(draw) {
				System.out.print("\nDraw Game. No winner.\n");
				break;
			}
			if(!badInput) {
				if(chessBoard.isPieceAtLocation(row, column)) {
					if(isPlayerPiece()) {
						if(isValidMove()) {
							chessBoard.movePiece(row, column, newRow, newColumn, promoChoice);
							chessBoard.updatePossibleMoves(!player);
							chessBoard.updatePossibleMoves(player);
							gameStateTest.getGameState(chessBoard, player, gameState);
							switch(gameState.gameState) {
								case CHECKMATE:
									if(player) {
										System.out.println("White wins. Black is in CheckMate.");
									}
									else {
										System.out.println("Black wins. White is in CheckMate.");
									}
									break;
								case STALEMATE:
									if(player) {
										System.out.println("White wins. Black is in StaleMate.");
									}
									else {
										System.out.println("Black wins. White is in StaleMate.");
									}
									break;
								case CHECK:
									if(player) {
										System.out.println("Black is in Check.");
									}
									else {
										System.out.println("White is in Check.");
									}
									break;
								default:
									break;
							}
							player = !player;
						}
						else 
							System.out.print("\nIllegal move. Try again.\n");
					}
					else 
						System.out.print("\nThat is not your piece to move. Try again.\n");
				}
				else 
					System.out.print("\nNo piece at that locaton. Try again.\n");
			}
			else 
				System.out.print("\nBad input. Try again.\n");
		}
	}
	
	private static void parsePlayerInput(String input) {
		
		if(wantsDraw && input.equals("draw")){
			draw = true;
			return;
		}
		wantsDraw = false;
		StringTokenizer tk = new StringTokenizer(input);
		String moves[] = new String[tk.countTokens()];
		int i = 0;
		while(tk.hasMoreTokens()) {
			moves[i] = tk.nextToken();
			i++;
		}
		if(moves[0].length() == 2) {
			column = moves[0].charAt(0) - 97;
			row = 8 - (moves[0].charAt(1) - 48);
		}
		else
			badInput = true;
		if(moves[1].length() == 2) {
			newColumn = moves[1].charAt(0) - 97;
			newRow = 8 - (moves[1].charAt(1) - 48);
		}
		else 
			badInput = true;
		if(moves.length == 3) {
			if(moves[2].equals("draw?")) 
				wantsDraw = true;
			else if(moves[2].length() == 1)
				promoChoice = moves[2].charAt(0);
				if(promoChoice != 'Q' && promoChoice != 'N' && promoChoice != 'B' && promoChoice != 'R')
					badInput = true;
			else 
				badInput = true;
		}
	}
	
	private static boolean isValidRowAndColumn () {
		
		return row >= 0 && row < 8 && newRow >= 0 && newRow < 8 && column >= 0 && column < 8 && newColumn >= 0 && newColumn < 8;
	}
	
	private static boolean isValidMove() {
		
		Piece piece = chessBoard.getPiece(row, column);
		return piece.isVaildMove(newRow, newColumn);
	}
	
	private static boolean isPlayerPiece() {
		
		Piece piece = chessBoard.getPiece(row, column);
		return piece.getPlayer() == player;
	}
}