package sprint2;

//Comment it before submitting
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class NotFavouriteDeal {
    public static Node<String> getNodeByIndex(Node<String> node, int index) {
        while (index>0) {
            node = node.next;
            index -= 1;
        }
        return node;
    }
    public static Node<String> solution(Node<String> head, int idx) {

        if (idx==0){
            return head.next;
        }
        Node<String> previousNode = getNodeByIndex(head, idx-1);
        previousNode.next = getNodeByIndex(head, idx).next;

        return head;
    }

    private static void test() {
        Node<String> node4 = new Node<>("vyoe mc", null);
        Node<String> node3 = new Node<>("iiwajidvfg dcqil xhbsyc", node4);
        Node<String> node2 = new Node<>("n kkt yb ct", node3);
        Node<String> node1 = new Node<>("hja", node2);
        Node<String> node0 = new Node<>("ud jjfmsat", node1);
        Node<String> newHead = solution(node0, 0);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;

        while (newHead != null){
            System.out.println(newHead.value);
            newHead = newHead.next;
        }

        // result is : node0 -> node2 -> node3
    }

    public static void main(String[] args) {
        test();
    }
}