/* A Java Program to find out the minimum number of
elements to be deleted from an input integer array so that
the bitwise AND of the remaining elements does
not equal zero. 

Code to find the subsets of array is from geeksforgeeks
Refer: https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
*/

public class Main
{
	// Print all subsets of given set[]
	static int printSubsets(int arr[])
	{
		int n = arr.length;
		int maxSubsetLen = 0;

		for (int i = 0; i < (1<<n); i++)
        {
            int subsetLen = 0;
            int ansAnd = arr[0];

            for (int j = 0; j < n; j++) {
                              
                /* (1<<j) is a number with jth bit 1
                   so when we 'and' them with the
                   subset number we get which numbers
                   are present in the subset and which
                   are not */
                if ((i & (1 << j)) > 0) {
                    
                  //If an element is part of the subset, 
                    //perform bitwise AND of those elements
                    ansAnd = ansAnd & arr[j];
                    subsetLen++;
                }
            }
            
            //maxSubsetLen stores the max subset length where
            //bitwise AND does not result in zero
            if(ansAnd != 0 && maxSubsetLen <= subsetLen) {
                    maxSubsetLen = subsetLen;
            }

        }
        
        //Final result is the total length of array
        //minus the maxSubsetLen
        return (n - maxSubsetLen);
	}

	public static void main(String[] args)
	{
		int arr[] = {1,2,5,4,8,3,7};
		
		System.out.println("Minimum deletetions required: " + printSubsets(arr));

	}
}
