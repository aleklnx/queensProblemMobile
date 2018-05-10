package com.tec.alejo.queensproblem.queenalg;

import java.util.Observable;
import java.util.Observer;

public class Board extends Observable{

    private boolean[][] layout;

    Board(){
        layout = new boolean[8][8];
    }

    public boolean checkCollision(int i, int j){
        boolean collision = false;

        for(int index = 0; index < 8 && !collision; index ++){
            if(layout[i][index] & index != j){
                collision = true;
            }
        }

        for(int index = 0; index < 8 && !collision; index ++){
            if(layout[index][j] & index != i){
                collision = true;
            }
        }

        for(int i_ = i-1, j_ = j-1; i_ >= 0 && j_ >= 0 && !collision; i_--, j_--){
            if(layout[i_][j_]){
                collision = true;
            }
        }

        for(int i_ = i+1, j_ = j+1; i_ < 8 && j_ < 8 && !collision; i_++, j_++){
            if(layout[i_][j_]){
                collision = true;
            }
        }


        for(int i_ = i-1, j_ = j+1; i_ >= 0 && j_ < 8 && !collision; i_--, j_++){
            if(layout[i_][j_]){
                collision = true;
            }
        }


        for(int i_ = i+1, j_ = j-1; i_ < 8 && j_ >= 0 && !collision; i_++, j_--){
            if(layout[i_][j_]){
                collision = true;
            }
        }

        return collision;
    }

    public void addQueen(int i, int j) {
        layout[i][j] = true;
        printBoard();

    }

    public void removeQueen(int i, int j){
        layout[i][j] = false;
        printBoard();

    }

    public boolean[][] getLayout() {
        return layout.clone();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    public void printBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                if (layout[i][j]) {
                    System.out.print("[♛]\t");
                } else {
                    System.out.print("[ ]\t");
                }
            System.out.println("\n");
        }
        System.out.println("\n");
    }
}