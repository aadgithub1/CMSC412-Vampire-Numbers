public class Pseudo {
    public static void main(String[] args) {
        //vampires: 102510, 105210, 105264
        //non-vampires: 100052, 101259, 104125

        // int i;
        //for(i = 100_000; i < 1_000_000; i++){
            //divisor
            //for divisor = 2; divisor < i; divisor++
                //if i % divisor == 0
                    //result = i / divisor
                    //String divStr, resStr, iStr
                    //set them to the vars
                    //if divStr.len == resStr.len
                        //for each index position (k) from 0 to < len divStr
                            //if !iStr.contains(divStr[k]) || !iStr.contains(resStr[k])
                                //print not a vampire number
                                //break

                                //iStr = 5775
                                //iStrArray = iStr.toCharArray()
                                //iStrArray = ["5", "7", "7", "5"]
                                //divCharArray = ["7", "5"]
                                //resCharArry = ["7", "7"]

                                //we want to not strike a number when it is used

                                    //see if divCharArray[0] is in iStrArray
                                    //if so remove divCharArray[0] from iStrArray
                                    //if not exit loop continue to next divisor

                                    //see if resCharArray[0] is in iStrArray
                                    //if so remove resCharArray[0] from iStrArray
                                    //if not exit loop continue to next divisor

                                    //repeat with index 1
                                    //if still in loop and index = divStr - 1
                                        //print i is a vamp w fangs divisor and result

                            //if k len divstr - 1
                                //print i is a vampire number

                    //else continue
                //else continue
        // }
    }
}
