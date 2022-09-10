
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
    
public:
    vector<int> numsSameConsecDiff(int numberOfDigits, int absoluteDifference) {

        unordered_set<int> numbersWithSameConsecutiveDifferences;

        for (int digit = 1; digit <= 9; ++digit) {

            vector<int> currentCombinations;
            int numberOfDigitsToAdd = numberOfDigits - 1;
            currentCombinations.push_back(digit);

            while (numberOfDigitsToAdd > 0) {

                vector<int> nextCombinations;

                for (int current : currentCombinations) {
                    if ((current % 10) + absoluteDifference <= 9) {
                        int nextInt = current * 10 + (current % 10) + absoluteDifference;
                        nextCombinations.push_back(nextInt);
                    }
                    if ((current % 10) - absoluteDifference >= 0) {
                        int nextInt = current * 10 + (current % 10) - absoluteDifference;
                        nextCombinations.push_back(nextInt);
                    }
                }

                currentCombinations = nextCombinations;
                --numberOfDigitsToAdd;
            }
            for (const auto& n : currentCombinations) {
                numbersWithSameConsecutiveDifferences.insert(n);
            }
        }

        return vector<int>(numbersWithSameConsecutiveDifferences.begin(), numbersWithSameConsecutiveDifferences.end());
    }
};
