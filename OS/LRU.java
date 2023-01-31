import java.util.*;
public class LRU {
    public static void main(String[] args) {
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int capacity = 4;
        int faults = 0;
        HashSet<Integer> set = new HashSet<Integer>(capacity);
        
        HashMap<Integer,Integer> queue = new HashMap<Integer,Integer>();

        for(int i=0;i<pages.length;i++)
        {
            if(set.size() < capacity)
            {
                if(!set.contains(pages[i]))
                {
                    set.add(pages[i]);
                   
                    faults++;
                }
                queue.put(pages[i],i);
            }
            else
            {
                if(!set.contains(pages[i]))
                {
                    int lru=Integer.MAX_VALUE,val=Integer.MIN_VALUE;

                    Iterator<Integer> itr = set.iterator();

                    while(itr.hasNext())
                    {
                        int temp = itr.next();
                        if(queue.get(temp) < lru)
                        {
                            lru = queue.get(temp);
                            val = temp;
                        }
                    }

                    queue.remove(val);
                    set.remove(val);

                    set.add(pages[i]);
                    
                    faults++;
                }
                queue.put(pages[i],i);
            }
        }

        System.out.println("Page Faults are: "+faults);

    }
}
