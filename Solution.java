
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[] numsSameConsecDiff(int numberOfDigits, int absoluteDifference) {

        Set<Integer> numbersWithSameConsecutiveDifferences = new HashSet<>();

        for (int digit = 1; digit <= 9; ++digit) {

            List<Integer> currentCombinations = new ArrayList<>();
            int numberOfDigitsToAdd = numberOfDigits - 1;
            currentCombinations.add(digit);

            while (numberOfDigitsToAdd > 0) {
                List<Integer> nextCombinations = new ArrayList<>();

                for (int current : currentCombinations) {
                    if ((current % 10) + absoluteDifference <= 9) {
                        int nextInt = current * 10 + (current % 10) + absoluteDifference;
                        nextCombinations.add(nextInt);
                    }
                    if ((current % 10) - absoluteDifference >= 0) {
                        int nextInt = current * 10 + (current % 10) - absoluteDifference;
                        nextCombinations.add(nextInt);
                    }
                }

                currentCombinations = nextCombinations;
                --numberOfDigitsToAdd;

            }
            numbersWithSameConsecutiveDifferences.addAll(currentCombinations);
        }

        return numbersWithSameConsecutiveDifferences.stream().mapToInt(n -> n).toArray();
    }
}
