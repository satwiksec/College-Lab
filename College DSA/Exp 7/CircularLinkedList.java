import java.util.Scanner;

class CircularLinkedList {
    class Node {
        String player;
        Node next;

        Node(String p) {
            player = p;
            next = null;
        }
    }

    Node last = null;

    void insert(String player) {
        Node newNode = new Node(player);

        if(last == null) {
            last = newNode;
            last.next = last;
        }
        else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }

        System.out.println("Player inserted");
    }

    void delete(String player) {
        if(last == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = last.next;
        Node previous = last;

        do {
            if(current.player.equals(player)) {
                if(current == last && current == last.next) {
                    last = null;
                }
                else {
                    previous.next = current.next;

                    if(current == last)
                        last = previous;
                }

                System.out.println("Player deleted");
                return;
            }

            previous = current;
            current = current.next;

        } while(current != last.next);

        System.out.println("Player not found");
    }

    void display() {
        if(last == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = last.next;

        System.out.println("Players:");

        do {
            System.out.print(temp.player + " ");
            temp = temp.next;
        } while(temp != last.next);

        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        CircularLinkedList list = new CircularLinkedList();

        int choice;

        do {
            System.out.println("\n1. Insert Player");
            System.out.println("2. Delete Player");
            System.out.println("3. Display Players");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String player = sc.nextLine();
                    list.insert(player);
                    break;

                case 2:
                    System.out.print("Enter player name to delete: ");
                    player = sc.nextLine();
                    list.delete(player);
                    break;

                case 3:
                    list.display();
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 4);
    }
}