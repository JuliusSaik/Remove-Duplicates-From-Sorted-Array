import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {

		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(Arrays.toString(nums) + " Regular List");
	
		System.out.println(String.valueOf(findKOfInts(nums) + " Main Call"));
				
		
	}
	
	public static void removeDuplicatesRight(int[] nums, int toSearch, int currentIndex) {
		
		int middle = currentIndex;
		int right = middle + 1;
		
				
		if(currentIndex != nums.length - 1) {
		
			while(nums[right] == nums[middle]) {
				nums[right] = 111;
				right++;
			}
		
		}
		System.out.println(Arrays.toString(nums));
		
	   
		
	}
	
	static int[] findDuplicatesInList(int [] nums) {
		
		int lengthOfNums = nums.length;
		
		for (int i = 0; i < lengthOfNums; i++) {
			

			if (nums[i] != 111) {
			
				removeDuplicatesRight(nums, nums[i], i);
				
				
			}
			
		}
		
		return sortArrayList(nums);
		
		
	}
	
	static int[] sortArrayList(int[] nums) {
		
			int lowestIndex = 0;
			
			
			for(int i = 0; i < nums.length; i++) {
				
				lowestIndex = i;

				for(int a = i; a < nums.length; a++) {
					
					if(nums[a] < nums[lowestIndex]) {
						lowestIndex = a;
						
	
					}
					
					
				}
				
				if(lowestIndex != i) { 
					int toSwitch = nums[lowestIndex];
				 
					nums[lowestIndex] = nums[i]; 
					nums[i] = toSwitch;
				  }
				
				
			}
			
	
			
		
		System.out.println("Finished" + Arrays.toString(nums));
		return nums;

		
		
	}
	
	
	
	
	
	public static int findKOfInts(int[] nums) {
		
		int count = 0;
		int[] fixedNums = findDuplicatesInList(nums);
		
		for (int i = 0; i < fixedNums.length; i++) {
						
			if(fixedNums[i] != 111) {
				count++;
			}
		}
		
		
		
		return count;
		
		
		
	}

}
