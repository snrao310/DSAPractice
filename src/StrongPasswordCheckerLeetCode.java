import java.util.HashMap;

/**
 * Created by S N Rao on 3/28/2017.
 *
 * A password is considered strong if below conditions are all met:
 *
 * It has at least 6 characters and at most 20 characters.
 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming
 * other conditions are met).
 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to
 * make s a strong password. If s is already strong, return 0.
 *
 * Insertion, deletion or replace of any one character are all considered as one change.
 *
 */
public class StrongPasswordCheckerLeetCode {

    //Hardest question on leetcode so far encountered.
    //Explanation from discussion forum pasted below this class. Comments also pasted from discussion forum code.
    public static int strongPasswordChecker(String s) {
        int needUpper=1,needLower=1,needDigit=1,toAdd=0,toDelete=0,toReplace=0;
        int deleteTarget=Math.max(0,s.length()-20), addTarget=Math.max(0,6-s.length());

        ///////////////////////////////////
        // For cases of s.length() <= 20 //
        ///////////////////////////////////
        for(int l=0,r=0;r<s.length();r++){
            if(Character.isLowerCase(s.charAt(r))) needLower=0;
            if(Character.isUpperCase(s.charAt(r))) needUpper=0;
            if(Character.isDigit(s.charAt(r))) needDigit=0;

            if(r-l==2){                                                        // if it's a three-letter window
                if(s.charAt(l)==s.charAt(l+1) && s.charAt(l+1)==s.charAt(r)){  // found a three-repeating substr
                    if(addTarget>toAdd) {toAdd++; l=r;}                        // insert letter to break repetition if possible
                    else {toReplace++;l=r+1;}                                  // replace current word to avoid three repeating chars
                }                                                              // keep the window with no more than 3 letters
                else
                    l++;
            }
        }
        if(s.length()<=20) return Math.max(addTarget+toReplace, needDigit+needLower+needUpper);


        //////////////////////////////////
        // For cases of s.length() > 20 //
        //////////////////////////////////
        toReplace=0;                                            // reset toReplace
        HashMap<Integer,Integer>[] lenCounts=new HashMap[3];    // to record repetitions with (length % 3) == 0, 1 or 2
        for(int i=0;i<3;i++) lenCounts[i]=new HashMap<>();
        for(int l=0,r=0;r<=s.length();r++){                     // record all repetion frequencies
            if(r==s.length() || s.charAt(r)!=s.charAt(l)){
                if(r-l>2) {                                     // we only care about repetions with length >= 3
                    int prevVal=lenCounts[(r-l)%3].getOrDefault(r-l,0);
                    lenCounts[(r - l) % 3].put(r - l, prevVal + 1);
                }
                l=r;
            }
        }

        /*
            Use deletions to minimize replacements, following below orders:
            (1) Try to delete one letter from repetitions with (length % 3) == 0. Each deletion decreases replacement by 1
            (2) Try to delete two letters from repetitions with (length % 3) == 1. Each deletion decreases repalcement by 1
            (3) Try to delete multiple of three letters from repetions with (length % 3) == 2. Each deletion (of three
            letters) decreases repalcements by 1
        */
        for(int i=0;i<3;i++){
            for(int j:lenCounts[i].keySet()){
                if(i<2){
                    int numLetters=i+1;
                    int dec=Math.min(lenCounts[i].get(j),(deleteTarget-toDelete)/numLetters);   // dec is the number of
                    int prevVal=lenCounts[i].get(j);                                            //repetitions we'll delete from
                    lenCounts[i].put(j,prevVal-dec);    // update number of repetitions left
                    toDelete+=dec*numLetters;

                    // after letters deleted, it fits in the group where (length % 3) == 2
                    if(j-numLetters>2) {
                        prevVal=lenCounts[2].getOrDefault(j-numLetters,0);
                        lenCounts[2].put(j - numLetters, prevVal + dec);
                    }
                }

                // record number of replacements needed
                // note if len is the length of repetition, we need (len / 3) number of replacements
                toReplace+=(j/3)*lenCounts[i].get(j);
            }
        }
        int dec=(deleteTarget-toDelete)/3;  // try to delete multiple of three letters as many as possible
        toReplace-=dec; toDelete+=dec*3;
        return deleteTarget+Math.max(toReplace,needDigit+needLower+needUpper);
    }

    public static void main(String args[]){
        System.out.println(strongPasswordChecker("aaAA11"));
    }
}

/*
I've separated the problem into three cases:
(1) s.length() < 6
(2) 6 <= s.length() <= 20
(3) s.length() > 20

Let's look at case (1) first. If s.length() < 6, we know we have room to insert some more letters into s. Question is
how to use the insertions effectively to reduce the number of potential replacements. I'm using a greedy approach for
this one: I'm inserting one char between the second and third chars whenever I see a repetition of 3 letters as substring.

e.g. Say we have room to insert some chars in string and we see a substring of "aaaa". I'll insert a 'B' to make it
"aaBaa" to break the 3-char repetition, thus reducing potential replacement by 1. And we'll do this until we can't
insert any more chars into s. When we reach this point, we'll start dealing with case (2)

For case (2), I still follow a greedy approach. I'm simply searching for 3-char repetitions, and replacing one of the
chars to break the repetition.
e.g. If we see a substring of "aaaa", we'll make it "aaBa".

My code deals with (1) and (2) together as s.length() <= 20.

Case (3) is a little bit tricky because simple greedy doesn't work any more.
When s.length() > 20, we want to delete some chars instead of inserting chars to reduce potential replacements. Question
is the same: how to do it effectively? Let's do some observations here:

Say len is the length of each repetition.
(a) len % 3 only has three possible values, namely 0, 1 and 2.
(b) Minimum number of replacements needed to break each repetition is len / 3.
(c) Based on (a) and (b), we know that deletion can reduce replacements only if the deletion can change the value of
len / 3
(d) Based on (c), we know if we want to reduce 1 replacement, we need 1 deletion for len % 3 == 0, and 2 deletions for
len % 3 == 1, and 3 deletions for len % 3 == 2.

Given above observations, I simply implemented the solution to do (d).

Also note that missing of upper case char, lower case char, or digit can always be resolved by insertion or replacement.
 */
