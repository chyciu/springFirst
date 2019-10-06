package pl.sdacademy;

import pl.sdacademy.service.GreetingsService;

public class Application {

    public static void main(String[] args) {
        String source = "db";

        GreetingsService service = DependencyContainer.getGreetingsService(source);
        String greeting = service.loadGreetings();

        System.out.println(greeting);

    }
}
