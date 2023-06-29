package sprint2.LinkedQueue;

import java.io.*;

/**
 * @author valeriali on {19.06.2023}
 * @project algorithms
 */

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

class Queue{

    private Node head;
    private Node tail;
    private int size;


    public void put (int x) {
        Node newNode = new Node(x);
        if (tail == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public String get(){
        if (head==null) {
            return "error";
        }
        int data = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return String.valueOf(data);
    }

    public String getSize(){
        return String.valueOf(size);
    }

}
public class LinkedQueueSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfCommands = Integer.parseInt(reader.readLine());
        Queue qs = new Queue();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] s = reader.readLine().split(" ");
            if (s[0].equals("put")) {
                qs.put(Integer.parseInt(s[1]));
            } else if (s[0].equals("get")) {
                writer.write(qs.get());
                writer.newLine();
                writer.flush();
            } else if (s[0].equals("size")) {
                writer.write(qs.getSize());
                writer.newLine();
                writer.flush();
            }
        }

    }
}
