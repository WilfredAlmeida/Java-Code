import java.util.*;
public class FIFO
{
    public static void main(String[] args) {
        
        int capacity = 4;
        HashSet<Integer> set = new HashSet<Integer>(capacity);
        Queue<Integer> queue = new LinkedList<Integer>();
        
        int reference[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int n = reference.length;
        int faults = 0;

        for(int i=0;i<n;i++)
        {
            if(set.size() < capacity)
            {
                if(!set.contains(reference[i]))
                {
                    set.add(reference[i]);
                    queue.add(reference[i]);
                    faults++;
                }
            }
            else
            {
                if(!set.contains(reference[i]))
                {
                    int val = (Integer)queue.peek();
                    queue.poll();
                    set.remove(val);
                    set.add(reference[i]);
                    queue.add(reference[i]);
                    faults++;
                }
            }
        }

        System.out.println("Faults: "+faults);

    }
}