package SortingAlgo;
import SortingVisualization.SortArray;


public class QuickSort implements Sort {
    @Override
    public void sort(SortArray array) {
        int size = array.getArraySize();
        quickSort(array, 0, size - 1);
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }

    private void quickSort(SortArray array, int left, int right){
        if(left < right){
            int q = partition(array, left, right);
            quickSort(array, left, q - 1);
            quickSort(array, q + 1, right);
        }
    }

    private int partition(SortArray array, int left, int right){
        int x = array.getValue(right); // choose the most right elements as pivot
        int i = left - 1;

        for(int j = left; j < right; j++){
            if(array.getValue(j) <= x){
                i = i + 1;
                array.swap(i, j, 10);
            }
        }
        array.swap(i + 1, right, 10);
        return i + 1;
    }
}
