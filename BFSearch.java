import java.io.*;
import java.util.*;

public class BFSearch {

    public static int[] BFS(int[][] G, int s) {
        String[] color = new String[G.length];
        int[] dis = new int[G.length];
        int[] parent = new int[G.length];

        // In-efficient: BAD CODE !!!
        /**
         for (int i = 0; i < color.length; i++) {
         color[i] = "white";
         }
         for (int i = 0; i < dis.length; i++) {
         dis[i] = -1;
         }
         for (int i = 0; i < parent.length; i++) {
         parent[i] = -1;
         }
         */
        // ALTERNATE CODE:
        for (int i = 0; i < G.length; i++) {
            color[i] = "white";
            dis[i] = -1;
            parent[i] = -1;
        }

        color[s] = "gray";
        parent[s] = -1;
        dis[s] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        // while (queue != null) {
        while (!queue.isEmpty()) {
            int u = queue.remove();
//            System.out.println(u + "(" + color[u] + ") is visiting."); // TEST ONLY
            for (int j = 0; j < G.length; j++) {
                if (G[u][j] == 1) {

                    if (color[j] == "white") {
                        color[j] = "gray";
//                        System.out.println(j + "(" + color[j] + ") will be visited."); // TEST ONLY
                        dis[j] = dis[u] + 1;
                        parent[j] = u;
                        queue.add(j);
//                        System.out.println(j);  // TEST ONLY
                    }
                }

            }
            color[u] = "black";
//            System.out.println(u + "(" + color[s] + ") visited."); // TEST ONLY
        }
        System.out.println("BFS done, Returning value");
        return dis;
    }

    public static void main(String args[]) {
        // Change the File Directory(Path) for these codes to run succesfully
        String floc = "C:\\Users\\Alimus Sifar\\Documents\\IntelliJ IDEA Projects\\Java\\src\\input.txt";
        File input = new File(floc);
        Scanner sc = null;

        // File Scanning
        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("File NOT FOUND");
            System.exit(1);
        }
        int vertex = sc.nextInt();
        int connections = sc.nextInt();  // edges

        int graph[][] = new int[vertex][vertex];

        for (int i = 0; i < connections; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            graph[l][r] = 1;
            graph[r][l] = 1;
        }
//        // FOR TEST ONLY
//        System.out.println("  0 1 2 3 4 5 6 7 8");
//        for (int i = 0; i < graph.length; i++) {
//            System.out.print(i + " ");
//            for (int j = 0; j < graph.length; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        // FOR TEST ONLY
        int source = 0;
        int[] A = BFS(graph, source);

        int search = sc.nextInt();
        int distA;
        for (int k = 0; k < A.length; k++) {
//            System.out.println("dist of "+ k + " from source: " + A[k]); // TEST ONLY
            if (search == k) {
                System.out.println("Distance from " + source + " to " + k + " is " + A[k]);
            }
        }

/*
        try {
            String s;
            FileReader f = new FileReader("C:\\Users\\Alimus Sifar\\Documents\\IntelliJ IDEA Projects\\Java\\src\\input.txt");
            BufferedReader b = new BufferedReader(f);
            s = b.readLine();
            int v = Integer.parseInt(s);
            int c = Integer.parseInt(b.readLine());

            int graph[][] = new int[v][v];
            for (int i = 0; i < c; i++) {
                StringTokenizer st = new StringTokenizer(s, " ");
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                graph[num1][num2] = 1;
                graph[num2][num1] = 1;
            }
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    System.out.print(graph[i][j]);
                }
                System.out.println();
            }
            int[] A = BFS(graph, 1);

            for (int k = 0; k < A.length; k++) {
                System.out.println(A[k]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
 */
    }
}
