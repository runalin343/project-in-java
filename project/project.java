import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class PRG {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;':\",.<>?";
    private static final int PASSWORD_LENGTH = 8;

    public static String generatePassword() {
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // Add a random lowercase character
        password.append(LOWERCASE_CHARS.charAt(random.nextInt(LOWERCASE_CHARS.length())));

        // Add a random uppercase character
        password.append(UPPERCASE_CHARS.charAt(random.nextInt(UPPERCASE_CHARS.length())));

        // Add a random numeric character
        password.append(NUMERIC_CHARS.charAt(random.nextInt(NUMERIC_CHARS.length())));

        // Add a random special character
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        // Add random characters to fill out the remaining length of the password
        for (int i = 0; i < PASSWORD_LENGTH - 4; i++) {
            String charSet = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMERIC_CHARS + SPECIAL_CHARS;
            password.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        // shuffle the password to make it more random
        String shuffled = shuffleString(password.toString());
        return shuffled;
    }

    public static String shuffleString(String input) {

        List<Character> characters = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(characters);
        return characters.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println("password: "+generatePassword());
    }
}

