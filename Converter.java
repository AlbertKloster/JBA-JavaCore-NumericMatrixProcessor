package converter;


public class Converter {
    static final int FRACTION_DIGIT_LENGTH = 5;
    private String number;
    private String base;

    public Converter(String number, String base) {
        this.number = number;
        this.base = base;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String convert() {
        return null;
    }
}