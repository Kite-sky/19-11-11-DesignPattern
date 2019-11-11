
public class QuickSort {
	private int[] arr;
	private int len;

	public int[] sort(int[] input) {
		arr = input;
		len = input.length;
		quicksort(0, len - 1);
		return arr;
	}

	private void quicksort(int bottom, int top) {
		int m = bottom, n = top;
		// Get the mid element from the middle of the list
		int mid = arr[(bottom + top) / 2];

		// Divide the input into two parts
		while (m <= n) {
			// If the current value from the left part is smaller then the mid
			// element then increase the index by 1
			while (arr[m] < mid) {
				m++;
			}
			// If the current value from the right list is larger then the mid
			// element then decrease the index by 1
			while (arr[n] > mid) {
				n--;
			}

			// If we found a left-part value that is larger than the mid element
			// and a right-part value that is smaller then the mid element then
			// we exchange the values.
			if (m <= n) {
				exchange(m, n);
				m++;
				n--;
			}
		}
		// apply recursion
		if (bottom < n)
			quicksort(bottom, n);
		if (m < top)
			quicksort(m, top);
	}

	private void exchange(int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
}
