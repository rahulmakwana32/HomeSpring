package com.spring.hcloud.main;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.spring.hcloud.main.service.Fileoperationservice;
import com.spring.hcloud.main.service.Globalservice;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Component
@EnableSwagger2
@EnableScheduling
public class Main implements CommandLineRunner {

	private final Path root = Paths.get("uploads");

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	@Autowired
	Fileoperationservice fileoperationservice;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	public void run(String... args) throws Exception {

		LOGGER.info("Invoking INIT");
		fileoperationservice.init();
	}

	@Autowired
	Globalservice sseEmitters;

	// Scan Folder for file and inform client
	@Scheduled(fixedDelay = 5000000L)
	public void scanandsend() {

		String[] pathnames;
		LOGGER.info("Scanning " + new java.util.Date());
		pathnames = new File(root.toString()).list();

		for (String file : pathnames) {
			String username = file.substring(0, file.indexOf("_"));
			LOGGER.info("found files for " + username);
			// Print the names of files and directories

			SseEmitter sseEmitter = sseEmitters.get(username);
			if (sseEmitter != null) {
				LOGGER.info("found files for " + username);
				fileoperationservice.notifyclientpendingfile(file, sseEmitter, username);
			}
		}

	}

}
