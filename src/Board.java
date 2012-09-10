// Board interface
public interface Board {
	
	// Displays the board with any current modifcations
    public void displayBoard();
    
    // takes in an int from the player representing a space on the board
	public void turn(int space); 
}
