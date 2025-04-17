package lambdasinaction.chap10;

import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class Practice_10_3 {

    @Test
    public void test() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationWithOptional(props, "a"));
        assertEquals(0, readDurationWithOptional(props, "b"));
        assertEquals(0, readDurationWithOptional(props, "c"));
        assertEquals(0, readDurationWithOptional(props, "d"));
    }

    public static int readDurationWithOptional(Properties props, String name) {
        return Optional.ofNullable(props)
                .map(p -> p.getProperty(name))
                .flatMap(Practice_10_3::stringToInt)
                .filter(time -> time > 0)
                .orElse(0);
    }

    public static int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) { }
        }
        return 0;
    }

    // 工具方法：类型转换，用Optional -> 封装try/catch，避免类型转换时抛出异常
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
