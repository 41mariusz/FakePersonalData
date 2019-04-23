public class Main extends Generator {
  public static void main(String[] args) {
    System.out.println(generateRandomDate("1800-01-01", "1899-12-30"));
    System.out.println(generateNumberRange(0, 10));
    System.out.println(generateNumber(3));
    System.out.println(generateEmail(11));
    System.out.println(generatePasswd(5));
    System.out.println(generateString(3));
    System.out.println(generateName(Name.Male));
    System.out.println(generateCity(Country.NL));

    System.out.println("-------");

    System.out.println(generateRandomDate("2000-01-01", "2010-12-30"));
    System.out.println(generateNumberRange(422, 4532));
    System.out.println(generateNumber(2));
    System.out.println(generateEmail(10));
    System.out.println(generatePasswd(7));
    System.out.println(generateString(8));
    System.out.println(generateName(Name.Female));
    System.out.println(generateCity(Country.UK));
    System.out.println(generatePesel());
  }
}
