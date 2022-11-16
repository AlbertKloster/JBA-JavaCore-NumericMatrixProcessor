package converter;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class ConverterFromDecInt extends Converter {

    public ConverterFromDecInt(String number, String base) {
        super(number, base);
    }

    @Override
    public String convert() {
        BigDecimal targetBase = new BigDecimal(this.getBase());
        BigDecimal quotient = new BigDecimal(this.getNumber()).setScale(0, RoundingMode.DOWN);
        BigDecimal remainder;
        StringBuilder reversedString = new StringBuilder();
        while (true) {
            remainder = quotient.remainder(targetBase);
            quotient = quotient.divide(targetBase,RoundingMode.DOWN);
            reversedString.append(remainder.compareTo(BigDecimal.TEN) < 0 ? String.valueOf(remainder) :
                    (char) (remainder.intValue() - 10 + 'a'));
            if (quotient.compareTo(BigDecimal.ONE) < 0) {
                break;
            }
        }
        return reversedString.toString().isEmpty() ? "0" : reversedString.reverse().toString();
    }
}