import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {

		int[] nums = {1, 1, 2};
		System.out.println(Arrays.toString(nums) + " Regular List");
	
		System.out.println(String.valueOf(findKOfInts(nums) + " Main Call"));
				
		
	}
	
	public static void removeDuplicatesRight(int[] nums, int toSearch, int currentIndex) {
		
		int right = currentIndex + 1;
		
				
		if(currentIndex != nums.length - 1) {
		
			while(nums[right] == nums[currentIndex]) {
				nums[right] = 111;
				
				if(right == nums.length - 1) {
					break;
					 
				} else {
					right++;
				}
			}
		
		}
		System.out.println(Arrays.toString(nums));
		
	   
		
	}
	
	static int[] findDuplicatesInList(int [] nums) {
		
		int lengthOfNums = nums.length;
		
		for (int i = 0; i < lengthOfNums - 1; i++) {
			
			if (nums[i] != 111) {
			
				removeDuplicatesRight(nums, nums[i], i);
				
				
			}
			
		}
		
		return sortArrayList(nums);
		
		
	}
	
	static int[] sortArrayList(int[] nums) {
		
		for(int i = 1; i < nums.length; i++) {
			
			int key = nums[i];
			int j = i - 1;
			
			while(j >= 0 && nums[j] > key) {
				nums[j + 1] = nums[j];
				j = j -1;
			}
		
			nums[j + 1] = key;
		}
			
		
		System.out.println("Finished" + Arrays.toString(nums));
		return nums;

		
		
	}
	
	
	
	
	
	public static int findKOfInts(int[] nums) {
		
		if(nums.length != 0) {
			int[] fixedNums = findDuplicatesInList(nums);
			
			int lastIndex = fixedNums.length - 1;
			int count = nums.length;
	
			while(fixedNums[lastIndex] == 111) {
				count--;
				lastIndex--;
			}
			return count;

		} else {
			return 0;
		}
		
		
		
		
		
		
	}

}
