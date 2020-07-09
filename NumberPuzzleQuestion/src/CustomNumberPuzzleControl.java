import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		int clickedCellId = -1;
		for(int i=0;i<16;i++) {
			if(buttons[i]==buttonClicked)
				clickedCellId = i;
		}
		int diff = clickedCellId - emptyCellId;
		if((diff==1) || (diff==-1) || (diff==4) || (diff==-4)) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = clickedCellId;
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int i=0;
		int j;
		while(i<15) {
			int a = getRandomNumber();
			if(a<=15 && a>=1) {
				for(j=0;j<15;j++) {
					if(arr[j]==a)
						break;
				}
				if(j==15) {
					arr[i]=a;
					i++;
				}
			}
		}		
		
		return arr;
	}
	
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++) {
			if(arr[i]!=i+1)
				winner = false;
		}
		return winner;
	}
}