package tc;

/**
 * Created by dasg on 07-03-2017.
 */
public class GreatestNumber {
    static String input = "324566.546";

    public static void main(String[] args) {
        boolean flag =false;
        if(input.contains("-"))flag =true;
        input =  input.replaceAll("\\-","");
      //  input =  input.replaceAll("\\.","");
        String[] inputstring = input.split("\\.");
        char[] left = getMaxPossibleNumber(inputstring[0],flag);
        char[] right = getMaxPossibleNumber(inputstring[1],flag);
        if(flag){
            System.out.println("-"+String.valueOf(left)+"."+String.valueOf(right));
        }else{
            System.out.println(String.valueOf(left)+"."+String.valueOf(right));
        }

    }

    private static char[] getMaxPossibleNumber(String input,boolean flag) {
        char [] left = input.toCharArray();
        if(flag==true){
           for(int i=0;i<left.length -1;i++){
               char greater = left[i];
               for( int j = i+1;j<left.length;j++){
                   if(greater>left[j]){
                       greater = left[j];
                       char temp = left[i];
                       left[i]=left[j];
                       left[j]=temp;
                   }
               }

           }
       }else{
           for(int i=0;i<left.length - 1;i++){
               char greater = left[i];
               for( int j = i+1;j<left.length;j++){
                   if(greater<left[j]){
                       greater = left[j];
                       char temp = left[i];
                       left[i]=left[j];
                       left[j]=temp;
                   }
               }
           }
       }
        return left;
    }

}
