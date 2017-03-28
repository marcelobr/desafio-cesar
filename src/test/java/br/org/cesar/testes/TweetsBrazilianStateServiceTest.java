package br.org.cesar.testes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.org.cesar.service.TweetsBrazilianStateService;

public class TweetsBrazilianStateServiceTest {
	TweetsBrazilianStateService tBrazilianState;
	
	@Before
	public void setUp() throws Exception {
		tBrazilianState = new TweetsBrazilianStateService();
	}

	@Test
	public void testReturnJsonStringNumberTweetsBrazilianState() throws IOException {
		String tweetsBrazilian = tBrazilianState.getNumberTweetsPerBrazilianState("coparedeam");
		assertNotNull(tweetsBrazilian);
	}

}
