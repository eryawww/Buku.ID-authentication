package enums;

public class GenderEnum {
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int OTHER = 2;
    public String toString(int enums){
        return switch (enums) {
            case 0 -> "MALE";
            case 1 -> "FEMALE";
            case 2 -> "OTHER";
            default -> "-";
        };
    }
}
