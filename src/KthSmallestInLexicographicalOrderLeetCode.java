/**
 * Created by S N Rao on 3/22/2017.
 *
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 *
 * Note: 1 ≤ k ≤ n ≤ 109.
 *
 * Example:
 * Input:
 * n: 13   k: 2
 * Output:
 * 10
 *
 * Explanation:
 * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 *
 */
public class KthSmallestInLexicographicalOrderLeetCode {


    //To understand this draw a tree. 0 is the root. It has 9 children. We start from 1. From here, on each node has 10
    // children. 1 has 10 to 19, 2 has 20 to 29, 3 has 30 to 39, 10 has 100 to 109, 11 has 110 to 119, 20 has 200 to 209
    // and so on.
    //
    //Initially, you are at node 1 (variable: curr), the goal is move (k - 1) steps to the target node x.
    // (substract steps from k after moving) when k is down to 0, curr will be finally at node x, there you get the result.
    // we don't really need to do a exact k steps preorder traverse of the denary tree (10 children), the idea is to
    // calculate the steps between curr and curr + 1 (neighbor nodes in same level), in order to skip some unnecessary
    // moves.
    //
    // Main function
    // 1. Firstly, calculate how many steps curr need to move to curr + 1 using calcStep functions. Assume this function
    //    returns the answer in "steps" variable for now.
    // 2. if the steps <= k, we know we can move to curr + 1, and narrow down k to k - steps.
    // 3. else if the steps > k, that means the curr + 1 is actually ahead of the target node x in the preorder path, we
    //    can't jump to curr + 1. What we have to do is to move forward only 1 step in preorder i.e. to the leftmost child
    //    (curr * 10 is always next preorder node) and repeat the iteration.
    //
    //
    // calSteps function
    // how to calculate the steps between curr and curr + 1?
    // Idea is to calculate steps at each level.
    // n1 is the first node (leftmost) under cur in this level. n2 is first (leftmost) node under cur+1 in this level.
    // 1. Start with n1 = curr, n2 = curr + 1. For example, if cur=1, then at first iteration (level), n1=1, n2=2. At
    //    second level (iteration), n1=10, n2=20. At third level (iteration), n1=100, n2=200 and so on.
    // 2. if n2 <= n, this means all nodes from n1 to n2 are present in the sequence (even if not in this order) and must
    //    be added to steps. So add (n2 - n1) to steps.
    // 3. else if n2 > n, this means n (the biggest node) is on the path between n1 to n2, add (n + 1 - n1) to steps.
    // So basically, we are adding (Math.min(n + 1, n2) - n1) to  steps at each iteration till n1 becomes greater than n
    // And at each iteration we change n1 *= 10; n2 *= 10;
    //
    public static int findKthNumber(int n, int k) {
        int cur=1; k--;
        while(k>0){
            int steps=calculateSteps(cur, cur+1, n);
            if(steps<=k){
                k-=steps;
                cur=cur+1;
            }
            else{
                cur*=10;
                k=k-1;
            }
        }
        return cur;
    }

    private static int calculateSteps(long n1, long n2, int n){
        int steps=0;
        while (n1<=n){
            steps+=(Math.min(n2, n+1) - n1);
            n1*=10; n2*=10;
        }
        return steps;
    }

    public static void main(String args[]){
        System.out.print(findKthNumber(13,7));
    }
}
