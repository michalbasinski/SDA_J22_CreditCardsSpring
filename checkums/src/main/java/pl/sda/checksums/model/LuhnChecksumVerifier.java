package pl.sda.checksums.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
class LuhnChecksumVerifier {

    boolean verify(String cardNo) {
        Integer sum = 0;
        validateCardNumber(cardNo);
        cardNo = processCardNo(cardNo);
        List<Character> processedNumber = processArray(cardNo.toCharArray());
        int i = 1;
        for (Character character : processedNumber) {
            Integer increment = i % 2 == 0 ?
                    2 * Integer.parseInt(character.toString()) : Integer.parseInt(character.toString());
            increment = increment >= 10 ? increment - 9 : increment;
            sum += increment;
            i++;
        }

        return sum % 10 == 0;
    }

    private List<Character> processArray(char[] chars) {
        List<Character> result = new ArrayList<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            result.add(chars[i]);
        }
        return result;
    }

    private void validateCardNumber(String cardNo) {
        Pattern pattern = Pattern.compile(".*[A-Za-z]+.*");
        Matcher matcher = pattern.matcher(cardNo);
        boolean matches = matcher.matches();
        if (matches) {
            throw new RuntimeException("Numer karty zawiera niedozwolone znaki");
        }
    }

    private String processCardNo(String cardNo) {
        return cardNo.replace(" ", "");
    }

}
