/**
 * Created by S N Rao on 4/21/2017.
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 */
public class AddBinaryLeetCode {

    public static String addBinary(String a, String b) {
        char[] aSt=a.toCharArray();
        char[] bSt=b.toCharArray();
        int alen=a.length(), blen=b.length(), len=Math.max(alen,blen), aPointer=alen-1, bPointer=blen-1, carry=0;
        char[] res=new char[len+1];

        for(int i=len;i>=0;i--){
            int aNum=0,bNum=0;
            if(aPointer>=0) aNum=(aSt[aPointer--]=='1')?1:0;
            if(bPointer>=0) bNum=(bSt[bPointer--]=='1')?1:0;
            int Num=aNum+bNum+carry;
            if(Num>1){
                res[i]=(char)(Num-2+'0');
                carry=1;
            }
            else{
                res[i]=(char)(Num+'0');
                carry=0;
            }
        }

        String result=new String(res);
        if(res[0]=='1') return result;
        else return result.substring(1);

    }

    public static void main(String args[]){
        System.out.print(addBinary("111","111")); //1110
    }
}
