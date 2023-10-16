import java.util.Arrays;

class Solution {
    public static void duplicateZeros(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int size = arr.length, index = 0;
        int[] temp = new int[size];

        for (int i = 0; i < size; i++) {

            if (index >= size) {
                break;
            }

            temp[index++] = arr[i];

            if (arr[i] == 0) {
               index++;
            }
        }

        for (int x = 0; x < size; x++) {
            arr[x] = temp[x];
        }
        System.out.println(Arrays.toString(arr));
    }
}