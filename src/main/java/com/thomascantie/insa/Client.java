package com.thomascantie.insa;

public class Client {
	
	public static void main(String[] args) {
		
		System.out.println("-- GameOfLife --");
		
		GameOfLife firstGame = new GameOfLife(3, 3);
		firstGame.setAlive(1, 0);
		firstGame.setAlive(1, 1);
		firstGame.setAlive(1, 2);
		
		System.out.println("\nInitial");
		System.out.println(firstGame);
		
		GameOfLife next = firstGame.nextStep();
		
		System.out.println("\nNext step");
		System.out.println(next);
		
		System.out.println("\n\n-- GameOfLifeParser --");
		
		String gameAsText = "6 4\n......\n..##..\n..##..\n......";
		GameOfLife secondGame = GameOfLifeParser.parse(gameAsText);
		System.out.println(secondGame);
		
		System.out.println("\n\n-- InfiniteGameOfLife --");
		
		InfiniteGameOfLife infinite = new InfiniteGameOfLife(3, 3);
		infinite.setAlive(1, 0);
		infinite.setAlive(2, 1);
		infinite.setAlive(0, 2);
		infinite.setAlive(1, 2);
		infinite.setAlive(2, 2);
		
		System.out.println(infinite);
		
		for (int i = 0; i < 10; i++) {
			infinite = infinite.nextStep();
			System.out.printf("\n\n** Step n°%d (%d x %d)", i+1, infinite.width, infinite.height);
			System.out.println(infinite);
		}
		
		
	}
	
}
