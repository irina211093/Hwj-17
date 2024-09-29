
public class Main {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 2, 3, 5};
        int [] arr2 = new int[]{6, 1, 2, 8, 3, 4, 7, 10, 5};
        int missingNumber = findMissingNumber(arr);
        System.out.print("Недостающее число: " + missingNumber);
        System.out.println();
        missingNumber = findMissingNumber(arr2);
        System.out.print("Недостающее число: " + missingNumber);
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }
        return expectedSum - actualSum;
    }
}