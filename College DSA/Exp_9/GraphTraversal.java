import java.util.Scanner;

public class GraphTraversal {

    static int[][] graph = new int[20][20];
    static boolean[] visited = new boolean[20];
    static int n;

    // Breadth First Search
    static void BFS(int start) {
        int[] queue = new int[n];
        int front = 0, rear = 0;

        // Visit the starting city
        visited[start] = true;
        queue[rear++] = start;

        System.out.print("BFS Traversal: ");

        while (front < rear) {
            int current = queue[front++];
            System.out.print(current + " ");

            // Check all adjacent cities
            for (int i = 0; i < n; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue[rear++] = i;
                }
            }
        }

        System.out.println();
    }

    // Depth First Search
    static void DFS(int current) {
        visited[current] = true;
        System.out.print(current + " ");

        // Visit adjacent cities recursively
        for (int i = 0; i < n; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting city (0 to " + (n - 1) + "): ");
        int start = sc.nextInt();

        if (start < 0 || start >= n) {
            System.out.println("Invalid starting city!");
            sc.close();
            return;
        }

        // Perform BFS
        BFS(start);

        // Reset visited array before DFS
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        // Perform DFS
        System.out.print("DFS Traversal: ");
        DFS(start);
        System.out.println();

        sc.close();
    }
}