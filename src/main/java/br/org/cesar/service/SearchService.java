package br.org.cesar.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.org.cesar.bean.GeoCodes;
import br.org.cesar.bean.TweetsByState;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SearchService {

	public static Properties getProp(String propertiesfile) throws IOException {
		String resourceName = propertiesfile; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			props.load(resourceStream);
		}
		return props;
	}

	public String getNumberTweetsPerBrazilianState(String hashtag) throws IOException {
		List<TweetsByState> tweetsList = new ArrayList<TweetsByState>();
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

			Properties geoCodeProp = getProp("geocode.properties");

			// Double latitude =
			// Double.parseDouble(geoCodeProp.getProperty("amazonas.latitude"));
			// Double longitude =
			// Double.parseDouble(geoCodeProp.getProperty("amazonas.longitude"));
			// Double raio =
			// Double.parseDouble(geoCodeProp.getProperty("amazonas.raio"));

			// Get file from resources folder
			ClassLoader classLoader = getClass().getClassLoader();

			Gson gson = new Gson();
			GeoCodes[] arr = gson.fromJson(new FileReader(classLoader.getResource("geocode.json").getFile()),
					GeoCodes[].class);

			for (GeoCodes item : arr) {
				// GeoLocation geo = new GeoLocation(latitude, longitude);
				GeoLocation geo = new GeoLocation(item.getLatitude(), item.getLongitude());
				Query query = new Query("#" + hashtag).geoCode(geo, item.getRaio(), "km");
				// get the last 50 tweets
				query.count(10000);
				QueryResult result = twitter.search(query);
				List<Status> tweets = result.getTweets();

				System.out.println(tweets.size());

				TweetsByState tweetItem = new TweetsByState(item.getState(), tweets.size());

				tweetsList.add(tweetItem);
			}

			Gson gson2 = new GsonBuilder().create();
			arrayListToJson = gson2.toJson(tweetsList);
		}
		// if there is an error then catch it and print it out
		catch (TwitterException te) {
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}

		return arrayListToJson;
	}

}
