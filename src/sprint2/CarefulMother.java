package sprint2;
//Comment it before submitting
//class Node<V> {
//    public V value;
//    public Node<V> next;
//
//    public Node(V value, Node<V> next) {
//        this.value = value;
//        this.next = next;
//    }
//}


public class CarefulMother {
    public static int solution(Node<String> head, String elem) {
        int indexOfElem = 0;
        while (!head.value.equals(elem)){
            indexOfElem++;
            head = head.next;
            if (head == null){
                return -1;
            }
        }
        return indexOfElem;

    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node0");
        System.out.println(idx);
        assert idx == 2;
    }

    public static void main(String[] args) {
        test();
    }
}