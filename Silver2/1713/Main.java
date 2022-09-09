import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static int[] students;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    students = new int[101];
    Queue<Integer> que = new LinkedList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      int student = Integer.parseInt(st.nextToken());
      if (!que.contains(student)) {
        if (que.size() == n) {
          int delStudent = que.poll();
          students[delStudent] = 0;
        }
        que.add(student);
      }
      students[student]++;
    }
    for (int i = 0; i < 101; i++) {
      if (students[i] != 0) {
        sb.append(i).append(" ");
      }
    }
    System.out.print(sb);
  }
}
