package life;

public class Survival {

	public static void main(String[] args) {
		LifeBoard board = new LifeBoard(20, 20);
		LifeView window = new LifeView(board);
		Life life = new Life(board);
		Alive alive = new Alive(board);
		window.drawBoard();
		
		
		while(true) {
			
			window.update();
			
			int command = window.getCommand();
			
			if (command == 3) {
				System.exit(0);
			}
			else if (command == 2) {
				
				while(alive.isAlive()) {
					window.update();
						life.newGeneration();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			else if (command == 1) {
				int row = window.getRow();
				int col = window.getCol();
				life.flip(row, col);
			}
			
		}

	}

}
