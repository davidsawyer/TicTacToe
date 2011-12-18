/*
This class contains tools used by the cut throat player that allows him to always win. It blocks players from winning, goes for the win,
blocks forks and goes for the center square if it is left open. A counter is used to keep track of which turn the game is on and it
uses the appropriate methods.
*/
import java.util.Random;
public class CutThroatComputerPlayer extends ComputerPlayer {

	int randomInt;
	int turn = 0;
	int ourSymbol;
	int theirSymbol;
	Random generator = new Random();
	//Postcondition: Returns a move based on the current condition of the board.
	//Contains the turn counter. 
	public int makeMove(){
	
		turn++;
		//This is turn one. If the  computer goes first it plays the center, otherwise it plays the top left corner.
	     if(turn == 1) {
				
			if(TicTacToeBoard.isValidSpace(5)){
               	return 5;
               }
              	else{
              		return 1;
              	}
		}
		//This is turn two.
		if(turn==2) {
		
			if(block()!=-1) return block();
		
			if(TicTacToeBoard.isPlayerX()){
			     ourSymbol = 1;
    			 }
     		else{
          		ourSymbol = 2;
    			 }
               	
				if(win()!=-1) return win();
                    else if(block()!=-1) return block();
                    else if(blockFork()!=-1) return blockFork();
                    //return a corner
				else{
					for(int i=0; i<5; i++){	
						if(i==1 && TicTacToeBoard.isValidSpace(1)) return 1;
						else if(i==2 && TicTacToeBoard.isValidSpace(3)) return 3;
						else if(i==3 && TicTacToeBoard.isValidSpace(7)) return 7;
						else if(i==4 && TicTacToeBoard.isValidSpace(9)) return 9;
					}
				}
			return -3;
		}
			//This is turn 3. It checks for winning moves, blocking moves, and fork blocking moves. 
			if(turn==3) {
				if(win()!=-1) return win();
				else if(block()!=-1) return block();
				else if(blockFork()!=-1) return blockFork();
				else return randomMove();
			}
			//This is turn 4. It checks for winning moves and blocking moves, other wise it returns a random move. 
			if(turn==4) {
				if(win()!=-1) return win();
				else if(block()!=-1) return block();
				else return randomMove();
			}
			//This is the same as turn 5. 
			if(turn==5) {
				if(win()!=-1) return win();
				else if(block()!=-1) return block();
				else return randomMove();
			}
		return -2;
	}
	//Postcondition: Returns the space necessary to win if it exists. 
	private int win(){
	
	if(TicTacToeBoard.isPlayerX()){

		ourSymbol = 1;
	}
	else{
		ourSymbol = 2;
	}
			//This Great Wall of If-Else Statements checks to see if the current player can win the next turn and tells it to make that move.
			if(TicTacToeBoard.getSpace(1)==ourSymbol && TicTacToeBoard.getSpace(4)==ourSymbol && TicTacToeBoard.getSpace(7)==0)      return 7;
			else if(TicTacToeBoard.getSpace(2)==ourSymbol && TicTacToeBoard.getSpace(5)==ourSymbol && TicTacToeBoard.getSpace(8)==0) return 8;
			else if(TicTacToeBoard.getSpace(3)==ourSymbol && TicTacToeBoard.getSpace(6)==ourSymbol && TicTacToeBoard.getSpace(9)==0) return 9;
			else if(TicTacToeBoard.getSpace(7)==ourSymbol && TicTacToeBoard.getSpace(4)==ourSymbol && TicTacToeBoard.getSpace(1)==0) return 1;
			else if(TicTacToeBoard.getSpace(8)==ourSymbol && TicTacToeBoard.getSpace(5)==ourSymbol && TicTacToeBoard.getSpace(2)==0) return 2;
			else if(TicTacToeBoard.getSpace(9)==ourSymbol && TicTacToeBoard.getSpace(6)==ourSymbol && TicTacToeBoard.getSpace(3)==0) return 3;
			else if(TicTacToeBoard.getSpace(1)==ourSymbol && TicTacToeBoard.getSpace(2)==ourSymbol && TicTacToeBoard.getSpace(3)==0) return 3;
			else if(TicTacToeBoard.getSpace(4)==ourSymbol && TicTacToeBoard.getSpace(5)==ourSymbol && TicTacToeBoard.getSpace(6)==0) return 6;
			else if(TicTacToeBoard.getSpace(7)==ourSymbol && TicTacToeBoard.getSpace(8)==ourSymbol && TicTacToeBoard.getSpace(9)==0) return 9;
			else if(TicTacToeBoard.getSpace(3)==ourSymbol && TicTacToeBoard.getSpace(2)==ourSymbol && TicTacToeBoard.getSpace(1)==0) return 1;
			else if(TicTacToeBoard.getSpace(6)==ourSymbol && TicTacToeBoard.getSpace(5)==ourSymbol && TicTacToeBoard.getSpace(4)==0) return 4;
			else if(TicTacToeBoard.getSpace(9)==ourSymbol && TicTacToeBoard.getSpace(8)==ourSymbol && TicTacToeBoard.getSpace(7)==0) return 7;
			else if(TicTacToeBoard.getSpace(1)==ourSymbol && TicTacToeBoard.getSpace(5)==ourSymbol && TicTacToeBoard.getSpace(9)==0) return 9;
			else if(TicTacToeBoard.getSpace(3)==ourSymbol && TicTacToeBoard.getSpace(5)==ourSymbol && TicTacToeBoard.getSpace(7)==0) return 7;
			else if(TicTacToeBoard.getSpace(7)==ourSymbol && TicTacToeBoard.getSpace(5)==ourSymbol && TicTacToeBoard.getSpace(3)==0) return 3;
			else if(TicTacToeBoard.getSpace(9)==ourSymbol && TicTacToeBoard.getSpace(5)==ourSymbol && TicTacToeBoard.getSpace(1)==0) return 1;
			else if(TicTacToeBoard.getSpace(1)==ourSymbol && TicTacToeBoard.getSpace(3)==ourSymbol && TicTacToeBoard.getSpace(2)==0) return 2;
			else if(TicTacToeBoard.getSpace(4)==ourSymbol && TicTacToeBoard.getSpace(6)==ourSymbol && TicTacToeBoard.getSpace(5)==0) return 5;
			else if(TicTacToeBoard.getSpace(7)==ourSymbol && TicTacToeBoard.getSpace(9)==ourSymbol && TicTacToeBoard.getSpace(8)==0) return 8;
			else if(TicTacToeBoard.getSpace(1)==ourSymbol && TicTacToeBoard.getSpace(7)==ourSymbol && TicTacToeBoard.getSpace(4)==0) return 4;
			else if(TicTacToeBoard.getSpace(2)==ourSymbol && TicTacToeBoard.getSpace(8)==ourSymbol && TicTacToeBoard.getSpace(5)==0) return 5;
			else if(TicTacToeBoard.getSpace(3)==ourSymbol && TicTacToeBoard.getSpace(9)==ourSymbol && TicTacToeBoard.getSpace(6)==0) return 6;
			else if(TicTacToeBoard.getSpace(1)==ourSymbol && TicTacToeBoard.getSpace(9)==ourSymbol && TicTacToeBoard.getSpace(5)==0) return 5;
			else if(TicTacToeBoard.getSpace(7)==ourSymbol && TicTacToeBoard.getSpace(3)==ourSymbol && TicTacToeBoard.getSpace(5)==0) return 5;
		
			return -1;
	}	
	//Postcondition: Returns the space necessary to block the other player from winning if it exists.
	private int block(){

		if(TicTacToeBoard.isPlayerX()) {
			
			theirSymbol = 2;
		}
		else{
			theirSymbol = 1;
		}
			//This Great Wall checks to see if the current player needs to play a blocking move to prevent the other player from winning.
			if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(4)==theirSymbol && TicTacToeBoard.getSpace(7)==0)      return 7;
               else if(TicTacToeBoard.getSpace(2)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(8)==0) return 8;
               else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(6)==theirSymbol && TicTacToeBoard.getSpace(9)==0) return 9;
               else if(TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(4)==theirSymbol && TicTacToeBoard.getSpace(1)==0) return 1;
               else if(TicTacToeBoard.getSpace(8)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(2)==0) return 2;
               else if(TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(6)==theirSymbol && TicTacToeBoard.getSpace(3)==0) return 3;
               else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(2)==theirSymbol && TicTacToeBoard.getSpace(3)==0) return 3;
               else if(TicTacToeBoard.getSpace(4)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(6)==0) return 6;
			else if(TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(8)==theirSymbol && TicTacToeBoard.getSpace(9)==0) return 9;
               else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(2)==theirSymbol && TicTacToeBoard.getSpace(1)==0) return 1;
               else if(TicTacToeBoard.getSpace(6)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(4)==0) return 4;
               else if(TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(8)==theirSymbol && TicTacToeBoard.getSpace(7)==0) return 7;
               else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(9)==0) return 9;
               else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(7)==0) return 7;
               else if(TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(3)==0) return 3;
               else if(TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(1)==0) return 1;
               else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(2)==0) return 2;
               else if(TicTacToeBoard.getSpace(4)==theirSymbol && TicTacToeBoard.getSpace(6)==theirSymbol && TicTacToeBoard.getSpace(5)==0) return 5;
               else if(TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(8)==0) return 8;
               else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(4)==0) return 4;
               else if(TicTacToeBoard.getSpace(2)==theirSymbol && TicTacToeBoard.getSpace(8)==theirSymbol && TicTacToeBoard.getSpace(5)==0) return 5;
               else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(6)==0) return 6;
               else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(5)==0) return 5;
               else if(TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(5)==0) return 5;
			
			return -1;
	}
	//Postcondition:This returns a random move if the other methods don't run.
	private int randomMove(){

		randomInt = generator.nextInt(9) + 1;
	
     	while(!(TicTacToeBoard.isValidSpace(randomInt) && randomInt <= 9 && randomInt >= 1)){

          	randomInt = generator.nextInt(9) + 1;
     	}
     	return randomInt;
     }
	//Postcondition: This contains a Great Wall that checks for forks and then returns the appropriate space needed to block the fork.
	private int blockFork(){
			
		if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(2)==0)      	return 2;
		else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(4)==0)     	return 4;
		else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(2)==0)      return 2;
		else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(2)==0)      return 4;
		
		else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(8)==theirSymbol && TicTacToeBoard.getSpace(4)==0 && TicTacToeBoard.getSpace(7)==0)      return 7;
		else if(TicTacToeBoard.getSpace(2)==theirSymbol && TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(4)==0 && TicTacToeBoard.getSpace(1)==0)      return 1;
		else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(6)==theirSymbol && TicTacToeBoard.getSpace(2)==0 && TicTacToeBoard.getSpace(3)==0)      return 3;
		else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(4)==theirSymbol && TicTacToeBoard.getSpace(2)==0 && TicTacToeBoard.getSpace(1)==0)      return 1;
		else if(TicTacToeBoard.getSpace(2)==theirSymbol && TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(6)==0 && TicTacToeBoard.getSpace(3)==0)      return 3;
		else if(TicTacToeBoard.getSpace(4)==theirSymbol && TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(8)==0 && TicTacToeBoard.getSpace(7)==0)      return 7;
		else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(8)==theirSymbol && TicTacToeBoard.getSpace(6)==0 && TicTacToeBoard.getSpace(9)==0)      return 9;
		else if(TicTacToeBoard.getSpace(6)==theirSymbol && TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(8)==0 && TicTacToeBoard.getSpace(9)==0)      return 9;
	
		else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(9)==ourSymbol && TicTacToeBoard.getSpace(6)==0)      return 6;
		else if(TicTacToeBoard.getSpace(1)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(9)==ourSymbol && TicTacToeBoard.getSpace(8)==0)      return 8;
		else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(7)==ourSymbol && TicTacToeBoard.getSpace(4)==0)      return 4;
		else if(TicTacToeBoard.getSpace(3)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(7)==ourSymbol && TicTacToeBoard.getSpace(8)==0)      return 8;
		else if(TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(3)==ourSymbol && TicTacToeBoard.getSpace(2)==0)      return 2;
		else if(TicTacToeBoard.getSpace(7)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(3)==ourSymbol && TicTacToeBoard.getSpace(6)==0)      return 6;
		else if(TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(1)==ourSymbol && TicTacToeBoard.getSpace(2)==0)      return 2;
		else if(TicTacToeBoard.getSpace(9)==theirSymbol && TicTacToeBoard.getSpace(5)==theirSymbol && TicTacToeBoard.getSpace(1)==ourSymbol && TicTacToeBoard.getSpace(4)==0)      return 4;
	
		return -1;
	}
}
