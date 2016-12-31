/**
 * Created by snrao on 12/30/16.
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all
 * courses?
 *
 */
public class CourseScheduleLeetCode {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;
        if(numCourses==1) return true;
        //create graph
        boolean[][] adjMat=new boolean[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adjMat[prerequisites[i][1]][prerequisites[i][0]]=true;
        }

        boolean visited[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]) continue;
            if(dfsCycleFind(adjMat,visited,new boolean[numCourses],i))
                return false;
        }
        return true;
    }

    private static boolean dfsCycleFind(boolean[][] adjMat, boolean[] visited, boolean[] traversed, int i){
        if(traversed[i]) return true;   //visited in this dfs check stack. this means cycle.
        if(visited[i]) return false;    //visited in previous dfs check. no cycle from here.

        traversed[i]=true;
        visited[i]=true;

        for (int j=0;j<adjMat[i].length;j++){
            if(adjMat[i][j])
                if(dfsCycleFind(adjMat,visited,traversed,j))
                    return true;
        }
        traversed[i]=false;
        return false;
    }

    public static void main(String args[]){
        System.out.println(canFinish(2,new int[][]{{1,0}}));
        System.out.println(canFinish(2,new int[][]{{1,0},{0,1}}));
    }
}
