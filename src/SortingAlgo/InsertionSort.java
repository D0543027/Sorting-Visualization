package SortingAlgo;

import SortingVisualization.SortArray;

public class InsertionSort implements Sort{
    @Override
    public void sort(SortArray array){
        insertionSort(array);
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }

    private void insertionSort(SortArray array){
        int size = array.getArraySize();

        for(int i = 0; i < size; i++){
            int key = array.getValue(i);
            int j = i - 1;

            while(j >= 0 && key < array.getValue(j)){
                array.update(j + 1, array.getValue(j), 10);
                j = j - 1;
            }
            array.update(j + 1, key , 10);
        }
    }
}
