package examples;

import java.util.Arrays;

/**
 * 
 * @author t_endo
 */
public enum Progress {

    NEW(0),

    WORK_IN_PROGRESS(1),

    DONE(2);

    private final int value;

    private Progress(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Progress of(int value) {
        return Arrays.stream(Progress.values()).filter(p -> p.value == value)
                .findFirst().orElse(null);
    }
}
