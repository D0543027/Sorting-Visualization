package SortingVisualization;

import SortingAlgo.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Visualize {
    private JFrame window;
    private SortArray sortArray;
    private ArrayList<Sort> sortList;
    public Visualize(){
        window = new JFrame("Sorting Visualization");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sortArray = new SortArray();
        window.add(sortArray);
        window.pack();
        window.setVisible(true);

        sortList = new ArrayList<>();
        sortList.add(new SelectionSort());
        sortList.add(new BubbleSort());
        sortList.add(new InsertionSort());
        sortList.add(new MergeSort());
        sortList.add(new QuickSort());
    }

    private void shuffle(){
        sortArray.shuffle();
        sortArray.resetColor();
        Sleep.sleepFor(Sleep.millisecToNano(2000));
    }

    public void run(){
        for(Sort s: sortList){
            sortArray.setLabelText("Shuffling...");
            Sleep.sleepFor(Sleep.millisecToNano(1000));
            shuffle();
            sortArray.setLabelText(s.getName());
            s.sort(sortArray);
            //System.out.println("DONE");

            sortArray.resetColor();
            sortArray.highlight();
            sortArray.resetColor();
        }
    }
}
