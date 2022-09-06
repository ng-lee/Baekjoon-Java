import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] heights;
  static int[] answer;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    heights = new int[n + 1];
    answer = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 1; i < n+ 1; i++) {
        
    }
  }
}
