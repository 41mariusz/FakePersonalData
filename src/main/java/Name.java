import java.util.Random;

public enum Name {
  Female("Ada", "Adela", "Adriana", "Adrianna", "Agata", "Agnieszka", "Alana", "Aleksandra", "Alessandra", "Alexandra", "Alia", "Alice", "Alicja", "Alina", "Alisa", "Aisha", "Amalia", "Amanda", "Amelia", "Anastasiia", "Anastazja", "Anatolia"),
  Male("Aaron", "Adam", "Adrian", "Alan", "Albert", "Alek", "Aleks", "Aleksander", "Aleksy", "Alex", "Alexander", "Allan", "Amadeusz", "Amir", "Anatol", "Andrzej", "Antoni", "Ariel", "Arkadiusz", "Aron", "Artur");

  private String[] names;

  Name(String... strings) {
    names = strings;
  }

  public String getName() {
    return names[new Random().nextInt(names.length)];
  }
}
