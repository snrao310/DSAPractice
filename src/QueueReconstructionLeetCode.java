import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 9/30/2016.
 */
public class QueueReconstructionLeetCode {

    public static void main(String args[]){
        int people[][]={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int result[][]=new int[people.length][2];

        for(int i=0;i<result.length;i++){
            Arrays.fill(result[i],-1);
        }

        //sorting by first element and second in case of tie in first
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                }

                else if(o1[0]<o2[0]){
                    return -1;
                }

                else if(o1[1]>o2[1]){
                    return 1;
                }

                else if(o1[1]<o2[1]){
                    return -1;
                }

                return 0;
            }
        });

        for(int i=0;i<people.length;i++){
            int k=0;
            for(int j=0;j<people.length;j++){
                if(result[j][0]==-1 && k==people[i][1]){
                    result[j]=people[i];
                    break;
                }
                else if(result[j][0]==-1 || result[j][0]==people[i][0]){
                    k++;
                }
            }
        }

        for(int i=0;i<result.length;i++) {
           System.out.println(result[i][0] + " " + result[i][1]);
       }
    }
}
