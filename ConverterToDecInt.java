package converter;

import java.math.BigDecimal;
import java.util.Locale;

public class ConverterToDecInt extends Converter {

    public ConverterToDecInt(String number, String base) {
        super(number, base);
    }

    @Override
    public String convert() {
        String sourceNumber = this.getNumber().toLowerCase(Locale.ROOT);
        BigDecimal sourceBase = new BigDecimal(this.getBase());
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < sourceNumber.length(); i++) {
            int power = sourceNumber.length() - 1 - i;
            result = result.add(Character.isLetter(sourceNumber.charAt(i)) ?
                    sourceBase.pow(power).multiply(BigDecimal.valueOf((int) sourceNumber.charAt(i) - 'a' + 10)) :
                    sourceBase.pow(power).multiply(BigDecimal.valueOf(Long.parseLong(String.valueOf(sourceNumber.charAt(i))))));
        }
        return String.valueOf(result);
    }
}