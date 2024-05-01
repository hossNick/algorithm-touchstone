import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;


public class Main {

    private static final Integer COUNT = 50;

    public static void main(String[] args) {
        findDuplicateService();
              List<Integer> list = IntStream.range(20, COUNT + 20)
                .boxed().toList();
        
        System.out.println("*******************************************");
        System.out.println("find pair for assumed sum");
        findSumOfSortedList(list, COUNT);

    }

    public static void findDuplicateService() {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            list.add(ThreadLocalRandom.current().nextInt(1, COUNT / 2));
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer i : list) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
            if (frequencyMap.get(i) > 1) {
                result = i;
            }
        }
        String message = (result == 0 ? " no duplicate " : String.valueOf(result));
        System.out.println(" find first duplicate number in " + list);
        System.out.format(" is : " + message +" \n");
    }

       public static void findSumOfSortedList(List<Integer> sortedList, int assumedSum) {
        int first = 0;
        int last = sortedList.size() - 1;
        boolean find = false;
        while (first < last) {
            if (sortedList.get(first) + sortedList.get(last) == assumedSum) {
                find = true;
                break;
            } else if (sortedList.get(first) + sortedList.get(last) < assumedSum) {
                first++;
            } else {
                last--;
            }
        }

        if (find) {
            System.out.println("in position " + first + " and " + last + " we have assumedSum");
        } else {
            System.out.println("no pair found for assumed sum ");
        }
    }
}