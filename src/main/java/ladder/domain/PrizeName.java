package ladder.domain;

public class PrizeName {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final String INVALID_LENGTH_MESSAGE = "상품 이름은 공백이거나 " + MAX_NAME_LENGTH + " 초과일 수 없습니다.";

    private final String value;

    public PrizeName(String value) {
        value = value.trim();
        validate(value);
        this.value = value;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}
