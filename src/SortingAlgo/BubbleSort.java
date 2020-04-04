package SortingAlgo;

import SortingVisualization.SortArray;

public class BubbleSort implements Sort {
    @Override
    public void sort(SortArray array) {
        bubbleSort(array);
    }

    private void bubbleSort(SortArray array){
        int size = array.getArraySize();
        for(int i = 0; i < size - 1; i++){
            for(int j = 1; j < size - i; j++){
                if(array.getValue(j - 1) > array.getValue(j))
                    array.swap(j, j - 1, 10);
            }
        }
    }
}
