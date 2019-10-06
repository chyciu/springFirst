package pl.sdacademy.repository;

public class GreetingsDatabaseRepository implements GreetingRepository {

    private final String jdbcUrl;

    public GreetingsDatabaseRepository(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getGreeting() {
        return "Greeting from db";
    }
}
