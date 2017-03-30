package br.org.cesar.factory;

import java.io.IOException;
import java.util.Properties;

import br.org.cesar.util.PropertiesUtil;
import twitter4j.conf.ConfigurationBuilder;

public class ConfigurationBuilderFactory {

	public static ConfigurationBuilder getConfigurationBuilder() throws IOException {
		// Loads the data from the properties file
		Properties oauthProp = PropertiesUtil.getProp("oauth.properties");

		// Set access data for twitter api

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(oauthProp.getProperty("twitter.ConsumerKey"))
				.setOAuthConsumerSecret(oauthProp.getProperty("twitter.ConsumerSecret"))
				.setOAuthAccessToken(oauthProp.getProperty("twitter.AccessToken"))
				.setOAuthAccessTokenSecret(oauthProp.getProperty("twitter.AccessTokenSecret"));
		return cb;
	}

}
