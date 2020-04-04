package SortingAlgo;

import SortingVisualization.SortArray;

public class SelectionSort implements Sort {
    @Override
    public void sort(SortArray array) {
        selectionSort(array);
    }

    private void selectionSort(SortArray array){
        int size = array.getArraySize();
        for(int i = 0; i < size; i++){
            int idx = i;
            for(int j = i + 1; j < size; j++){
                if(array.getValue(idx) > array.getValue(j)) {
                    idx = j;
                }
            }
            array.swap(idx, i, 10);
        }
    }
}
