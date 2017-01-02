/**
 * Created by snrao on 1/2/17.
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its
 * next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 */
public class GasStationLeetCode {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas=0,sumCost=0,start=0,tank=0;
        for(int i=0;i<gas.length;i++){
            sumGas+=gas[i];
            sumCost+=cost[i];
            tank+=gas[i]-cost[i];
            if(tank<0){
                tank=0;
                start=i+1;
            }
        }

        if(sumGas<sumCost) return -1;
        return start;
    }

    public static void main(String args[]){
        System.out.print(canCompleteCircuit(new int[]{},new int[]{}));
    }
}
