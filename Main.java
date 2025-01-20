import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //vampires: 102510, 105210, 105264
        //non-vampires: 100052, 101259, 104125
        int i;
        for(i = 100000; i < 1000000; i++){
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
}