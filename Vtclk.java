import java.util.Scanner;

public class Vtclk {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
        int p,e,hb,d;
        
        System.out.println("enter the number of processes ");
        p=sc.nextInt();
        
        System.out.println("enter the maximum number of events ");
        e=sc.nextInt();
        
        System.out.println("Enter the number of HBRs ");
        hb=sc.nextInt();
        
        System.out.println("Enter the delay ");
        d=sc.nextInt();
        
        int f[]= new int[e+1];
        
        vect ar[][]=new vect[p+1][e+1];
        
        for(int i=0;i<p+1;i++)
            for(int j=0;j<e+1;j++)
                ar[i][j]=new vect(p);        
        int i,j;
        for(i=0;i<p;i++)
        {
        System.out.println("Enter the number of events for process "+i+" ");
        int np=sc.nextInt();
        f[i]=np;
       
        ar[i][0].tm[i]=1;
        
            for(j=1;j<np;j++)
            {
            ar[i][j].tm[i]=ar[i][j-1].tm[i]+1;
            System.out.println(ar[i][j].tm[i]);
            }
            
            for(j=0;j<np;j++)
            {
                System.out.print("[");
                for(int k=0;k<p;k++)
                {
                System.out.print(ar[i][j].tm[k]);
                }
                System.out.println("]\n");
            }
        }
        System.out.println("Enter the HBR events");
        int ps,pr,es,er;
         for(i=0;i<hb;i++)
         {
         
             System.out.println("Enter the sending process and event ");
             ps=sc.nextInt();
             es=sc.nextInt();
         
             ps=ps-1;
             es=es-1;
             
             System.out.println("Enter the recieving process and event ");
             pr=sc.nextInt();
             er=sc.nextInt();
             
             pr=pr-1;
             er=er-1;
             ar[pr][er].tm[ps]=ar[ps][es].tm[ps];
             
             int z;
             for(z=er+1;z<e;z++)
             {
             ar[pr][z].tm[ps]=ar[pr][z-1].tm[ps];
             }
            }
       
        for(i=0;i<p;i++)
        {
        System.out.printf("process:"+i+": \n");

        for(j=0;j<f[i];j++)
        {
          System.out.print("[");
                for(int k=0;k<p;k++)
                {
                System.out.print(ar[i][j].tm[k]);
                }
                System.out.print("]  ");
          
        }
    
        System.out.println(" \n");
    }  
    } 
    
    private static int max(int i, int j) {
    if(i>j)
        return i;
    else 
        return j;
}
    
}

class vect{
int tm[];

vect(int n){
tm=new int[n];

int i;

for(i=0;i<n;i++)
{
tm[i]=0;
}
}
}