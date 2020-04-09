import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PriorityQueueTest {
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void PriorityQueueParameterTest(List<Integer> expected, List<Integer> input) {
        PriorityQueue<Integer> _number = new PriorityQueue();
        for(int i=0; i< input.size(); i++)
            _number.add(input.get(i));
        assertEquals(expected.toString(), _number.toString());
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments(Arrays.asList(1, 3, 1), Arrays.asList(3, 2, 1)),
                arguments(Arrays.asList(-3, -1, -2), Arrays.asList(-1, -2, -3)),
                arguments(Arrays.asList(-1, 0, 3), Arrays.asList(-1, 0, 3)),
                arguments(Arrays.asList(-1, 3, 0), Arrays.asList(3, -1, 0)),
                arguments(Arrays.asList(0, 5, 3), Arrays.asList(5, 3, 0))
        );
    }

    @Test
    public void PriorityQueueAddExceptionTest() {
        PriorityQueue<Integer> _number = new PriorityQueue();
        Throwable exception = assertThrows(NullPointerException.class, () -> _number.add(null));
        assertEquals(null, exception.getMessage());
    }
    @Test
    public void PriorityQueueAddAllExceptionTest() {
        PriorityQueue<Integer> _number = new PriorityQueue();
        Throwable exception = assertThrows(NullPointerException.class, () -> _number.addAll(null));
        assertEquals(null, exception.getMessage());
    }
    @Test
    public void PriorityQueueOfferExceptionTest() {
        PriorityQueue<Integer> _number = new PriorityQueue();
        Throwable exception = assertThrows(NullPointerException.class, () -> _number.offer(null));
        assertEquals(null, exception.getMessage());
    }

//    @ParameterizedTest
//    @CsvSource({
//            "'[1, 3, 2]',  '[3, 2, 1]'",
//            "'[-3, -1, -2]',  '[-1, -2, -3]'",
//            "'[-1, 0, 3]',  '[-1, 0, 3]'",
//            "'[-1, 3, 0]',  '[3, -1, 0]'",
//            "'[0, 5, 3]',  '[5, 3, 0]'",
//    })
//    void PriorityQueueCsvTest(String expected, String input) {
//        String[] st = PriorityQueueTest.StringToInteger(input);
//        PriorityQueue<Integer> _number = new PriorityQueue();
//        for(int i=0; i< st.length; i++)
//            _number.add(Integer.valueOf(st[i]));
//
//        assertEquals(expected, _number.toString());
//    }
//
//    static String[] StringToInteger(String input)
//    {
//        input = input.substring(1, input.length()-1);
//        String regex = ", ";
//        String[] st = input.split(regex);
//        return st;
//    }
}


