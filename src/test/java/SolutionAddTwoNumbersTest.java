import org.junit.jupiter.api.Test;
import ru.borovikov.SolutionAddTwoNumbers;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionAddTwoNumbersTest {

    @Test
    public void benchmarkAddTwoNumbersMethods() {
        int size = 1_000_000;
        SolutionAddTwoNumbers.ListNode l1 = buildList(size, 9);
        SolutionAddTwoNumbers.ListNode l2 = buildList(size, 1);

        long startMySolve = System.currentTimeMillis();
//        try {
//            SolutionAddTwoNumbers.ListNode result1 = SolutionAddTwoNumbers.addTwoNumbersMySolve(l1, l2);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getClass().getSimpleName());
//        }
        long endMySolve = System.currentTimeMillis();
        System.out.println("addTwoNumbersMySolve time: " + (endMySolve - startMySolve) + "ms");

        l1 = buildList(size, 9); // пересоздать списки, т.к. они модифицируются
        l2 = buildList(size, 1);

        long startBestSolve = System.currentTimeMillis();
        SolutionAddTwoNumbers.ListNode result2 = SolutionAddTwoNumbers.addTwoNumbersTheBestSolve(l1, l2);
        long endBestSolve = System.currentTimeMillis();
        System.out.println("addTwoNumbersTheBestSolve time: " + (endBestSolve - startBestSolve) + "ms");

        l1 = buildList(size, 9); // пересоздать списки, т.к. они модифицируются
        l2 = buildList(size, 1);

        long startGptSolve = System.currentTimeMillis();
        SolutionAddTwoNumbers.ListNode result3 = SolutionAddTwoNumbers.addTwoNumbersWithGptRecommended(l1, l2);
        long endGptSolve = System.currentTimeMillis();
        System.out.println("addTwoNumbersTheBestSolve time: " + (endGptSolve - startGptSolve) + "ms");

        assertEquals(0, result3.getVal()); // 9+1=10, значит остаток 0
        while (result3.getNext() != null) {
            result3 = result3.getNext();
        }
        assertEquals(1, result3.getVal()); // перенос в старший разряд
    }


    @Test
    public void testAddTwoNumbers_GptRecommended() {
        SolutionAddTwoNumbers.ListNode l1 = buildList(new int[]{2, 4, 3});
        SolutionAddTwoNumbers.ListNode l2 = buildList(new int[]{5, 6, 4});
        SolutionAddTwoNumbers.ListNode result = SolutionAddTwoNumbers.addTwoNumbersMySolve(l1, l2);
        assertArrayEquals(new int[]{7, 0, 8}, toArray(result));
    }

    @Test
    public void testAddTwoNumbers_MySolve() {
        SolutionAddTwoNumbers.ListNode l1 = buildList(new int[]{2, 4, 3});
        SolutionAddTwoNumbers.ListNode l2 = buildList(new int[]{5, 6, 4});
        SolutionAddTwoNumbers.ListNode result = SolutionAddTwoNumbers.addTwoNumbersMySolve(l1, l2);
        assertArrayEquals(new int[]{7, 0, 8}, toArray(result));
    }

    @Test
    public void testAddTwoNumbers_TheBestSolve() {
        SolutionAddTwoNumbers.ListNode l1 = buildList(new int[]{2, 4, 3});
        SolutionAddTwoNumbers.ListNode l2 = buildList(new int[]{5, 6, 4});
        SolutionAddTwoNumbers.ListNode result = SolutionAddTwoNumbers.addTwoNumbersTheBestSolve(l1, l2);
        assertArrayEquals(new int[]{7, 0, 8}, toArray(result));
    }

    private SolutionAddTwoNumbers.ListNode buildList(int count, int value) {
        SolutionAddTwoNumbers.ListNode dummy = new SolutionAddTwoNumbers.ListNode(0);
        SolutionAddTwoNumbers.ListNode current = dummy;
        for (int i = 0; i < count; i++) {
            current.setNext(new SolutionAddTwoNumbers.ListNode(value));
            current = current.getNext();
        }
        return dummy.getNext();
    }

    private SolutionAddTwoNumbers.ListNode buildList(int[] values) {
        SolutionAddTwoNumbers.ListNode dummy = new SolutionAddTwoNumbers.ListNode(0);
        SolutionAddTwoNumbers.ListNode current = dummy;
        for (int val : values) {
            current.setNext(new SolutionAddTwoNumbers.ListNode(val));
            current = current.getNext();
        }
        return dummy.getNext();
    }

    private int[] toArray(SolutionAddTwoNumbers.ListNode node) {
        int[] tmp = new int[100];
        int i = 0;
        while (node != null) {
            tmp[i++] = node.getVal();
            node = node.getNext();
        }
        int[] result = new int[i];
        System.arraycopy(tmp, 0, result, 0, i);
        return result;
    }
}
