package recursive.dfs;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", lt=" + lt +
                ", rt=" + rt +
                '}';
    }
}

/**
 * DFS 의 반환값은 Math.MIN(DFS,DFS) 의 결과값이 된다.
 */

public class 말경탐_DFS {

    Node root;

    public int DFS(int L, Node root) {

        if (root.lt == null && root.rt == null) {
            return L;
        } else {
            return Math.min(
                    DFS(L + 1, root.lt),
                    DFS(L + 1, root.rt));
        }


    }

    public static void main(String[] args) {

        말경탐_DFS tree = new 말경탐_DFS();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.DFS(0, tree.root));

    }
}
