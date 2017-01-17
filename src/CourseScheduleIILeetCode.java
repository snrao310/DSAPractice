import java.util.Stack;

/**
 * Created by S N Rao on 1/17/2017.
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to
 * finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses,
 * return an empty array.
 *
 */
public class CourseScheduleIILeetCode {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //Make adjacency matrix
        boolean[][] adjMat=new boolean[numCourses][numCourses];
        int m=prerequisites.length;
        for(int i=0;i<m;i++)
            adjMat[prerequisites[i][1]][prerequisites[i][0]]=true;
        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(DFS(adjMat,i,visited,new boolean[numCourses],stack))
                    return new int[]{};
            }
        }
        int[] res=new int[numCourses];
        int i=0;
        while(!stack.empty()){
            res[i]=stack.pop();
            i++;
        }
        return res;
    }

    private static boolean DFS(boolean[][] adjMat,int node,boolean[] visited,boolean[] traversed, Stack<Integer> stack){
        if(traversed[node]) return true;
        if(visited[node]) return false;

        traversed[node]=true;
        for(int i=0;i<adjMat.length;i++){
            if(adjMat[node][i])
                if(DFS(adjMat,i,visited,traversed,stack))
                    return true;
        }
        traversed[node]=false;
        visited[node]=true;
        stack.push(node);
        return false;
    }


    public static void main(String args[]){
        int[] res=findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for(int i:res)
            System.out.print(i+" ");
    }
}
