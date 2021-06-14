package com.example.LordsOfThePlanets;

import com.example.LordsOfThePlanets.Service.impl.LordServiceImpl;
import com.example.LordsOfThePlanets.model.Lord;
import com.example.LordsOfThePlanets.repository.impl.LordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EntityScan(basePackages = "com.example.LordsOfThePlanets.model")
@SpringBootApplication(scanBasePackages = "com.example.LordsOfThePlanets.*")
public class LordsOfThePlanetsApplication {

	@Autowired
	private LordDAO lordDAO;

	public static void main(String[] args) {
		SpringApplication.run(LordsOfThePlanetsApplication.class, args);
	}
		@Bean
		public CommandLineRunner demo() {
			return (args) -> {

				Lord lord = new Lord();
				lord.setName("Ram");
				lord.setAge(100);
				Lord lord1 = new Lord();
				lord1.setName("Tor");
				lord1.setAge(88);
				Lord lord2 = new Lord();
				lord2.setName("Eva");
				lord2.setAge(41);
				Lord lord3 = new Lord();
				lord3.setName("Omes");
				lord3.setAge(1221);

				lordDAO.createLord(lord);
				lordDAO.createLord(lord1);
				lordDAO.createLord(lord2);
				lordDAO.createLord(lord3);

				List<Lord> lords = lordDAO.findAll();

				System.out.println("-------------------------");
				System.out.println("Printing Lords");
				System.out.println("-------------------------");
				for (Lord lo : lords) {
					System.out.println(lo);
				}

			};
	}

}
