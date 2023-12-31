# Problem
### Problem Description

Given a fixed-length integer array `arr`, duplicate each occurrence of zero, shifting the remaining elements to the right. Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

### Example 1

**Input:**
arr = [1,0,2,3,0,4,5,0]
**Output:**
[1,0,0,2,3,0,0,4]

**Explanation:**
After calling your function, the input array is modified to: `[1,0,0,2,3,0,0,4]`

### Example 2

**Input:**
arr = [1,2,3]
**Output:**
[1,2,3]

**Explanation:**
After calling your function, the input array is modified to: `[1,2,3]`

### Constraints

- 1 <= `arr.length` <= 10^4
- 0 <= `arr[i]` <= 9


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Recorrer hacia la derecha utilizando fuerza bruta, para iterar y mover a la izquierda, esto requeria mucho trabajo.

# Approach
<!-- Describe your approach to solving the problem. -->
Decidi crear un arreglo temporal con el tamaño del input, y agregar un index, recorro una vez considerando que el index puede salir del tamaño del array por ende agrego una condicional.
Al inicializar en 0 los arreglos en java decidi aprovechar esto y copiar en una posición más a la derecha los valores del arreglo original, si es 0 aumento el valor del index en 1.

# Complexity
- Time complexity: $O(n)$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $O(n)$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public void duplicateZeros(int[] arr) {
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
    }
}
```