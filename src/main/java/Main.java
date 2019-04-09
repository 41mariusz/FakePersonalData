import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

  static String Format = "yyy-MM-dd";


  public static String generateRandomDate(String startDate, String endDate) throws ParseException {
    DateFormat formatter = new SimpleDateFormat(Format);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(formatter.parse(startDate));
    Long value1 = calendar.getTimeInMillis();

    calendar.setTime(formatter.parse(endDate));
    Long value2 = calendar.getTimeInMillis();

    long value3 = (long) (value1 + Math.random() * (value2 - value1));
    calendar.setTimeInMillis(value3);
    return formatter.format(calendar.getTime());
  }


  public static void main(String args[]) throws ParseException {

    System.out.println(generateRandomDate("1800-01-01", "1899-12-30"));

  }
}