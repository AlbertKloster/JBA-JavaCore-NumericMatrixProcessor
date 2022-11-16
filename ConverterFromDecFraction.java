package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConverterFromDecFraction extends Converter {

    public ConverterFromDecFraction(String number, String base) {
        super(number, base);
    }

    @Override
    public String convert() {
        StringBuilder result = new StringBuilder();
        if (this.getNumber().equals("0")) {
            result.append(this.getNumber().repeat(Math.max(0, FRACTION_DIGIT_LENGTH)));
        } else {
            BigDecimal base = new BigDecimal(this.getBase());
            BigDecimal fraction = new BigDecimal("0." + this.getNumber());
            for (int i = 0; i < FRACTION_DIGIT_LENGTH; i++) {
                fraction = fraction.multiply(base);
                BigDecimal intRemainder = fraction.setScale(0, RoundingMode.DOWN);
                result.append(intRemainder.compareTo(BigDecimal.TEN) < 0 ? intRemainder.setScale(0, RoundingMode.DOWN) :
                        (char) (intRemainder.intValue() - 10 + 'a'));
                fraction = fraction.subtract(intRemainder);
            }
        }
        return String.valueOf(result);
    }
}