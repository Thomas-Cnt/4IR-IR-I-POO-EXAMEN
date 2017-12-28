package com.thomascantie.insa;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeParserMust {
	
	private static final String GAME_INIT = "......\n..##..\n..##..\n......";
	private OutputStream out;
	
	@Before
	public void setUp() {
		this.out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.out));
	}

	@Test
	public void parseACorrectSequence() {
		String gameAsText = "6 4\n" + GAME_INIT;
		GameOfLife game = GameOfLifeParser.parse(gameAsText);
		System.out.println(game);
		
		assertThat(standardOutput(), containsString(GAME_INIT));
	}
	
	private String standardOutput() {
		return this.out.toString();
	}
	
}
