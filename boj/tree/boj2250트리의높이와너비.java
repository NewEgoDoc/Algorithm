package algorithm.boj.tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj2250트리의높이와너비 {
    final static Scanner scanner = new Scanner(System.in);
    // point : 현재 x좌표 (노드를 방문할 때 마다 +1 증가)
    static int point = 1;
    static List<Node> tree = new ArrayList<>();
    static int[] levelMin;
    static int[] levelMax;
    static int maxLevel = 0; // 트리의 최대 레벨(깊이)
    public static void main(String[] args) {
        int n = scanner.nextInt();
        levelMin = new int[n+1];
        levelMax = new int[n+1];
        int rootIndex = 0;
        for(int i =0; i<=n; i++) {
            tree.add(new Node(i, -1, -1));
            levelMin[i] = n;
            levelMax[i] = 0;
        }
        for(int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            tree.get(num).left = left;
            tree.get(num).right = right;
            if(left != -1)  tree.get(left).parent = num;
            if(right != -1) tree.get(right).parent = num;
        }
        for(int i = 1; i<=n; i++) {
            if(tree.get(i).parent == -1) {
                rootIndex = i;
                break;
            }
        }

        inOrder(rootIndex, 1);

        // 완성된 levelMax[]와 levelMin[]을 가지고 값을 뽑아내기
        int answerLevel = 1;
        int answerWidth = levelMax[1] - levelMin[1] + 1;
        for (int i = 2; i<= maxLevel; i++) {
            int width = levelMax[i] - levelMin[i] + 1;
            if(answerWidth < width) {
                answerLevel = i;
                answerWidth = width;
            }
        }
        System.out.println(answerLevel + " " + answerWidth);
    }

    public static void inOrder(int rootIndex, int level) {
        Node root = tree.get(rootIndex);
        if(maxLevel < level) maxLevel = level;
        if(root.left != -1) {
            inOrder(root.left, level + 1);
        }
        // 현재 노드가 가장 왼쪽 노드라면 갱신
        levelMin[level] = Math.min(levelMin[level], point);
        // 현재 노드는 이전노드보다 항상 x좌표가 더 높기 때문에 갱신
        levelMax[level] = point;
        point++;
        if(root.right != -1) {
            inOrder(root.right, level + 1);
        }
    }

    static class Node {
        int parent;
        int num;
        int left;
        int right;

        Node(int num, int left, int right) {
            this.parent = -1;
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
}