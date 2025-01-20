public class Main {

    public static void main(String[] args) {
        //vampires: 102510, 105210, 105264
        //non-vampires: 100052, 101259, 104125
        Worker thread = new Worker(true);
        Worker thread2 = new Worker(false);

        thread.start();
        long t1Start = System.currentTimeMillis();
        thread2.start();

        try{
            thread.join();
            thread2.join();
            long end = System.currentTimeMillis();
            System.out.println("time: " + (end - t1Start));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}