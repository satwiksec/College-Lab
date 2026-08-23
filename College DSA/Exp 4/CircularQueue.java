import java.util.Scanner;

class CircularQueue {
    int[] queue;
    int front, rear, size, count;

    CircularQueue(int n) {
        size = n;
        queue = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    void enqueue(int value) {
        if (count == size) {
            System.out.println("Queue is Full");
            return;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;
        count++;

        System.out.println("Print Job " + value + " Added");
    }

    void dequeue() {
        if (count == 0) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Print Job " + queue[front] + " Completed");

        front = (front + 1) % size;
        count--;
    }

    void display() {
        if (count == 0) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Print Queue: ");

        int i = front;
        for (int j = 0; j < count; j++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Queue Size: ");
        int n = sc.nextInt();

        CircularQueue cq = new CircularQueue(n);

        while (true) {
            System.out.println("\n--- Circular Queue Menu ---");
            System.out.println("1. Add Print Job");
            System.out.println("2. Complete Print Job");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Print Job ID: ");
                    int job = sc.nextInt();
                    cq.enqueue(job);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.display();
                    break;

                case 4:
                    System.out.println("Program Ended");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
