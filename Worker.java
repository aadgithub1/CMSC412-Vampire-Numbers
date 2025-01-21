import java.util.ArrayList;
import java.util.Arrays;

public class Worker extends Thread{
    public boolean isEven;
    public int vampireCounter = 0;
    
    public Worker(boolean isEven){
        //if true this worker evaluates only even numbers
        this.isEven = isEven;
    }

    public void run(){
        int i;
        for(i = 100000; i < 1000000; i++){ //nums in range 100,000-1,000,000
            if(i % 2 == 0 && isEven){
                //eval even numbers in even worker
                findVampireNumbers(i);
            } else if(i % 2 == 1 && !isEven){
                //eval odd numbers in odd worker
                findVampireNumbers(i);
            }
        }
    }

    //test for vampire number; pseudocode/comments in resources/Pseudo.java
    public void findVampireNumbers(int i){
        int divisor;
        for(divisor = 100; divisor < 1000; divisor++){ //factors have to be 3
            boolean isVampire = false;
            if (i % divisor == 0) {
                //if evenly divisible, store result so we have both factors
                int result = i / divisor;
                String iStr = Integer.toString(i); //num we are evaluating
                String divStr = Integer.toString(divisor); //current divisor
                String resStr = Integer.toString(result); //other factor
                if (divStr.length() == resStr.length()) {
                    String[] divCharArray = divStr.split("");
                    String[] resCharArray = resStr.split("");

                    //make an ArrayList from the current # being evaluated
                    ArrayList<String> iStrArrayList =
                    new ArrayList<>(Arrays.asList(iStr.split("")));

                    for(int k = 0; k < divStr.length(); k++){
                        //remove digits so a digit cannot be used multiple
                        //times; each digit can be used only once
                        if(iStrArrayList.contains(divCharArray[k])){
                            iStrArrayList.remove(divCharArray[k]);
                            if(iStrArrayList.contains(resCharArray[k])){
                                iStrArrayList.remove(resCharArray[k]);
                            } else{
                                break;
                            }
                        } else{
                            break;
                        }

                        //if we are at the end of the divisor String (i.e. if
                        //we have matched and removed 6 digits)
                        if(k == divStr.length()-1){
                            //no double trailing zeroes
                            if(divStr.endsWith("0") &&
                            resStr.endsWith("0")){
                                break;
                            }
                            //report vampire number and its fangs
                            if(isEven){
                                System.out.println("Even worker found " +
                                i + " w/ fangs: " + divStr + " & " + resStr);
                            } else if(!isEven){
                                System.out.println("Odd worker found " +
                                i + " w/ fangs: " + divStr + " & " + resStr);
                            }
                            //increment number of vampires found by this worker
                            vampireCounter++;
                            isVampire = true;
                        }
                    }
                } else{
                    continue;
                }
                //stop looking if number being evaluated is already vampire
                if(isVampire){
                    break;
                }
            } else{
                //current number is not evenly divisible by divisor
                continue;
            }
        }
    }
}
