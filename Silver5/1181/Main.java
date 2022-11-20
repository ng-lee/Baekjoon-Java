import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

class Node implements Comparable<Node> {

  String s;

  public Node(String s) {
    this.s = s;
  }

  @Override
  public int compareTo(Node obj) {
    if (this.s.length() == obj.s.length()) {
      return this.s.compareTo(obj.s);
    } else {
      return this.s.length() - obj.s.length();
    }
  }
}

public class Main {

  static int n;
  static List<Node> words;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    words = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      words.add(new Node(br.readLine()));
    }
    words = new ArrayList<Node>(new TreeSet<Node>(words));
    Collections.sort(words);
    for (Node node : words) {
      System.out.println(node.s);
    }
  }
}
