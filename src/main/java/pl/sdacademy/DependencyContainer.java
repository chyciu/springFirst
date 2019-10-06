package pl.sdacademy;

import pl.sdacademy.repository.GreetingRepository;
import pl.sdacademy.repository.GreetingsDatabaseRepository;
import pl.sdacademy.repository.GreetingsMemoryRepository;
import pl.sdacademy.service.GreetingsService;

import java.util.HashMap;
import java.util.Map;

public class DependencyContainer {

    private static GreetingRepository dbRepository;
    private static GreetingRepository memRepository;
    private static Map<String, GreetingsService> greetingsServices = new HashMap<>();;

    public static GreetingsService getGreetingsService(String name) {
        GreetingsService greetingsService = greetingsServices.get(name);
        if (greetingsService == null) {
            GreetingRepository repository;

            switch (name) {
                case "db":
                    repository = DependencyContainer.getDbRepository();
                    break;
                case "memory":
                    repository = DependencyContainer.getMemRepository();
                    break;
                default:
                    throw new RuntimeException();
            }
            greetingsService = new GreetingsService(repository);
            greetingsServices.put(name, greetingsService);
        }

        return greetingsService;
    }

    public static GreetingRepository getDbRepository() {
        if (dbRepository == null) {
            dbRepository = new GreetingsDatabaseRepository("jdbc:mysql");
        }
        return dbRepository;
    }

    public static GreetingRepository getMemRepository() {
        if (memRepository == null) {
            memRepository = new GreetingsMemoryRepository();
        }
        return memRepository;
    }

    public static GreetingRepository getPrototypeDbRepository() {
        return new GreetingsDatabaseRepository("jdbc:mysql");
    }

    public static GreetingRepository getPrototypeMemRepository() {
        return new GreetingsMemoryRepository();
    }
}
