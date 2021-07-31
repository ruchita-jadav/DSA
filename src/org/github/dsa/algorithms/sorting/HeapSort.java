package org.github.dsa.algorithms.sorting;
//import com.modules.algoexpert.dataStucture.heap.MaxHeap;

import java.util.Arrays;
import java.util.List;

public class HeapSort {

    public static void main(String[] args) {
        new HeapSort().call();
    }

    private void call() {
        List list = Arrays.asList(8, 5, 2, 9, 5, 6, 3);
        buildHeap(list);
        maxHeapSort(list);
        list.stream().forEach(System.out::println);
    }

    private List maxHeapSort(List list) {
        for (int index = list.size() - 1; index > 0; index--) {
            findMax(list, index);
        }
        return list;
    }

    private void findMax(List<Integer> list, int index) {
        int parent = 0;
        int child = parent * 2 + 1;
        while (child <= index) {
            int swapChild;
            if (child + 1 < index && list.get(child + 1) > list.get(child)) {
                swapChild = child + 1;
            } else {
                swapChild = child;
            }
            if (list.get(swapChild) > list.get(parent)) {
                swap(list, parent, swapChild);
                parent = swapChild;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
        swap(list, 0, index);
    }

    private void swap(List<Integer> list, int parent, int swapChild) {
        Integer temp = list.get(parent);
        list.set(parent, list.get(swapChild));
        list.set(swapChild, temp);
    }

    public void buildHeap(List<Integer> list) {
        int lastParent = (list.size() - 2) / 2;
        while (lastParent >= 0) {
            shiftDown(lastParent, list);
            lastParent--;
        }
    }

    private void shiftDown(int parent, List<Integer> heap) {
        int child1 = 2 * parent + 1;
        while (child1 < heap.size()) {
            int swapChild;
            if (child1 + 1 < heap.size() && heap.get(child1 + 1) > heap.get(child1)) {
                swapChild = child1 + 1;
            } else {
                swapChild = child1;
            }
            if (heap.get(swapChild) > heap.get(parent)) {
                swap(heap, parent, swapChild);
                parent = swapChild;
                child1 = 2 * parent + 1;
            } else {
                break;
            }
        }
    }
}
