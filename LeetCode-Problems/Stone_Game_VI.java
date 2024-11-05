import java.util.Arrays;

public class Stone_Game_VI {

    public int solution( int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        // Create an array to store the combined values and the index of each stone
        int[][] combinedValues = new int[n][2];

        for (int i = 0; i < n; i++) {
            combinedValues[i][0] = aliceValues[i] + bobValues[i]; // combined value
            combinedValues[i][1] = i; // original index
        }

        // Sort stones by combined value in descending order
        Arrays.sort(combinedValues, (a, b) -> b[0] - a[0]);

        int aliceScore = 0;
        int bobScore = 0;

        // Alternate turns: Alice goes first
        for (int i = 0; i < n; i++) {
            int index = combinedValues[i][1];
            if (i % 2 == 0) { // Alice's turn
                aliceScore += aliceValues[index];
            } else { // Bob's turn
                bobScore += bobValues[index];
            }
        }

        // Determine the result
        if (aliceScore > bobScore) {
            return 1; // Alice wins
        } else if (bobScore > aliceScore) {
            return -1; // Bob wins
        } else {
            return 0; // Draw
        }
    }
    public static void main(String[] args) {

    }
}
