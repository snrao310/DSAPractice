import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 1/17/2017.
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */
public class RestoreIPAddressLeetCode {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
        backTrackFunction(s,4,"",result);
        return result;
    }

    private static void backTrackFunction(String s,int parts,String temp,List<String> list){
        if(s.length()>parts*3) return;
        if(s.length()==0 && parts==0){
            list.add(temp.substring(0,temp.length()-1));
            return;
        }

        for(int i=0;i<3 && i<s.length();i++){
            String thisPart=s.substring(0,i+1);
            if(thisPart.charAt(0)=='0' && thisPart.length()>1) continue;
            if(Integer.parseInt(thisPart)>255) continue;
            String tempCopy=temp+thisPart+".";
            String remain=(i==s.length()-1)?"":s.substring(i+1);
            backTrackFunction(remain,parts-1,tempCopy,list);
        }
    }

    public static void main(String args[]){
        List<String> list= restoreIpAddresses("010010");
        for(String s: list){
            System.out.println(s);
        }
    }
}
