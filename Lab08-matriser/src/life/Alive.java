package life;

public class Alive {
	private LifeBoard board;
	private boolean[][] currentGen;
	private boolean[][] oldGen;
	private boolean[][] olderGen;
	private int rows;
	private int cols; 

	public Alive(LifeBoard board) {
		this.board = board;
		
		rows = board.getRows();
		cols = board.getCols();
		
		currentGen = new boolean[rows][cols];
		oldGen = new boolean[rows][cols];
		olderGen = new boolean[rows][cols];
	}
	
	public boolean isAlive() {
		
		System.out.println("checking if alive " + board.getGeneration());
		
		boolean notOld = false;
		boolean notOlder = false;
		boolean alive = true;
		
		//compare currentGen to oldGen
		for(int r = 0; r < rows; r++) {
			//System.out.println("row: " + r);
			for(int c = 0; c < cols; c++) {
				if (board.get(r, c) != oldGen[r][c]) {
					notOld = true;
					System.out.println("not old");
					break;
				}
				
			}
			if (notOld) {
				break;
			}
		}
		System.out.println(notOld);
		
		
		
		//compare currentGen to olderGen
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				if (!board.get(r, c) == olderGen[r][c]) {
					notOlder = true;
					System.out.println("not older");
					break;
				}
			}
			if (notOlder) {
				break;
			}
		}
		System.out.println(notOlder);
		
		
		//save oldGen to olderGen
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				olderGen[r][c] = oldGen[r][c];
			}
		}
		
		//save currentGen to oldGen
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				oldGen[r][c] = board.get(r, c);
			}
		}
		
		if (notOlder && notOld) {
			return true;
		}
		else {
			System.out.println("Dead at generation " + board.getGeneration());
			return false;
		}
		
	}
	
}
