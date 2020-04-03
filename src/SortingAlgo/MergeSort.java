package SortingAlgo;
import SortingVisualization.SortArray;

public class MergeSort implements Sort {
    @Override
    public void sort(SortArray array) {
        int size = array.getArraySize();
        mergeSort(array, 0, size - 1);
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }

    public void mergeSort(SortArray array, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private void merge(SortArray array, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int k = left;

        int size = array.getArraySize();
        int[] temp = new int[size];
        while(i <= mid && j <= right){
            if(array.getValue(i) < array.getValue(j)){
                temp[k] = array.getValue(i);
                k = k + 1;
                i = i + 1;
            }else{
                temp[k] = array.getValue(j);
                k = k + 1;
                j = j + 1;
            }
        }

        while(i <= mid){
            temp[k] = array.getValue(i);
            k = k + 1;
            i = i + 1;
        }

        while(j <= right){
            temp[k] = array.getValue(j);
            k = k + 1;
            j = j + 1;
        }

        for(int ii = left; ii <= right; ii++){
            array.update(ii, temp[ii], 10);
        }
    }
}
