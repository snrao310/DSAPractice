/**
 * Created by snrao on 12/10/16.
 *
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the
 * digits in ascending order.
 */
public class ReconstructOriginalDigitsLeetCode {

    public static String originalDigits(String s) {
        String result=new String();
        int count[]=new int[10];

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='z') count[0]++;
            else if(c=='w') count[2]++;
            else if(c=='u') count[4]++;
            else if(c=='x') count[6]++;
            else if(c=='g') count[8]++;

            else if(c=='o') count[1]++;
            else if(c=='h') count[3]++;
            else if(c=='f') count[5]++;
            else if(c=='s') count[7]++;
            else if(c=='i') count[9]++;
        }
        count[1]-=(count[2]+count[0]+count[4]);
        count[3]-=count[8];
        count[5]-=count[4];
        count[7]-=count[6];
        count[9]-=(count[5]+count[6]+count[8]);


        for(int i=0;i<10;i++){
            if(count[i]!=0){
                for(int j=0;j<count[i];j++)
                    result+=i;
            }
        }

        return result;
    }

    public static void main(String args[]){
        String a="zeroneozoneertowo";
        System.out.print(originalDigits(a));
    }
}
