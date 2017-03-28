package br.org.cesar.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.org.cesar.util.PropertiesUtil;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TrendingHashtagsService {

	private static Twitter twitter;

	public TrendingHashtagsService() throws IOException {
		super();
		// Loads the data from the properties file
		Properties oauthProp = PropertiesUtil.getProp("oauth.properties");
		
		// Set access data for twitter api
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(oauthProp.getProperty("twitter.ConsumerKey"))
				.setOAuthConsumerSecret(oauthProp.getProperty("twitter.ConsumerSecret"))
				.setOAuthAccessToken(oauthProp.getProperty("twitter.AccessToken"))
				.setOAuthAccessTokenSecret(oauthProp.getProperty("twitter.AccessTokenSecret"));
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}
	
	// Get the id of certain location on twitter API
	public Integer getTrendLocationId(String locationName) {

		int idTrendLocation = 0;

		try {
			ResponseList<Location> locations;
			locations = twitter.getAvailableTrends();

			for (Location location : locations) {
				if (location.getName().toLowerCase().equals(locationName.toLowerCase())) {
					idTrendLocation = location.getWoeid();
					break;
				}
			}

			if (idTrendLocation > 0) {
				return idTrendLocation;
			}

			return null;

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends: " + te.getMessage());
			return null;
		}

	}

	// Search the trending hashtags in Brazil
	public String getTrendingHashtagsBrazil() throws IOException {
		List<String> trendsList = new ArrayList<>();
		String arrayListToJson = null;
		try {
			// Get the id of Brazil
			Integer idTrendLocation = getTrendLocationId("brazil");

			if (idTrendLocation == null) {
				System.out.println("Trend Location Not Found");
				arrayListToJson = "Error fetching Trending Hashtags";
			} else {
				
				// Get the trending topics in Brazil
				Trends trends = twitter.getPlaceTrends(idTrendLocation);
				
				// Filters only hashtags
				for (int i = 0; i < trends.getTrends().length; i++) {
					if (trends.getTrends()[i].getName().startsWith("#")) {
						trendsList.add(trends.getTrends()[i].getName());
					}
				}
				
				// Creates a json with the trending hashtags list
				Gson gson = new GsonBuilder().create();
				arrayListToJson = gson.toJson(trendsList);
			}
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends: " + te.getMessage());
		}

		return arrayListToJson;
	}
}
