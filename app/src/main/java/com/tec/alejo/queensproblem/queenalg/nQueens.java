package com.tec.alejo.queensproblem.queenalg;
import java.util.Scanner;
import java.util.LinkedList;

public class nQueens {

    static Scanner scan;
    static int N = 0;
    static LinkedList<int[][]> result = new LinkedList<>();

    private void printBoard(int board[][]) {
        int i;
        for (i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (board[i][j] == 1) {
                    System.out.print("[♛]\t");
                } else {
                    System.out.print("[ ]\t");
                }
            System.out.println("\n");
        }
    }

    private boolean checkAttack(int board[][], int row, int col) {
        int i, j;

        //left
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        //top left
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        //bottom left
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }


    private boolean backtrack(int board[][], int col) {
        if (col >= N)
            return true;
        for (int i = 0; i < N; i++) {
            if (checkAttack(board, i, col)) {
                board[i][col] = 1;

                int[][] toAdd = new int[8][8];

                System.arraycopy(board, 0, toAdd, 0, board.length);

                printBoard(board);
                result.add(toAdd);
                System.out.println("Step added to result.\n");
                System.out.println("------------------------------------------------------");

                if (backtrack(board, col + 1))
                    return true;
                // Backtracking is hella important in this one.
                board[i][col] = 0;

            }

        }
        return false;
    }


    public LinkedList<int[][]> start(int n){
        N = n;

        int[][] board = new int[N][N];
        if (!backtrack(board, 0)) {
            System.out.println("Solution not found.");
        }
        printBoard(board);

        return result;
    }

}
