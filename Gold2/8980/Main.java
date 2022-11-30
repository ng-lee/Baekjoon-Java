import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Box implements Comparable<Box> {

  int s, e, sz;

  public Box(int s, int e, int sz) {
    this.s = s;
    this.e = e;
    this.sz = sz;
  }

  @Override
  public int compareTo(Box box) {
    return this.e - box.e;
  }
}

public class Main {

  static int n, c, m;
  static List<Box> boxes;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(br.readLine());
    boxes = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int sz = Integer.parseInt(st.nextToken());
      boxes.add(new Box(s, e, sz));
    }

    Collections.sort(boxes);

    int[] capa = new int[n];
    Arrays.fill(capa, c);
    int answer = 0;

    for (Box box : boxes) {
      int min = c;
      for (int i = box.s; i < box.e; i++) {
        min = Integer.min(min, capa[i]);
      }
      min = Integer.min(min, box.sz);
      answer += min;
      for (int i = box.s; i < box.e; i++) {
        capa[i] -= min;
      }
    }
    System.out.println(answer);
  }
}
