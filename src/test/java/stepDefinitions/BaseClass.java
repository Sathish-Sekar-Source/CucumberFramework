package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.CustomerPage;
import pageObjects.LoginPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BaseClass {

    public static WebDriver driver;
    LoginPage loginPage;
    CustomerPage customerPage;
    private static final Map<String, Object> data = new HashMap<>();
    public static Logger logger;
    public static Properties configProperties;

    public static String generateEmail(String domain) {
        String uniquePart = UUID.randomUUID().toString().substring(0, 3);
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "user" + uniquePart + timestamp + "@" + domain;
    }

    public static String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        Random rand = new Random();
        return rand.ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .reduce("", (a, b) -> a + b);
    }

    public static String getRandomFirstName() {
        List<String> FIRST_NAMES = Arrays.asList(
                "Aarav", "Kavya", "Rohan", "Meera", "Shamitha", "Dhiyaa", "Vihaan", "Ishita"
        );
        return FIRST_NAMES.get(ThreadLocalRandom.current().nextInt(FIRST_NAMES.size()));
    }

    public static String getRandomLastName() {
        List<String> LAST_NAMES = Arrays.asList(
                "Sharma", "Sekar", "Verma", "Reddy", "Patel", "Nair", "Mishra", "Iyer"
        );
        return LAST_NAMES.get(ThreadLocalRandom.current().nextInt(LAST_NAMES.size()));
    }

    public static void put(String key, Object value) {
        data.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) data.get(key);
    }

    public static void clear() {
        data.clear();
    }

}
