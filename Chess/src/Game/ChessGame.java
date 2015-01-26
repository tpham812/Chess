package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Board.ChessBoard;
import Pieces.Piece;

public class ChessGame {

	private static ChessBoard chessBoard;
	private static boolean checkMate;
	private static boolean player;
	private static boolean draw;
	private static boolean wantsDraw;
	private static boolean badInput;
	private static int row;
	private static int column;
	private static int newRow;
	private static int newColumn;
	private static BufferedReader br; 
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		chessBoard = new ChessBoard();
		checkMate = false;
		draw = false;
		player = true;
		startGame();
	}
	
	private static void startGame() throws IOException {
		
		while(!checkMate) {
		
			badInput = false;
			chessBoard.displayChessBoard();
			if(player) 
				System.out.print("\nWhite's Move: ");
			else 
				System.out.print("\nBlack's Move: ");
			String input = br.readLine();
			parsePlayerInput(input);
			if(draw) {
				System.out.print("\nDraw Game. No winners.\n");
				break;
			}
			if(!badInput) 
				if(chessBoard.isPieceAtLocation(row, column)) {
					if(isPlayerPiece()) {
						if(isValidMove()) {
							chessBoard.movePiece(row, column, newRow, newColumn);
							chessBoard.updatePossibleMoves(player);
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
			else 
				badInput = true;
		}
	}
	
	private static boolean isValidMove() {
		
		Piece piece = chessBoard.getPiece(row, column);
		return piece.isVaildMove(newRow, newColumn);
	}
	
	private static boolean isPlayerPiece() {
		
		Piece piece = chessBoard.getPiece(row, column);
		return piece.player == player;
	}
}