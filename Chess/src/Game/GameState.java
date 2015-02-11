package Game;

public class GameState {

	public State gameState;
	
	public enum State {
		
		CHECK, CHECKMATE, STALEMATE, NONE
	}
	
	public GameState() {
		
		gameState = State.NONE;
	}
}