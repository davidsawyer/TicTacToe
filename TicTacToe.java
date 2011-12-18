/*
This is the main class of our TicTacToe program. We ask the user to input human, random, naive, or cutthroat. 
We then implement our helper methods to display the board and keep track of where the marks go. 
*/
public class TicTacToe {
	//Precondition:
	//Postcondition: The user has specified the players.
	public static void main(String[] args) {

		if (args.length != 2) {

			System.out.println("Wrong number of arguments. Try again.");
			System.exit(0);
		}

		Player playerX = null;
		Player playerO = null;
		//set player X
		if (args[0].equalsIgnoreCase("human")) {
			
			playerX = new HumanPlayer();
		}
		else if (args[0].equalsIgnoreCase("naive")) {

			 playerX = new NaiveComputerPlayer();
		 }
		else if (args[0].equalsIgnoreCase("random")) {

			playerX = new RandomComputerPlayer();
		}
		
		else if (args[0].equalsIgnoreCase("cutthroat")) {
		
			playerX = new CutThroatComputerPlayer();
		}
		else {
		     System.out.println("You must enter one of the following: human, naive, random, or cutthroat");
			System.exit(0);
		}
		//set player O
		if (args[1].equalsIgnoreCase("human")) {
	
			playerO = new HumanPlayer();
		}
		else if (args[1].equalsIgnoreCase("naive")) {

		     playerO = new NaiveComputerPlayer();
		}
		else if (args[1].equalsIgnoreCase("random")) {

			playerO = new RandomComputerPlayer();
		}  
		else if (args[1].equalsIgnoreCase("cutthroat")) {

			playerO = new CutThroatComputerPlayer();
		} 
		else {
			System.out.println("You must enter one of the following: human, naive, random, or cutthroat. Program exiting.");
			System.exit(0);
		}

		System.out.println("\nTic-tac-toe Game");
		
		TicTacToeBoard board = new TicTacToeBoard();
		
		int compMove;
		//Main game loop which runs helper methods until game ends.
		while(!(board.xWins() || board.oWins() || board.isCatGame())) {

			board.displayBoard();
			//Allows either player X or player O to play
			if(TicTacToeBoard.isPlayerX()) {
			
				playerX.promptInput();
				//Check if the player is human or computer.
				if (args[0].equalsIgnoreCase("human")){

				board.turn(playerX.makeMove());
				
				} 
				else {
					compMove = playerX.makeMove();

					System.out.println(compMove);
					board.turn(compMove);
				}
			}
			else {

				playerO.promptInput();
				//Check if the player is human or computer.
				if (args[1].equalsIgnoreCase("human")){
				board.turn(playerO.makeMove());
				}
				else {
					compMove = playerO.makeMove();
					System.out.println(compMove);
					board.turn(compMove);
				}
																	
			}
			board.changePlayer();
		}
		//Display game results
		if(board.xWins()) {

			board.displayBoard();
			System.out.println("Game Over! Player X wins!\n");
		}
		else if(board.oWins()) {

			board.displayBoard();
		     System.out.println("Game Over! Player O wins!\n");
		}
		else {
			board.displayBoard();
			System.out.println("Game Over! Cat game!\n");
		}
	}
}
