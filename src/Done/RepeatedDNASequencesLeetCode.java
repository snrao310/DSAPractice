package Done;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by snrao on 12/30/16.
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA
 * molecule.
 *
 */
public class RepeatedDNASequencesLeetCode {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        HashSet<String> added=new HashSet<>();
        for(int i=0;i<s.length()-9;i++){
            String sub=s.substring(i,i+10);
            if(set.contains(sub)) {
                if(!added.contains(sub)) {
                    added.add(sub);
                    result.add(sub);
                }
            }
            else set.add(sub);
        }
        return result;
    }

    public static void main(String args[]){
        List<String> list=findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for(String s:list)
            System.out.println(s);
    }
}
