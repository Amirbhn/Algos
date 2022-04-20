package applciation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {
  public static void main(String[] args) {
    Random rand = new Random();
    int [] numbers = new int[10];
    for (int i = 0; i <numbers.length ; i++) {
      numbers[i] = rand.nextInt(10);
    }
    System.out.println("Before Implementing Merge Sort : " );
    System.out.println(Arrays.toString(numbers));
    mergeSort(numbers);
    System.out.println("\nAfter Implementing Merge Sort : " );
    System.out.println(Arrays.toString(numbers));
  }

  private static void mergeSort(int[] inputArray) {
    int inputLength = inputArray.length;
    if (inputLength < 2) {
      return;
    }
    int midIndex = inputLength / 2;
    int[] leftHalf = new int[midIndex];
    int[] rightHalf = new int[inputLength - midIndex];

    for (int i = 0; i < midIndex; i++) {
      leftHalf[i] = inputArray[i];
    }

    for (int i = midIndex; i < inputArray.length; i++) {
      rightHalf[i - midIndex] = inputArray[i];
    }

    mergeSort(leftHalf);
    mergeSort(rightHalf);

    // Merge
    mergeSort(leftHalf);
    mergeSort(rightHalf);

    merge(inputArray, leftHalf, rightHalf);
  }

  private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;
    int leftHalfIndicator = 0, rightHalfIndicator = 0, mergedArrayIndicator = 0;

    while (leftHalfIndicator < leftSize && rightHalfIndicator < rightSize) {
      if (leftHalf[leftHalfIndicator] <= rightHalf[rightHalfIndicator]) {
        inputArray[mergedArrayIndicator] = leftHalf[leftHalfIndicator];
        leftHalfIndicator++;
      } else {
        inputArray[mergedArrayIndicator] = rightHalf[rightHalfIndicator];
        rightHalfIndicator++;
      }
      mergedArrayIndicator++;
    }
    // Take care of left over elements
    while (leftHalfIndicator < leftSize) {
      inputArray[mergedArrayIndicator] = leftHalf[leftHalfIndicator];
      leftHalfIndicator++;
      mergedArrayIndicator++;
    }
    while (rightHalfIndicator < rightSize) {
      inputArray[mergedArrayIndicator] = rightHalf[rightHalfIndicator];
      rightHalfIndicator++;
      mergedArrayIndicator++;
    }
  }
}
