import java.util.Scanner;

public class QueueExample {

    int[] queue = new int[5];

    int front = -1;

    int rear = -1;

    
    void enqueue(int value) {

        if (rear == queue.length - 1) {
            System.out.println("Queue is full!");
            return;
        }

       
        if (front == -1) {
            front = 0;
        }

        rear++;
        queue[rear] = value;

        System.out.println(value + " added to queue.");
    }

    
    void dequeue() {

        if (front == -1 || front > rear) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println(queue[front] + " removed from queue.");

        front++;

        
        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

   
    void peek() {

        if (front == -1) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Front element: " + queue[front]);
    }

    void display() {

        if (front == -1) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Queue elements:");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QueueExample q = new QueueExample();

        int choice;

        do {

            System.out.println("\n===== QUEUE MENU =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
