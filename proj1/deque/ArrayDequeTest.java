package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addandremoveTest(){
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(1);
        L.addLast(2);
        L.addLast(3);
        /*L.addFirst(2);
        L.addFirst(1);
        L.addFirst(0);
        L.addLast(3);
        L.addFirst(2);*/
        L.removeFirst();

    }
    @Test
    public void randomedTest(){
        ArrayDeque<Integer> L = new ArrayDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                System.out.println("addFirst(" + randVal + ")");
            } else if (operationNumber == 2) {
                if(L.size() > 0){
                    System.out.println("removeFirst(" + L.removeFirst() + ")");
                }
            } else if (operationNumber == 3) {
                if(L.size() > 0){
                    System.out.println("removeFirst(" + L.removeLast() + ")");
                }
            }
            else if (operationNumber == 4) {
                int randVal = StdRandom.uniform(0, 100);
                L.get(randVal);
                System.out.println("get(" + randVal + "):" + L.get(randVal));
            }
        }
    }
}
