import java.util.Random;

public enum Country {
  PL("Warsaw", "Wrocław", "Poznań"),
  DE("Hannover", "Berlin", "Hamburg");

  private String[] cities;

  Country(String... strings) {
    cities = strings;
  }

  public String getCity() {
    return cities[new Random().nextInt(cities.length)];
  }
}
