package life;

public class Life {
	
	LifeBoard board;
	
	public Life(LifeBoard board) {
		this.board = board;
	}
	
	public void newGeneration() {
		
		//System.out.println("Neighbors: " + getNeighbors(1, 1));
		
		boolean[][] temp = new boolean[board.getRows()][board.getCols()];
		
		for (int r = 0; r < temp.length; r++) {
			for (int c = 0; c < temp[0].length; c++) {
				//System.out.println("pos: " + r + "  " + c);
				if((board.get(r, c) && getNeighbors(r, c) > 4) || (board.get(r, c) && getNeighbors(r, c) < 3) || (!board.get(r, c) && getNeighbors(r, c) == 3)) {
					temp[r][c] = true;
				}
			}
		}
		
		for (int r = 0; r < board.getRows(); r++) {
			for (int c = 0; c < board.getCols(); c++) {
				if(temp[r][c]) {
					flip(r, c);
				}
			}
		}
		
		board.increaseGeneration();
		
	}
	
	public void flip(int row, int col) {
		boolean val = board.get(row, col);
		board.put(row, col, !val);
	}
	
	public int getNeighbors(int row, int col) {
		int neighbors = 0;
		
		int rowCheck = row - 1;
		int colCheck = col - 1;
		
		while (rowCheck <= row + 1) {
			while(colCheck <= col +1) {
				if (board.get(rowCheck, colCheck)) {
					neighbors++;	
				}
				colCheck++;
			}
			rowCheck++;
			colCheck = col - 1;
		}
		return neighbors;
	}

}
