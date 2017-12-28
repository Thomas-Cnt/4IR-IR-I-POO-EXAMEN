package com.thomascantie.insa;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class InfiniteGameOfLifeTest {
	
	private static final String GAME_INIT = ".#.\n..#\n###";
	private static final String GAME_STEP_ONE = "...\n#.#\n.##\n.#.";
	private static final String GAME_STEP_TWO = "....\n..#.\n#.#.\n.##.";
	
	private OutputStream out;
	
	@Before
	public void setUp() {
		this.out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.out));
	}
	
	@Test
	public void mainTest() {
		InfiniteGameOfLife infiniteGame = new InfiniteGameOfLife(3, 3);
		infiniteGame.setAlive(1, 0);
		infiniteGame.setAlive(2, 1);
		infiniteGame.setAlive(0, 2);
		infiniteGame.setAlive(1, 2);
		infiniteGame.setAlive(2, 2);
		
		System.out.println(infiniteGame);
		
		assertThat(standardOutput(), containsString(GAME_INIT));
		
		InfiniteGameOfLife afterStepOne = infiniteGame.nextStep();
		
		System.out.println(afterStepOne);
		
		assertThat(standardOutput(), containsString(GAME_STEP_ONE));
		
		InfiniteGameOfLife afterStepTwo = afterStepOne.nextStep();
		
		System.out.println(afterStepTwo);
		
		assertThat(standardOutput(), containsString(GAME_STEP_TWO));
	}
	
	private String standardOutput() {
		return this.out.toString();
	}
	
}
