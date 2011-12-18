// NaiveComputerPlayer class: child of ComputerPlayer, represents a naive computer player
// that plays the first available space starting from 1 and going to 9
public class NaiveComputerPlayer extends ComputerPlayer {

	/*
	Pre: The player has been prompted to move
	Post: The space played has been assigned to the board
	*/
	public int makeMove() {
	
		// playing the first available spot start from 1 and going to 9
		for (int i = 1; i<=9; i++) {

			if (TicTacToeBoard.isValidSpace(i)) {
	
				return i;
			}
		}
		
		return -1;
	}
}
