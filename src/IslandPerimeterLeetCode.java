/**
 * Created by S N Rao on 2/13/2017.
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and
 * there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside
 * that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular,
 * width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 */
public class IslandPerimeterLeetCode {

    public static int islandPerimeter(int[][] grid) {
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int newi = i + d[0];
                        int newj = j + d[1];
                        if (newi<0 || newj<0 || newi>=grid.length || newj>=grid[0].length || grid[newi][newj]==0)
                            perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][] { { 0, 1, 0, 0 },
                { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
    }
}
