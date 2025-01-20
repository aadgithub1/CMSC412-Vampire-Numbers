public class Main {

    public static void main(String[] args) {
        //vampires: 102510, 105210, 105264
        //non-vampires: 100052, 101259, 104125
        Worker thread = new Worker(true);
        Worker thread2 = new Worker(false);

        thread.start();
        thread2.start();

        try{
            thread.join();
            thread2.join();

            System.out.println(
            "There are " +
            (thread.vampireCounter + thread2.vampireCounter) +
            " total vampire numbers.");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}