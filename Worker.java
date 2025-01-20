import java.util.ArrayList;
import java.util.Arrays;

public class Worker extends Thread{
    boolean isEven;
    
    public Worker(boolean isEven){
        this.isEven = isEven;
    }

    public void run(){
        int i;
        for(i = 100000; i < 1000000; i++){
            if(i % 2 == 0 && isEven){
                findVampireNumbers(i);
            } else if(i % 2 == 1 && !isEven){
                findVampireNumbers(i);
            }
        }
    }

    static void findVampireNumbers(int i){
        int divisor;
        for(divisor = 100; divisor < 1000; divisor++){
            boolean isVampire = false;
            if (i % divisor == 0) {
                int result = i / divisor;
                String iStr = Integer.toString(i);
                String divStr = Integer.toString(divisor);
                String resStr = Integer.toString(result);
                if (divStr.length() == resStr.length()) {
                    String[] divCharArray = divStr.split("");
                    String[] resCharArray = resStr.split("");
                    ArrayList<String> iStrArrayList = new ArrayList<>(Arrays.asList(iStr.split("")));
                    for(int k = 0; k < divStr.length(); k++){
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

                        if(k == divStr.length()-1){
                            if(divStr.endsWith("0") && resStr.endsWith("0")){
                                break;
                            }
                            System.out.println(i + " w/ fangs: " + divStr + " & " + resStr);
                            isVampire = true;
                        }
                    }
                } else{
                    continue;
                }
                if(isVampire){
                    break;
                }
            } else{
                continue;
            }
        }
    }
}
