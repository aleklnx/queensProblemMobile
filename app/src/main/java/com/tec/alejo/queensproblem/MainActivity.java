package com.tec.alejo.queensproblem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.tec.alejo.queensproblem.queenalg.QueenAlgorithm;
import com.tec.alejo.queensproblem.queenalg.nQueens;

import java.util.LinkedList;

public class MainActivity extends Activity {

    java.util.LinkedList<ImageAdapter> solInExecution = new java.util.LinkedList<ImageAdapter>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = findViewById(R.id.imagesGrid);
        ListView list = findViewById(R.id.solutionList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            grid.setAdapter(solInExecution.get(position));
        });

        QueenAlgorithm queens = new QueenAlgorithm();



        java.util.LinkedList<int[][]> solArrays = new LinkedList<>();

        for(int sol = 0; sol<solArrays.size(); sol++){
            solInExecution.add(new ImageAdapter(solArrays.get(sol), this));
            adapter.add("Step " + sol);
        }
    }
}