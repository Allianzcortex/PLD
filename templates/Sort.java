/**
 * 排序与搜索实现
 */

/*
关于排序，用 Java 所实现的各种方式
 */

class Test {
    static int[] arr = {1};  // 对 Java 而言，static 也就是 class variable，和 Python 里面还是有些不同的

    public void cc() {
        arr[0] += 1;
    }
}

public class Sort {

    /* 冒泡排序 */
    public static void bubbleSort(int arr[]) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /* 插入排序 */
    public static void insertSort(int arr[]) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) { // j-- 这里是小的技术细节，要注意啊
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /* 希尔排序 */
  /*  public static void shellSort(int arr[]) {
        int length = arr.length;
        int gap = length / 2;
        for (int i = 0; i < gap; i++) {
            for (int j = i + gap; j < length; j+1) {
                int a;
            }
        }

    }*/

    /* 下面是归并排序 */
    public static void mergeArray(int arr[], int left, int middle, int right) {
        int totalLength = right - left + 1;
        int leftArray[] = new int[middle - left + 1], rightArray[] = new int[right - middle];
        // 备份两组数
        for (int i = 0; i < middle - left + 1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < right - middle; j++)
            rightArray[j] = arr[middle + 1 + j];
        // 合并数组
       /* int i = left, j = middle + 1, index = left;*/
        // 这个一开始是自己想的有问题
        int i = 0, j = 0, index = left;
        while (i < middle - left + 1 && j < right - middle) {
            if (leftArray[i] < rightArray[j]) {
                arr[index] = leftArray[i++];
            } else {
                arr[index] = rightArray[j++];
            }
            index++;
        }
        while (i < middle - left + 1) {
            arr[index] = leftArray[i++];
            index++;
        }
        while (j < right - middle) {
            arr[index] = rightArray[j++];
            index++;
        }

    }

    public static void sort(int arr[], int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            mergeArray(arr, left, middle, right);
        }
    }


    public static void mergeSort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }


    /* 下面是进行选择排序
    * 从有序区内选择一个最小的*/
    public static void selectSort(int arr[]) {
        int minIndex, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            /*for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1])  // 这个是比较大小的时候出错，比如 [3,2,1] 是得不到 1 是最小值
                    minIndex = j;
            }*/
            /*for(int j=i;j<arr.length-i;j++){*/ // 这个是自己对于迭代的顺序没有想好
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /* 下面进行快速排序 */
    /* 和归并排序应该是类似的*/
    public static int partition(int arr[], int left, int right) {
        // 比如选取最后一个元素为 pivot
        int pivot = arr[right], temp;
        int i = left - 1;
        for (int j = left; j < right; j++) {
            // 如果 <= 那就交换
            if (arr[j] <= pivot) {
                i++;

                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // 下面交换 arr[i+1] 与 pivot
        temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }

    public static void sort_(int arr[], int left, int right) {
        if (left < right) {
            int pi = partition(arr, left, right);
            sort_(arr, left, pi - 1);
            sort_(arr, pi + 1, right);
        }
    }

    public static void quickSort(int arr[]) {
        sort_(arr, 0, arr.length - 1);
    }

    public static void shellSort(int arr[]) {

    }

    public static void main(String[] args) {
        int arr[] = {4, 6, 1, 3, 9, 2, 0, 6};
        // bubbleSort(arr);  done
        // mergeSort(arr);   done temp
        // selectSort(arr);  done still wait to summary
        quickSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        Test test = new Test();
        test.cc();
        Test test1 = new Test();
        test1.cc();
        System.out.println(test1.arr[0]);
    }
}
