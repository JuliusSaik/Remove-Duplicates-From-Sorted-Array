import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {

		int[] nums = {2, -2, 3, 4, 4, 5, 8, 9, 10, 10, 10, 10, 11, 12, 15};
		System.out.println(Arrays.toString(nums));
		
	
		System.out.println(String.valueOf(findKOfInts(nums)));
		//Expected result = nums {2, 111, }
				
		
	}
	
	public static int indexOfDuplicate(int[] nums, int toSearch, int currentIndex, int low, int high) {
		
		//if it tries to search "deleted" index, return same index.
	    int middle = low  + ((high - low) / 2);

	    //if there are no duplicates return -1(index out of bounds exception)
	    if (high < low) {
	        return -1;
	    }
		
	    if(toSearch == nums[middle]) {
	    	
	    	if(middle != currentIndex) {
	    		return middle;
	    	} else {
	    		return indexOfDuplicate(nums, toSearch, currentIndex, low, middle -1);
	    	}
	    	
	    }
	    else if (nums[middle] > toSearch){
	    	
	    
	    	return indexOfDuplicate(nums, toSearch, currentIndex, low, middle - 1);
	  
	    } else if(nums[middle] < toSearch) {
	    	
	    	return indexOfDuplicate(nums, toSearch, currentIndex, middle + 1, high);
	    	
	    } 
	    
		return middle;
		
	}
	
	static int[] findDuplicatesInList(int [] nums) {
		
		int lengthOfNums = nums.length;
		
		for (int i = 0; i < lengthOfNums; i++) {
			
			if (nums[i] != 111) {
			
				int indexOfDuplicate = indexOfDuplicate(nums, nums[i], i, 0, lengthOfNums - 1);
				
				if(indexOfDuplicate != -1) {
					nums[indexOfDuplicate] = 111; //acts as deletion
				}
				
			}
			
		}
		
		System.out.println(Arrays.toString(nums));
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
