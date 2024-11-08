package com.firstExample;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // Array of fortune strings
    private String[] fortunes = {
            "Today is your lucky day!",
            "Be careful, something unexpected is coming your way.",
            "You will achieve great success soon.",
            "Beware of making hasty decisions today.",
            "A pleasant surprise is waiting for you."
    };

    // Random object to pick a random fortune
    private Random random = new Random();

    @Override
    public String getFortune() {
        // Pick a random index from the fortunes array
        int index = random.nextInt(fortunes.length);
        return fortunes[index];  // Return the randomly selected fortune
    }
}
