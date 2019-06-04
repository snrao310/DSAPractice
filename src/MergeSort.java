import java.util.Arrays;
//(GPL) Sriram Vellangallor Subramanian
public class MergeSortDemo {
	private static void mergeSort(int[] nums) {
		if(nums.length==1) return;
		int mid=nums.length/2;
		//Divide
		int[] left=Arrays.copyOfRange(nums, 0, mid);
		int[] right=Arrays.copyOfRange(nums,mid,nums.length);
		mergeSort(left);
		mergeSort(right);
		//Conquer
		int i=0,j=0,k=0;
		while(j<left.length&&k<right.length)
			if(left[j]<=right[k]) nums[i++]=left[j++];
			else nums[i++]=right[k++];
		while(j<left.length) nums[i++]=left[j++];
		while(k<right.length) nums[i++]=right[k++];
	}
	
	public static void main(String[] args) {
		int[] nums= {8,3,7,1,2};
		mergeSort(nums);
		for(int t:nums)
			System.out.print(t+" ");
	}
}
