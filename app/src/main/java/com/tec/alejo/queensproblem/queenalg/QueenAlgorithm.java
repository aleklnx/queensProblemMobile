package com.tec.alejo.queensproblem.queenalg;

public class QueenAlgorithm {

    public Board board;
    public LinkedList<boolean[][]> list;

    public QueenAlgorithm(){
        board = new Board();
        list = new LinkedList<>();
    }

    public com.tec.alejo.queensproblem.queenalg.LinkedList<boolean[][]> resolve(){
        resolve(0);
        return list;
    }

    private void resolve(int i){
        if(i > 7){
            return;
        }

        for(int j = 0; j < 8; j++){
            board.addQueen(i, j);
            list.add(board.getLayout());
            if(!board.checkCollision(i, j)){
                resolve(i+1);
            }
            board.removeQueen(i,j);
            list.add(board.getLayout());
        }


    }

}
