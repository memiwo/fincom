import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Issa Fikadu
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Stream.iterate(0, x -> x+1).limit(10).forEach(nums::add);

        int y = 7;
        nums.stream().forEach(System.out::println);
        nums.removeIf(a -> a == y);
        nums.stream().forEach(System.out::println);
    }
}
