package br.org.cesar.testes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import br.org.cesar.service.TrendingHashtagsService;

public class TrendingHashtagsServiceTest {
	
	TrendingHashtagsService tHashtagService;
	
	@Before
	public void setUp() throws Exception {
		tHashtagService = new TrendingHashtagsService();
	}

	@Test
	public void testTrendLocationIdNotNullAndEqualsBrazilTrendLocationId() {
		Integer trendLocationId = tHashtagService.getTrendLocationId("brazil");
		assertNotNull(trendLocationId);
		assertEquals(Integer.valueOf(23424768), trendLocationId);
	}
	
	@Test
	public void testTrendLocationIdNull() {
		Integer trendLocationId = tHashtagService.getTrendLocationId("qualquercoisaquenaosejapais");
		assertNull(trendLocationId);
	}
	
	@Test
	public void testReturnJsonStringTrendingHashtagsBrazil() throws IOException {
		String trendTopicsBrazil = tHashtagService.getTrendingHashtagsBrazil();
		assertNotNull(trendTopicsBrazil);
	}
}
