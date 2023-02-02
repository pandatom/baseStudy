# 认识复杂度和简单排序算法

### 时间复杂度 BigO：

大O表示，算法渐进时间的复杂度

T(n)=O(f(n))

计算时间渐进的趋势，估计值以有平方的值为指标





**空间复杂度**

内存空间增长的趋势

常用的空间复杂度 O(1)、O(n)、O(n^2)



时间空间复杂度=时间空间增长的趋势





# 1.排序

**交换**

使用异或交换，如果是独立空间的数，可以通过异或的方式来交换（但是不是独立空间的，比如数组，交换是下标原来的值会被替换，不能用这种方式交换）：

```java
    public void yhchange(){
        int a=11;
        int b=20;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a);
        System.out.println(b);
    }
```



一般用，这样交换

```java
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}
```





异或:遵循交换律和结合律







排序参考： https://www.runoob.com/w3cnote/selection-sort.html



对数器使用，用来检查排序算法是否写对了

```java
package com.changxiong.answercase.class01;

import java.util.Arrays;

public class Code06_InsertionSort {

	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}

	// i和j,数交换
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		// Math.random() ->  [0,1) 所有的小数，等概率返回一个
		// Math.random() * N -> [0,N) 所有小数，等概率返回一个
		// (int)(Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 长度随机 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) 
					- (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100; // 随机数组的长度0～100
		int maxValue = 100;// 值：-100～100
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			insertionSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				// 打印arr1
				// 打印arr2
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		insertionSort(arr);
		printArray(arr);
	}

}

```

























