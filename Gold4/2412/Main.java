import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {

  int y, x, cnt;

  public Node(int x, int y, int cnt) {
    this.x = x;
    this.y = y;
    this.cnt = cnt;
  }
}

public class Main {

  static int n, t;
  static HashMap<Integer, ArrayList<Integer>> available;
  static HashMap<Integer, ArrayList<Integer>> visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    available = new HashMap<>();
    visited = new HashMap<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if (!available.containsKey(x)) {
        available.put(x, new ArrayList<>());
        visited.put(x, new ArrayList<>());
      }
      available.get(x).add(y);
    }

    Deque<Node> que = new ArrayDeque<>();
    que.offer(new Node(0, 0, 0));
    while (!que.isEmpty()) {
      Node node = que.poll();

      if (node.y == t) {
        System.out.println(node.cnt);
        System.exit(0);
      }

      for (int nx = node.x - 2; nx < node.x + 3; nx++) {
        for (int ny = node.y - 2; ny < node.y + 3; ny++) {
          if (
            available.containsKey(nx) &&
            available.get(nx).contains(ny) &&
            !visited.get(nx).contains(ny)
          ) {
            visited.get(nx).add(ny);
            que.offer(new Node(nx, ny, node.cnt + 1));
          }
        }
      }
    }
    System.out.println(-1);
  }
}
