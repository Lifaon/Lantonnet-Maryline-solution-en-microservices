package com.medilabo.note.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "spring.docker.compose", name="enabled", havingValue = "false")
public class MongoConfig {

	@Configuration
	@ConfigurationProperties(prefix = "app.mongodb")
	@Data
	public static class MongoProperties {
		private String host;
		private String port;
		private String database;
		private String username;
		private String password;

		public String getUri() {
			return "mongodb://" + username + ':' + password + '@' + host + ':' + port + '/' + database + "?authSource=admin";
		}
	}

	@Bean
	public MongoClient mongoClient(MongoProperties properties) {
		return MongoClients.create(properties.getUri());
	}
}