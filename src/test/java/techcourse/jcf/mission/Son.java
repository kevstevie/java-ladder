package techcourse.jcf.mission;

import java.util.Objects;

public class Son extends Parent{

    private final int value;

    public Son(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Son son = (Son) o;
        return value == son.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
