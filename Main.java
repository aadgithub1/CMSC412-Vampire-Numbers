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
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}