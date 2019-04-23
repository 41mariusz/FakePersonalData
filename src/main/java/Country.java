import java.util.Random;

public enum Country {
  PL("Warsaw", "Cracow"),
  DE("Hannover", "Berlin", "Hamburg"),
  UK("London", "Liverpool", "Bristol"),
  NL("Den Haag", "Amsterdam", "Rotterdam");

  private String[] cities;

  Country(String... strings) {
    cities = strings;
  }

  public String getCity() {
    return cities[new Random().nextInt(cities.length)];
  }
}
