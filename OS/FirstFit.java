public class FirstFit {
    public static void main(String[] args) {
        int processes[] = {212, 417, 112, 426};
        int blocks[] = {100, 500, 200, 300, 600};

        //firstFit(processes, blocks);
        //bestFit(processes, blocks);

        worstFit(processes, blocks);

    }

    static void firstFit(int processes[],int blocks[])
    {
        
        int allocated[] = new int[processes.length];
        for(int i=0;i<processes.length;i++)
            allocated[i] = -1;

        for(int i=0;i<processes.length;i++)
        {
            for(int j=0;j<blocks.length;j++)
            {
                if(blocks[j] >= processes[i])
                {
                    allocated[i] = j;

                    blocks[j] -= processes[i];

                    break;
                }
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < processes.length; i++)
        {
            System.out.print(" " + (i+1) + "\t\t" + 
                             processes[i] + "\t\t");
            if (allocated[i] != -1)
                System.out.print(allocated[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    static void bestFit(int processes[], int blocks[])
    {
        int allocated[] = new int[processes.length];
        for(int i=0;i<processes.length;i++)
            allocated[i] = -1;

        for(int i=0;i<processes.length;i++)
        {
            int best = -1;
            for(int j=0;j<blocks.length;j++)
            {
                if(blocks[j] >= processes[i]){
                if(best==-1)
                    best = j;
                else if(blocks[best] > blocks[j])
                    best = j;
                }
            }

            if(best != -1)
            {
                allocated[i] = best;
                blocks[best] -= processes[i];
            }
        }

        System.out.println("Process No. \t Process Size \t Block No.");
        for(int i=0;i<processes.length;i++)
        {
            System.out.print(" "+(i+1)+"\t"+processes[i]+"\t\t");
            if(allocated[i] != -1)
                System.out.print(allocated[i]+1);
            else
                System.out.print("Not Allocated!");
            System.out.println();
        }

    }

    static void worstFit(int processes[], int blocks[])
    {
        int allocations[] = new int[processes.length];
        for(int i=0;i<processes.length;i++)
            allocations[i] = -1;

        for(int i=0;i<processes.length;i++)
        {
            int worst = -1;
            for(int j=0;j<blocks.length;j++)
            {
                if(blocks[j] >= processes[i])
                {
                    if(worst==-1)
                        worst=j;
                    else if(blocks[j] > blocks[worst])
                        worst = j;
                }
            }

            if(worst != -1)
            {
                allocations[i] = worst;
                blocks[worst] -= processes[i];
            }
        }

        System.out.println("Process No. \t Process Size \t Block Allocated");

        for(int i=0;i<processes.length;i++)
        {
            System.out.print((i+1)+"\t\t\t"+processes[i]);
            if(allocations[i] != -1)
                System.out.print("\t\t   "+(allocations[i]+1));
            else
                System.out.print("\t\t   Not Alloted");
            System.out.println();
        }

    }

}
