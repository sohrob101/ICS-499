package tech.teamfour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;


@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class GameApplication {
    public static void main(String... args) {
	SpringApplication.run(GameApplication.class, args);

	// Debug Maze Creation / Test


	//	int size = 8;
	//	LinePuzzle puzzle = new LinePuzzle(size);
	//	GameDebug game = new GameDebug(puzzle);
	//	try {
	//	    game.RunGame();
	//	} catch (InterruptedException e) {
	//	    e.printStackTrace();
	//	}

    }

    @Bean
    public CorsFilter corsFilter() {

	UrlBasedCorsConfigurationSource urlBasedCorsConifgSource = new UrlBasedCorsConfigurationSource();

	CorsConfiguration corsConfig = new CorsConfiguration();
	corsConfig.setAllowCredentials(true);
	corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	corsConfig.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
		"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
		"Access-Control-Request-Method", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
	corsConfig.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
		"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
	corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

	urlBasedCorsConifgSource.registerCorsConfiguration("/**", corsConfig);

	return new CorsFilter(urlBasedCorsConifgSource);


    }



}

/*@Component
class CapstoneCommandLineRunner implements CommandLineRunner {

    @Autowired
    private PlayerServiceImpl impl;

    @Override
    public void run(String... args) throws Exception {
        impl.addPlayer(
                new Player(
                        0L, "Service2", "fromCMDRunner2", 12344
                )

        );
    }

 *//*
    @Override
    public void run(String... args) throws Exception {
        Player player = new Player();
        player.setPlayerID((playerRepository.count()+1));
        player.setUserName("cmdLineRunner3");
        player.setPassword("11_34_10_17");
        player.setBestScore(1234);

        playerRepository.save(player);
  *//*
}*/

