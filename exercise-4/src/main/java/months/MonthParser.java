package months;

import java.security.InvalidParameterException;

public class MonthParser {
    public Month parseMonth(int numberOfMonth) {
        switch(numberOfMonth) {
            case 1: return new Month("January", 31);
            case 2: return new Month("February", 28);
            case 3: return new Month("March", 31);
            case 4: return new Month("April", 30);
            case 5: return new Month("May", 31);
            case 6: return new Month("June", 30);
            case 7: return new Month("July", 31);
            case 8: return new Month("August", 31);
            case 9: return new Month("September", 30);
            case 10: return new Month("October", 31);
            case 11: return new Month("November", 30);
            case 12: return new Month("December", 31);
            default:
                throw new InvalidParameterException("Unknown numberOfMonth: " + numberOfMonth);
        }
    }
}
