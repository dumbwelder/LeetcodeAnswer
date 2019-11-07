package Java8Test;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent();
        optional.get();
        optional.orElse("fallback");
        optional.ifPresent((s)-> System.out.println(s.charAt(0)));
    }
}
