package Pieces;

import java.util.ArrayList;

public class King extends Piece {

	private ArrayList<Integer> possibleMoves;
	
	public King(boolean player, int row, int column) {
		super(player, row, column);
		possibleMoves = new ArrayList<Integer>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updatePossibleMoves(Piece[][] chessBoard) {
		// TODO Auto-generated method stub
		
	}
}
