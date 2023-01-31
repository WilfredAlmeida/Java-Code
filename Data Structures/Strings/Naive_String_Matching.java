public class Naive_String_Matching {
    
    public static void main(String[] args) {
        String s = "aababcbababcacabccabca";
        String p = "babc";
        boolean f = false;
        int x=-1;
        for(int i=0;i<s.length()-p.length();i++)
        {
            f=true;
            for(int j=0;j<p.length();j++)
            {
                String a = String.valueOf(s.charAt(i+j));
                String b = String.valueOf(p.charAt(j));

                if(!a.equals(b))
                {
                    f=false;
                    break;
                }
                x=j;
            }
        }

        if(f)
            System.out.println("Match Found at: "+(x+1));
        else
            System.out.println("Not Found");

    }

}
