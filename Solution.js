
/**
 * @param {number} numberOfDigits
 * @param {number} absoluteDifference
 * @return {number[]}
 */
var numsSameConsecDiff = function (numberOfDigits, absoluteDifference) {

    const numbersWithSameConsecutiveDifferences = new Set();
    for (let digit = 1; digit <= 9; ++digit) {

        let currentCombinations = [];
        let numberOfDigitsToAdd = numberOfDigits - 1;
        currentCombinations.push(digit);

        while (numberOfDigitsToAdd > 0) {
            const nextCombinations = [];

            for (let current of currentCombinations) {
                if ((current % 10) + absoluteDifference <= 9) {
                    let nextInt = current * 10 + (current % 10) + absoluteDifference;
                    nextCombinations.push(nextInt);
                }
                if ((current % 10) - absoluteDifference >= 0) {
                    let nextInt = current * 10 + (current % 10) - absoluteDifference;
                    nextCombinations.push(nextInt);
                }
            }

            currentCombinations = nextCombinations;
            --numberOfDigitsToAdd;
        }
        currentCombinations.forEach(n => numbersWithSameConsecutiveDifferences.add(n));
    }

    return Array.from(numbersWithSameConsecutiveDifferences);
};
