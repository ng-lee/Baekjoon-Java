import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  static int n, m;
  static int[][] matrix;
  static int[][] answer;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    matrix = new int[n][m];
    answer = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        answer[i][j] = -1;
      }
    }

    int sy = 0;
    int sx = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
        if (matrix[i][j] == 2) {
          sy = i;
          sx = j;
        }
        if (matrix[i][j] == 0) answer[i][j] = 0;
      }
    }

    Deque<int[]> que = new LinkedList<>();
    que.offer(new int[] { sy, sx });
    answer[sy][sx] = 0;

    while (!que.isEmpty()) {
      int[] curr = que.pollFirst();
      int y = curr[0];
      int x = curr[1];

      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if (
          0 <= nx &&
          nx < m &&
          0 <= ny &&
          ny < n &&
          matrix[ny][nx] == 1 &&
          answer[ny][nx] == -1
        ) {
          answer[ny][nx] = answer[y][x] + 1;
          que.offer(new int[] { ny, nx });
        }
      }
    }

    for (int[] row : answer) {
      for (int r : row) {
        System.out.print(r + " ");
      }
      System.out.println();
    }
  }
}
