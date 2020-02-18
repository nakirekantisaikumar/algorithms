import java.util.ArrayList;

public class NearestSum {
	 static int sum = 0;
		static boolean initSum = false;
		static int target = 0;
		static int infinity = 0;
		
		public static void printCombinations(int[] arr, int[] data, 
				 int j, int c) {
			
			if(c > 1) {
				if(data[0] != infinity &&  data[0] != infinity  &&  data[2] != infinity) {
					if(!initSum) {
						sum = data[0] + data[1] + data[2];	
						initSum = true;
					} else {
						
						int newSum = data[0] + data[1] + data[2];
						int diff1 = 0;
						
						if(target < 0 && newSum < 0) {
							diff1 = newSum*-1 + target;
						} else if(target >= 0 && newSum >= 0) {
							diff1 = newSum - target;
						} else if(target < 0) {
							diff1 = newSum +  (target*-1);
						} else if(newSum < 0) {
							diff1 = (newSum * -1) +  target;
						}
						

						int diff2 = 0;
						
						if(target < 0 && sum < 0) {
							diff2 = (sum*-1) + target;
						} else if(target >= 0 && sum >= 0) {
							diff2 = (sum - target);
						} else if(target < 0) {
							diff2 = (sum +  (target*-1));
						} else if(sum < 0) {
							diff2 = ((sum) * -1) +  target;
						}
						
						if(diff1 < 0) {
							diff1 = diff1 * -1;
						} else if(diff2 < 0) {
							diff2 = diff2 * -1;
						}
						
						if(diff1 <= diff2) {
							sum = newSum;
						}
					}
				}
					
				return;
			}
			
			for(int k= j+1; k < arr.length; k++) {
				data[c+1] = arr[k];
				printCombinations(arr, data, k, c+1);
				data[c+1] = infinity;
			}
		}
	
		   public static int threeSumClosest(ArrayList<Integer> A, int B) {
		        int[] input = A.stream().mapToInt(i->i).toArray();
		        target = B;
				
				for (int i = 0; i < input.length; i++) {
					if(input[i] < infinity) {
						infinity = input[i];
					}
				}
				if(infinity == infinity + infinity) {
					infinity = infinity -1;
				} else {
					infinity = infinity + infinity;
				}
				
				int[]  data = {infinity, infinity, infinity};
				
				printCombinations(input, data,  -1, -1);
				return sum;
		    }
	
	public static void main(String[] args) {
		
		//int[] arr = {1,2,3};
		//int[] arr = { -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
		//int[] arr = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };
		//int[] arr =  { -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
		
		//int[] arr = { -10, -10, -10 };
		//int arr[] = { -4, -8, -10, -9, -1, 1, -2, 0, -8, -2 };
		//int arr[] = { 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 };
		//int arr[] = { -4, -8, -10, -9, -1, 1, -2, 0, -8, -2 };
		//int arr[] = { 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 };
		//int arr[] =  { 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 };
		// [ 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 ]
		ArrayList<Integer> al = new ArrayList<>();
		al.add(2);
		al.add(1);
		al.add(-9);
		al.add(-7);
		al.add(-8);
		al.add(2);
		al.add(-8);
		al.add(2);
		al.add(3);
		al.add(-8);
		
		int nSum = threeSumClosest(al, -1);
		System.out.print(nSum);
	}
}
