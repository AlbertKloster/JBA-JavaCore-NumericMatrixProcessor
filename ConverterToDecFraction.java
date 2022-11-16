package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class ConverterToDecFraction extends Converter {

    public ConverterToDecFraction(String number, String base) {
        super(number, base);
    }

    @Override
    public String convert() {
        String sourceNumber = this.getNumber().toLowerCase(Locale.ROOT);
        if (sourceNumber.matches("0*")) {
            return "0";
        }
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal base = new BigDecimal(this.getBase()).setScale(FRACTION_DIGIT_LENGTH, RoundingMode.HALF_DOWN);
        for (int i = 0; i < sourceNumber.length(); i++) {
            int power = i + 1;
            result = result.add(Character.isLetter(sourceNumber.charAt(i)) ?
                    (BigDecimal.valueOf((int) sourceNumber.charAt(i) - 'a' + 10)).divide(base.pow(power), FRACTION_DIGIT_LENGTH * 10_000, RoundingMode.UP) :
                    (BigDecimal.valueOf(Long.parseLong(String.valueOf(sourceNumber.charAt(i)))).divide(base.pow(power), FRACTION_DIGIT_LENGTH, RoundingMode.DOWN)));
        }
        return result.toString().substring(2);
    }
}