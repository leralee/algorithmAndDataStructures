package sprint2;

/**
 * @author valeriali on {15.06.2023}
 * @project algirithms
 */

//Comment it before submitting
 class Node2<V> {
    public V value;
    public Node2<V> next;
    public Node2<V> prev;

    public Node2(V value, Node2<V> next, Node2<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}


public class AllInsideOut {
    public static Node2<String> solution(Node2<String> head) {
        Node2<String> newHead = null;

        while (head != null) {
            Node2<String> nextNode = head.next;

            // Переворачиваем указатели next и prev для текущего узла
            head.next = head.prev;
            head.prev = nextNode;

            newHead = head; // Обновляем голову перевернутого списка

            head = nextNode; // Переходим к следующему узлу
        }

        return newHead;
    }

    private static void test() {
        Node2<String> node3 = new Node2<>("node3", null, null);
        Node2<String> node2 = new Node2<>("node2", node3, null);
        Node2<String> node1 = new Node2<>("node1", node2, null);
        Node2<String> node0 = new Node2<>("node0", node1, null);
        node1.prev = node0;
        node2.prev = node1;
        node3.prev = node2;
        Node2<String> newNode = solution(node0);
        while (newNode != null){
            System.out.println(newNode.value);
            newNode = newNode.next;
        }
        /* result is :*/
        assert newNode == node3;
        assert node3.next == node2;
        assert node2.next == node1;
        assert node1.next == node0;
        assert node2.prev == node3;
        assert node1.prev == node2;
        assert node0.prev == node1;
    }

    public static void main(String[] args) {
        test();
    }
}
