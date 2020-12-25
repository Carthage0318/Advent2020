import java.io.IOException;
import java.util.List;

public class Puzzle25 {
    public static void main(String[] args) throws IOException {
        List<String> input = CommonUtils.readInputToList();

        CommonUtils.printPartHeader(1);

        long cardPublicKey = Long.parseLong(input.get(0));
        long doorPublicKey = Long.parseLong(input.get(1));
        long cardLoopSize = loopSize(cardPublicKey, 7);
        long encryptionKey = transform(doorPublicKey, cardLoopSize);

        System.out.printf("Encryption Key = %d%n%n", encryptionKey);
    }

    private static long loopSize(long publicKey, long subject) {
        long count = 0;
        long value = 1;
        while (value != publicKey) {
            count++;
            value = (value * subject) % 20201227;
        }
        return count;
    }

    private static long transform(long subject, long loopSize) {
        long value = 1;
        while (loopSize > 0) {
            value = (value * subject) % 20201227;
            loopSize--;
        }
        return value;
    }
}
