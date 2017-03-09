/**
 * Created by S N Rao on 3/9/2017.
 *
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 */
public class CandyLeetCode {

    // This solution picks each element from the input array only once. First, we give a candy to the first child.
    // Then for each child we have three cases:
    //      His/her rating is equal to the previous one -> give 1 candy.
    //      His/her rating is greater than the previous one -> give him (previous + 1) candies.
    //      His/her rating is less than the previous one -> find the length of decreasing sequence and decide so that the last
    //          one in the sequence gets 1 candy.
    //
    public static int candy(int[] ratings) {
        int end=1,len=ratings.length,prevCandy=1,res=1;
        while(end<len){
            if(ratings[end-1]<ratings[end]) {
                res+=(prevCandy+1); prevCandy++;
            }
            else if(ratings[end-1]==ratings[end]) {
                res+=1; prevCandy=1;
            }
            else{
                int count=1;
                while(end<len && ratings[end-1]>ratings[end]) {
                    count++; end++;
                }
                if(prevCandy<count) res-=prevCandy;
                else count--;
                res+=(count*(count+1)/2);
                prevCandy=1;end--;
            }
            end++;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(candy(new int[]{3,2,5,6,7,3,2,4}));
    }
}
