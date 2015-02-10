package Game;

public class State {

	public GameState gameState;
	
	public enum GameState {
		
		CHECK, CHECKMATE, STALEMATE, NONE
	}
	
	public State() {
		
		gameState = GameState.NONE;
	}
}
