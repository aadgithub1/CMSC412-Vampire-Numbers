public class Main {

    public static void main(String[] args) {
        //vampires: 102510, 105210, 105264
        //non-vampires: 100052, 101259, 104125

        int i;
        for(i = 1000; i < 10000; i++){
            int divisor;
            for(divisor = 2; divisor < i; divisor++){
                if (i % divisor == 0) {
                    int result = i / divisor;
                    String iStr = Integer.toString(i);
                    String divStr = Integer.toString(divisor);
                    String resStr = Integer.toString(result);

                    // ***ERROR CHECK*** System.out.println(iStr + " " + divStr + " " + resStr);

                    if (divStr.length() == resStr.length()) {
                        String[] divCharArray = divStr.split("");
                        String[] resCharArray = resStr.split("");
                        for(int k = 0; k < divStr.length(); k++){
                            if(!iStr.contains(divCharArray[k]) || !iStr.contains(resCharArray[k])){
                                //iStr = 5775
                                //divCharArray = ["7", "5"]
                                //resCharArry = ["7", "7"]
                                //we want to not strike a number when it is used
                                break;
                            }

                            if(k == divStr.length()-1){
                                System.out.println(i + " w/ fangs: " + divStr + " & " + resStr);
                            }
                        }
                    } else{
                        continue;
                    }
                } else{
                    continue;
                }
            }
        }
    }
}