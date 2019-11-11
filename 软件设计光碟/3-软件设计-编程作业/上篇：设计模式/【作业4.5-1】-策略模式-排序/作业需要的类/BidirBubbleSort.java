
public class BidirBubbleSort implements SortAlgorithm
{
    //public int[] Algorithms(int[] nums)

    public int[] sort(int[] nums)
    {
        int j;
        int limit = nums.length;
        int st = -1;
        while(st < limit)
        {
            boolean flipped = false;
            st++;
            limit--;
            for(j = st; j < limit; j++)
            {
                if(nums[j] > nums[j + 1])
                {
                    int T = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = T;
                    flipped = true;
                }
            }
            if(!flipped)
            {
                return nums;
            }
            for(j = limit; --j >= st;)
            {
                if(nums[j] > nums[j + 1])
                {
                    int T = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = T;
                    flipped = true;
                }
            }
            if(!flipped)
            {
                return nums;
            }
        }

        return nums;
    }

}