package br.org.cesar.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TrendingService {
	
	public static Properties getProp(String propertiesfile) throws IOException {
		String resourceName = propertiesfile; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			props.load(resourceStream);
		}
		return props;
	}

	private static Integer getTrendLocationId(String locationName) {

		int idTrendLocation = 0;

		try {

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("E9wfEgJ3Y71ibF5HQeXVBSII3")
					.setOAuthConsumerSecret("VEfEPw2R7qi6T6eRFJPYgwm3P6Wbx3Yx1pYs0G9w6ER4V10eJQ")
					.setOAuthAccessToken("845757157501026305-qBUFpBUYCNhDttYxYPudqBMNeCMNzLU")
					.setOAuthAccessTokenSecret("gz9wzohIZfQL0cTGidboSYFDwgKFZbgwIHlXlRhKcvXIs");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();

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

	public String getTrendingTopicsBrazil() throws IOException {
		List<String> trendsList = new ArrayList<>();
		String arrayListToJson = null;
		try {

			Properties oauthProp = getProp("oauth.properties");

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(oauthProp.getProperty("twitter.ConsumerKey"))
					.setOAuthConsumerSecret(oauthProp.getProperty("twitter.ConsumerSecret"))
					.setOAuthAccessToken(oauthProp.getProperty("twitter.AccessToken"))
					.setOAuthAccessTokenSecret(oauthProp.getProperty("twitter.AccessTokenSecret"));
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();

			//ResponseList<Location> locations = twitter.getAvailableTrends();

			Integer idTrendLocation = getTrendLocationId("brazil");

			if (idTrendLocation == null) {
				System.out.println("Trend Location Not Found");
			}

			Trends trends = twitter.getPlaceTrends(idTrendLocation);
			
			for (int i = 0; i < trends.getTrends().length; i++) {
				if (trends.getTrends()[i].getName().startsWith("#")) {
					trendsList.add(trends.getTrends()[i].getName());
				}
			}

			Gson gson = new GsonBuilder().create();
			arrayListToJson = gson.toJson(trendsList);

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends: " + te.getMessage());
		}

		return arrayListToJson;
	}
}
