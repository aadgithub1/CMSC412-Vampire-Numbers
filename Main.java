public class Main {
    public static void main(String[] args) {
        Worker thread = new Worker(true); //evaluates even numbers
        Worker thread2 = new Worker(false); //evaluates odd numbers

        thread.start();
        thread2.start();

        try{
            //wait for the threads to complete
            thread.join();
            thread2.join();

            //print individual and total number of vampire numbers
            System.out.println("Even worker found " +
            thread.vampireCounter +
            " vampire numbers.");

            System.out.println("Odd worker found " +
            thread2.vampireCounter +
            " vampire numbers.");

            System.out.println(
            "There are " +
            (thread.vampireCounter + thread2.vampireCounter) +
            " total vampire numbers.");

        } catch(Exception e){
            e.printStackTrace(); //catch interrupt
        }
    }
}