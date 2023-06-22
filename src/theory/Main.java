package theory;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static byte[] intToByteArray(int value) {
        return new byte[]{
                (byte) value,
                (byte) (value >> 8),
                (byte) (value >> 16),
                (byte) (value >> 24)
        };

    }

    public static void main(String[] args) throws IOException {
        int a = 192;
        byte[] res = intToByteArray(a);
        System.out.println(Arrays.toString(res));
        System.out.println((byte) (192));
    }

}
