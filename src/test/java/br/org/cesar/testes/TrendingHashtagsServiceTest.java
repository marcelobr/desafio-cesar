package br.org.cesar.testes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.org.cesar.service.TrendingHashtagsService;

public class TrendingHashtagsServiceTest {
	
	TrendingHashtagsService tHashtagService;
	
	@Before
	public void setUp() throws Exception {
		tHashtagService = new TrendingHashtagsService();
	}

	@Test
	public void testTrendLocationIdNotNull() {
		Integer trendLocationId = tHashtagService.getTrendLocationId("brazil");
		assertNotNull(trendLocationId);
		//assertEquals(23424768, trendLocationId);
	}
	
	@Test
	public void testTrendLocationIdNull1() {
		Integer trendLocationId = tHashtagService.getTrendLocationId("qualquercoisaquenaosejapais");
		assertNull(trendLocationId);
	}
	
	@Test
	public void testReturnStringTrendingTopics() throws IOException {
		String trendTopicsBrazil = tHashtagService.getTrendingTopicsBrazil();
		assertNotNull(trendTopicsBrazil);
	}
}
