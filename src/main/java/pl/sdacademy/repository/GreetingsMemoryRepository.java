package pl.sdacademy.repository;

public class GreetingsMemoryRepository implements GreetingRepository {

    private String greeting = "Hello World!";

    public String getGreeting() {
        return greeting;
    }
}
