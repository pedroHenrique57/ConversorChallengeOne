package edu.hiikke.ConversorChallengeOne;

import edu.hiikke.ConversorChallengeOne.application.MainApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorChallengeOneApplication implements CommandLineRunner {

	MainApplication mainApplication;

	@Autowired
	public ConversorChallengeOneApplication(MainApplication mainApplication) {
		this.mainApplication = mainApplication;
	}

	public static void main(String[] args){
		SpringApplication.run(ConversorChallengeOneApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		mainApplication.run();
	}
}
