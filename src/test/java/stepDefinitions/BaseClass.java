package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class BaseClass {

    public WebDriver driver;
    public static WebDriver driver1;
    LoginPage loginPage;
    AddCustomerPage addCustomerPage;

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
        List<String> FIRST_NAMES = List.of(
                "Aarav", "Kavya", "Rohan", "Meera", "Shamitha", "Dhiyaa", "Vihaan", "Ishita"
        );
        return FIRST_NAMES.get(ThreadLocalRandom.current().nextInt(FIRST_NAMES.size()));
    }

    public static String getRandomLastName() {
        List<String> LAST_NAMES = List.of(
                "Sharma", "Sekar", "Verma", "Reddy", "Patel", "Nair", "Mishra", "Iyer"
        );
        return LAST_NAMES.get(ThreadLocalRandom.current().nextInt(LAST_NAMES.size()));
    }


}
