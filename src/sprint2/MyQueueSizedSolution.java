package sprint2;

import java.io.*;

/**
 * @author valeriali on {19.06.2023}
 * @project algorithms
 */

class QueueSized {
    private final int[] queue;
    private final int capacity;
    private int head;
    private int tail;
    private int size;

    public QueueSized(int capacity){
        this.queue = new int[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void push(int x) {
        if (this.size != this.capacity){
            this.queue[this.tail] = x;
            this.tail = (this.tail + 1) % this.capacity;
            this.size ++;
        } else System.out.println("error");
        System.out.print("");
    }

    public String pop() {
        if (this.isEmpty()) {
            return "None";
        }
        int x = this.queue[this.head];
        this.queue[this.head] = 0;
        this.head = (this.head + 1) % this.capacity;
        this.size--;
        return String.valueOf(x);

    }

    public String peek(){
        if (this.isEmpty()){
            return "None";
        } else {
            return String.valueOf(this.queue[head]);
        }
    }

    public int getSize(){
        return this.size;
    }
}
public class MyQueueSizedSolution  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfCommands = Integer.parseInt(reader.readLine());
        int capacity = Integer.parseInt(reader.readLine());
        QueueSized qs = new QueueSized(capacity);

        for (int i = 0; i < numberOfCommands; i++) {
            String[] s = reader.readLine().split(" ");
            if (s[0].equals("peek")) {
                writer.write(qs.peek());
                writer.newLine();
                writer.flush();
            } else if (s[0].equals("push")) {
                qs.push(Integer.parseInt(s[1]));
            } else if (s[0].equals("size")) {
                writer.write(Integer.toString(qs.getSize()));
                writer.newLine();
                writer.flush();
            } else if (s[0].equals("pop")) {
                writer.write(qs.pop());
                writer.newLine();
                writer.flush();
            }
        }

//        writer.flush();
    }
}
