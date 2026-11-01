package Exp_10;

import java.util.Scanner;

public class SortingExperiment1 {

    // Selection Sort
    static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap elements
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // Insertion Sort
    static void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Display Array
    static void display(int arr[], int n) {
        System.out.println("Sorted Marks:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter student marks:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\n1. Selection Sort");
        System.out.println("2. Insertion Sort");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                selectionSort(arr, n);
                System.out.println("\nSelection Sort Selected");
                display(arr, n);
                break;

            case 2:
                insertionSort(arr, n);
                System.out.println("\nInsertion Sort Selected");
                display(arr, n);
                break;

            default:
                System.out.println("Invalid Choice!");
        }

        sc.close();
    }
}

