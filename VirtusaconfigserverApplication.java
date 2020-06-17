package com.virtusa.virtusaconfigserver;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import com.virtusa.virtusaconfigserver.configurations.VaultConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@SpringBootApplication
@EnableConfigServer
@EnableConfigurationProperties(VaultConfiguration.class)
public class VirtusaconfigserverApplication implements CommandLineRunner{

	private final VaultConfiguration vaultConfiguration;
	public VirtusaconfigserverApplication(VaultConfiguration configuration) {
	    this.vaultConfiguration = configuration;
	  }

	public static void main(String[] args) {
		SpringApplication.run(VirtusaconfigserverApplication.class, args);
	}
	@Override
	  public void run(String... args) {

	    Logger logger = LoggerFactory.getLogger(VirtusaconfigserverApplication.class);

	    logger.info("----------------------------------------");
	    logger.info("Configuration properties");
	    logger.info("   mysql.username is {}", vaultConfiguration.getUsername());
	    logger.info("   mysql.password is {}", vaultConfiguration.getPassword());
	    logger.info("----------------------------------------");
	  }
}
