package com.vladgstoian.matrix;

import java.util.Scanner;

/**
 * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands Example:
 * <p>
 * <p>
 * Input : mat[][] = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}} Output : 5 This is a variation of the standard problem: “Counting the
 * number of connected components in an undirected graph”.
 *
 * @author Vlad Stoian (msg DAVID GmbH)
 * @since 04/11/2021 06:40
 */
public class CountIslands
{
    public static void main(String[] args)
    {
        //        int matrix[][] = new int[][] {{1, 1, 0, 0, 0},
        //                                      {0, 1, 0, 0, 1},
        //                                      {1, 0, 0, 1, 1},
        //                                      {0, 0, 0, 0, 0},
        //                                      {1, 0, 1, 0, 1}};
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();

        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < columns; col++)
            {
                matrix[row][col] = in.nextInt();
            }
        }

        System.out.println(countIslands(matrix, rows, columns));
    }

    private static int countIslands(int[][] matrix, int rows, int columns)
    {
        int islands = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < columns; col++)
            {
                if (!visited[row][col] && matrix[row][col] == 1)
                {
                    traverseDFS(matrix, row, col, visited);
                    ++islands;
                }
            }
        }

        return islands;
    }

    private static int[] ROW_OFFSET = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] COL_OFFSET = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static void traverseDFS(int[][] matrix, int row, int col, boolean[][] visited)
    {
        visited[row][col] = true;
        for (int i = 0; i < 8; i++)
        {
            if (isSafe(matrix, row + ROW_OFFSET[i], col + COL_OFFSET[i], visited))
            {
                traverseDFS(matrix, row + ROW_OFFSET[i], col + COL_OFFSET[i], visited);
            }
        }
    }

    private static boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited)
    {
        if (row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length && (
                !visited[row][col] & matrix[row][col] == 1))
        {
            return true;
        }
        return false;
    }
}
