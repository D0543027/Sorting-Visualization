package SortingVisualization;

import SortingAlgo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

public class Visualize {
    private JFrame window;
    private JButton btn_SelectionSort;
    private JButton btn_BubbleSort;
    private JButton btn_InsertionSort;
    private JButton btn_MergeSort;
    private JButton btn_QuickSort;

    private SortArray sortArray;
    private Semaphore semaphore = new Semaphore(1); // Preventing from multiple buttons click
    public Visualize(){

        window = new JFrame("Sorting Visualization");
       //window.setSize(1280, 800);
        window.setPreferredSize(new Dimension(1280, 900));
        window.setMaximumSize(new Dimension(1280, 900));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setLocationRelativeTo(null);


        sortArray = new SortArray();
        window.add(sortArray);

        btn_SelectionSort = new JButton("Selection Sort");
        btn_SelectionSort.setBounds(850, 200, 150, 50);
        btn_SelectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            semaphore.acquire();
                            sorting(new SelectionSort());
                            semaphore.release();
                        } catch(Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                });
                t.start();

            }
        });

        btn_BubbleSort = new JButton("Bubble Sort");
        btn_BubbleSort.setBounds(850, 300, 150, 50);
        btn_BubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            semaphore.acquire();
                            sorting(new BubbleSort());
                            semaphore.release();
                        } catch(Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                });
                t.start();
            }
        });

        btn_InsertionSort = new JButton("Insertion Sort");
        btn_InsertionSort.setBounds(850, 400, 150, 50);
        btn_InsertionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            semaphore.acquire();
                            sorting(new InsertionSort());
                            semaphore.release();
                        } catch(Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                });
                t.start();
            }
        });

        btn_MergeSort = new JButton("Merge Sort");
        btn_MergeSort.setBounds(850, 500, 150, 50);
        btn_MergeSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            semaphore.acquire();
                            sorting(new MergeSort());
                            semaphore.release();
                        } catch(Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                });
                t.start();
            }
        });

        btn_QuickSort = new JButton("Quick Sort");
        btn_QuickSort.setBounds(850, 600, 150, 50);
        btn_QuickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            semaphore.acquire();
                            sorting(new QuickSort());
                            semaphore.release();
                        } catch(Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                });
                t.start();
            }
        });
        window.add(btn_SelectionSort);
        window.add(btn_BubbleSort);
        window.add(btn_InsertionSort);
        window.add(btn_MergeSort);
        window.add(btn_QuickSort);

        window.pack();
        window.setVisible(true);

    }


    private void shuffle(){
        sortArray.shuffle();
        sortArray.resetColor();
        Sleep.sleepFor(Sleep.millisecToNano(1500));
    }

    public void sorting(Sort s){
            //Sleep.sleepFor(Sleep.millisecToNano(1000));
            shuffle();
            s.sort(sortArray);

            sortArray.resetColor();
            sortArray.highlight();
            sortArray.resetColor();
    }

}
