package SortingVisualization;

public class Sleep {
    public static void sleepFor(long nsec){
        long elapsed;
        final long startTime = System.nanoTime();

        do{
            elapsed = System.nanoTime() - startTime;
        } while(elapsed < nsec);
    }

    public static long millisecToNano(long time){
        return time * (long)Math.pow(10, 6);
    }
}
