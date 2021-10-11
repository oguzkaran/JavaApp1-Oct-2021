package org.csystem.application;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class);

		/*
		new SpringApplicationBuilder()
				//.bannerMode(Banner.Mode.LOG)
				.sources(App.class)
				.run(args);

		 */


		/*
		var app = new SpringApplication(App.class);

		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out)
			{
				out.println("\n\nC and System Programmers Association\n\n");
			}
		});

		app.run(args);
		*/
	}
}
