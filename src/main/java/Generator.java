import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

abstract class Generator {

  private final static String smallLetters = "qwertyuiopasdfghjklzxcvbnm";
  private final static String bigLetters = smallLetters.toUpperCase();
  private final static String specialSigns = "!@#$%^&*()_+?<>";
  private final static String numbers = "1234567890";

  static String generateRandomDate(String startDate, String endDate) {
    try {
      String format = "yyy-MM-dd";
      DateFormat formatter = new SimpleDateFormat(format);
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(formatter.parse(startDate));
      Long value1 = calendar.getTimeInMillis();

      calendar.setTime(formatter.parse(endDate));
      Long value2 = calendar.getTimeInMillis();

      long value3 = (long) (value1 + Math.random() * (value2 - value1));
      calendar.setTimeInMillis(value3);
      return formatter.format(calendar.getTime());
    } catch (Exception e) {
      return "error";
    }
  }

  static int generateNumber(int length) {
    StringBuilder number = new StringBuilder();
    for (int i = 0; i < length; i++) {
      number.append(new Random().nextInt(10));
    }
    return Integer.parseInt(number.toString());
  }

  static int generateNumberRange(int from, int to) {
    return new Random().nextInt(to - from + 1) + from;
  }

  static String generateEmail(int length) {
    StringBuilder result = new StringBuilder();
    String twoString = smallLetters + numbers;
    String[] host = {"gmail.com", "o2.pl", "mail.ru", "yahoo.com", "wp.pl", "yandex.com"};
    String domain = host[generateNumberRange(0, host.length - 1)];
    for (int i = 0; i < length - domain.length() - 1; i++) {
      result.append(twoString.charAt(generateNumberRange(0, twoString.length() - 1)));
    }
    if (result.toString().length() > 0) return String.format("%s@%s", result.toString(), domain);
    else return String.format("error@%s", domain);
  }

  static String generateString(int length) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < length; i++) {
      result.append(smallLetters.charAt(generateNumberRange(0, smallLetters.length() - 1)));
    }
    return result.toString();
  }

  static String generatePasswd(int length) {
    StringBuilder result = new StringBuilder();
    String allStrings = smallLetters + bigLetters + specialSigns + numbers;
    for (int i = 0; i < length; i++) {
      result.append(allStrings.charAt(generateNumberRange(0, allStrings.length() - 1)));
    }
    return result.toString();
  }

  static String generateName(Name g) {
    if (g == Name.Male) {
      return Name.Male.getName();
    } else if (g == Name.Female) {
      return Name.Female.getName();
    }
    return null;
  }

  static String generateCity(Country country) {
    if (country == Country.PL) {
      return Country.PL.getCity();
    } else if (country == Country.DE) {
      return Country.DE.getCity();
    } else if (country == Country.UK) {
      return Country.DE.getCity();
    } else if (country == Country.NL) {
      return Country.DE.getCity();
    }
    return null;
  }

  static String generatePesel() {
    String pesel;
    int checksum = 0;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String datetime = generateRandomDate("1970-01-01", "2010-12-30");
    Date date = null;
    try {
      date = format.parse(datetime);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    SimpleDateFormat dfYear = new SimpleDateFormat("yyyy");
    SimpleDateFormat dfMonth = new SimpleDateFormat("MM");
    SimpleDateFormat dfDay = new SimpleDateFormat("dd");
    String year = dfYear.format(date);
    String month = dfMonth.format(date);
    String day = dfDay.format(date);
    String monthPesel = null;
    if (Integer.parseInt(year) >= 1800 && Integer.parseInt(year) <= 1899) {
      if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 9) monthPesel = "8" + month.substring(1, 2);
      else monthPesel = "9" + month.substring(1, 2);
    } else if (Integer.parseInt(year) >= 1900 && Integer.parseInt(year) <= 1999) {
      monthPesel = month;
    } else if (Integer.parseInt(year) >= 2000 && Integer.parseInt(year) <= 2099) {
      if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 9) monthPesel = "2" + month.substring(1, 2);
      else monthPesel = "3" + month.substring(1, 2);
    } else if (Integer.parseInt(year) >= 2100 && Integer.parseInt(year) <= 2199) {
      if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 9) monthPesel = "4" + month.substring(1, 2);
      else monthPesel = "5" + month.substring(1, 2);
    } else if (Integer.parseInt(year) >= 2200 && Integer.parseInt(year) <= 2299) {
      if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 9) monthPesel = "6" + month.substring(1, 2);
      else monthPesel = "7" + month.substring(1, 2);
    }

    pesel = year.substring(2, 4) + monthPesel + day + generateNumber(4);


    checksum += Character.getNumericValue(pesel.charAt(0));
    checksum += Character.getNumericValue(pesel.charAt(1)) * 3;
    checksum += Character.getNumericValue(pesel.charAt(2)) * 7;
    checksum += Character.getNumericValue(pesel.charAt(3)) * 9;
    checksum += Character.getNumericValue(pesel.charAt(4));
    checksum += Character.getNumericValue(pesel.charAt(5)) * 3;
    checksum += Character.getNumericValue(pesel.charAt(6)) * 7;
    checksum += Character.getNumericValue(pesel.charAt(7)) * 9;
    checksum += Character.getNumericValue(pesel.charAt(8));
    checksum += Character.getNumericValue(pesel.charAt(9)) * 3;

    pesel += 10 - checksum % 10;

    return pesel;
  }

  static int generateEvenNumber() {
    int number;
    do {
      number = generateNumber(1);
    } while (number % 2 == 0);
    return number;
  }

  static int generateOddNumber() {
    int number;
    do {
      number = generateNumber(1);
    } while (number % 2 != 0);
    return number;
  }

}