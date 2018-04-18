package life;

public class LifeBoard {
	
	private boolean[][] currentGen;
	private int genNr;

	/** Skapar en spelplan med rows rader och cols kolonner.
	    Spelplanen är från början tom, dvs alla rutorna är
	    tomma och generationsräknaren är 1. */	
	public LifeBoard(int rows, int cols) {
		
		currentGen = new boolean[rows][cols];
		genNr = 1;
		
	}

	/** Undersöker om det finns en individ i rutan med index row,col, 
	    Om index row,col hamnar utanför spelplanen returneras false. */
	public boolean get(int row, int col) {
		if (row < 0 || row >= currentGen.length || col < 0 || col >= currentGen[0].length) {
			return false;
		}
		else {
			return currentGen[row][col];
		}
	}

	/** Lagrar värdet val i rutan med index row,col. */
	public void put(int row, int col, boolean val) {
		if (!(row < 0 || row >= currentGen.length || col < 0 || col >= currentGen[0].length)) {
			currentGen[row][col] = val;
		}
	}

	/** Tar reda på antalet rader. */
	public int getRows() {
		return currentGen.length;
	}

 	/** Tar reda på antalet kolonner. */
	public int getCols() {
		return currentGen[0].length;
	}

	/** Tar reda på aktuellt generationsnummer. */
	public int getGeneration() {
		return genNr;
	}

	/** Ökar generationsnumret med ett. */
	public void increaseGeneration() {
		genNr++;
	}
}
