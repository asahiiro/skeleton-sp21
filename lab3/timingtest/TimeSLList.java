package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
            AList<Integer> ns = new AList<Integer>();
            AList<Integer> op = new AList<Integer>();
            AList<Double> times = new AList<Double>();
            for(int i = 2;i<=128;i*=2){
                ns.addLast(1000*i);
                op.addLast(10000);
            }
            int s = ns.size();
            for(int i = 0;i < s;i++){
                int size = ns.get(i);
                SLList<Integer> n = new SLList<Integer>();
                for(int j = 0;j < size;j++){
                    n.addLast(1);
                }
                Stopwatch sw = new Stopwatch();
                for(int j = 0;j < 10000;j++){
                    n.getLast();
                }
                times.addLast(sw.elapsedTime());
            }
            printTimingTable(ns,times,op);
    }

}
