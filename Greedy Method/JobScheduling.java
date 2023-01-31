/*

Refer: Abdul Bari Algo Analysis video 3.2 for explaination and Gate Smashers L-4.5 for algorithm. Easy Peasy :)

Algorithm:

1. Arrange all jobs in decreasing order of profit. Largest first.
2. For each job, do linear search to find particular slot in array of size 'n' where 'n' = Max deadline and 'm' = total jobs.

*/

import java.util.*;

public class JobScheduling {
    
    public static void main(String[] args) {
        
        //Jobs
        // int deadline[] = {56,27,67,64,94,54,43,96,73,96,14,78,61,77,68,40,36};
        // int profit[] = {288,435,401,368,248,361,108,167,251,170,156,184,370,424,397,375,218};

        int deadline[] = {97,60,19,21,35,15,20,3,25,90,6,47,18};
        int profit[] = {235,279,319,356,230,82,191,246,16,319,39,455,432};

        //We need them sorted and TreeMap sorts items based on keys so we use it. It by default sorts in increasing order so we tell it to sort in descending order by passing comparator.
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>(Comparator.reverseOrder());

        //Putting values in TreeMap
        for(int i=0;i<deadline.length;i++)
        {
            tm.put(profit[i],deadline[i]);
        }

        //Finding max deadline
        int n = 0;
        for(int i=0;i<deadline.length;i++)
            if(deadline[i] > n)
                n = deadline[i];

        //Job doing slots, total profit
        int size[] = new int[n];
        int p = 0;

        for(Map.Entry<Integer,Integer> i: tm.entrySet())
        {
            //If a job has deadline 2 then we'll do it in last instance. So now that the time slot is booked, we'll mark it so it won't get reoccupied.
            if(size[i.getValue()-1] == 0)//Check if the last instance slot is available or not. If not, see else block.
            {
                p += i.getKey();//Since we are doing it, we'll add its profit.
                size[i.getValue()-1]++;//Marking the slot taken.
            }
            else//If last instance slot is not available, then, check if any instance is available before it, if yes, take it
            {
                for(int j=i.getValue()-1;j>=0;j--)//Checking from last instance to start.
                {
                    if(size[j] == 0)
                    {
                        p += i.getKey();
                        size[j]++;
                        break;
                    }
                }
                //Now you might think, why don't we search in right side of array? That's because it's deadline would expire....that's what last instance is....its last unit of time to complete the job.
            }
        }

        System.out.println("Profit: "+p);

    }

}
