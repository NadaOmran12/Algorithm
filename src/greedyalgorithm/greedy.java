
package greedyalgorithm;
import java.util.Arrays;
import java.util.Comparator;
import static java.lang.Integer.max;


public class greedy {
     public static void Greedy(int[] wt,int[] val, int capacity)
                         
    { 
        IV[] iVal = new IV[wt.length]; 
        for(int i = 0; i < wt.length; i++) 
        { 
            iVal[i] = new IV(wt[i], val[i], i); 
        } 
  
        //sorting the items by value
        Arrays.sort(iVal, new Comparator<IV>()  
        { 
            @Override
            public int compare(IV O1, IV O2)  
            { 
                return O2.p.compareTo(O1.p) ; 
            } 
        }); 
  
        double totalValue = 0; 
        for(IV i: iVal) 
        { 
            int currentWt = (int) i.wt; 
            int currentVal = (int) i.val; 
  
            if (capacity - currentWt >= 0) 
            { 
                // can pick the whole item  
                capacity = capacity-currentWt; 
                totalValue += currentVal; 
  
            } 
            else
            { 
                // cannot pick the whole item  
                double fraction = ((double)capacity/(double)currentWt); 
                totalValue += (currentVal*fraction); 
//                capacity = (int)(capacity - (currentWt*fraction)); 
                break; 
            } 
        } 
  
        System.out.println("total value = " + totalValue +"\n"); 
    } 
     
    // the item value class 
    static class IV  
    { 
        Double p; 
        double wt, val, ind; 
        
        public IV(int wt, int val, int ind) 
        { 
            this.wt = wt; 
            this.val = val; 
            this.ind = ind; 
            p = new Double(val/wt ); 
        } 
    } 
    
    public class DynamicProgramming {
    
     public void Table(int n, int C, int [][] Table, int [] wt, int [] v){ 
       
       for (int i=0; i<n; i++){
      
       for (int w=0; w <= C ; w++){
           
           if (i==0 || w==0)
           {
               Table[i][w]=0;
               
           }
           else if (wt[i] <= w)
           {
             Table[i][w]= max(v[i]+Table[i-1][w-wt[i]], Table[i-1][w]);  
           }
           else 
           {
               Table[i][w]= Table[i-1][w];
           }
       }
   }
   for (int x=0;x<5;x++)
   {
       for (int y=0; y<9 ;y++) 
       {   
           System.out.print("\t"+Table[x][y]);
           if(y==8){
               System.out.print("\n");    
           }
           if (x==4 && y==8){
               System.out.println("maximum value=" + Table[x][y]+"\n");
           }
       }
   }  
   }
}
    
    public class BackTracking {
       int v = 0;    
       int w = 0; 
        public  void knapsack(int[] weights, int[] values, int C, int index, int[] solution, int[] finalSolution) {  
        solution[index] = -1;
        int n = values.length;
        while (solution[index] < 1) {
            solution[index] = solution[index] + 1;
            if (sum(index, solution, weights) <= C && index == n - 1) {
                System.out.println("Solution: " + Arrays.toString(solution));
                System.out.println("weight = " + sum(index, solution, weights));
                update(weights, values, index, solution, finalSolution);
                System.out.println("--------------------------------------");
            } else if (index < n - 1) {    
                knapsack(weights, values, C, index + 1, solution, finalSolution);
                  
            } 
        }
    }
  
    private int sum(int index, int[] weights, int[] sol) {
        int result = 0;
        for (int i = 0; i < sol.length; i++) {
            result += sol[i] * weights[i];
        }
        return result;
    }
  
    private void update(int[] weights, int[] values, int index, int[] sol, int[] finalSol) {  
  
        int totalValue = 0;
        int totalWeight = 0;
  
        for (int i = 0; i < weights.length; i++) {
            if (sol[i] == 1) {
                totalValue += values[i];
                totalWeight += weights[i];
            }
        }
  
        if (totalValue > v) {
            for (int i = 0; i < weights.length; i++) {
                finalSol[i] = sol[i];
            }
            v = totalValue;
            w = totalWeight;
            System.out.println("new value = " + v); 
            
            
        }
      
    }
    
}
    
      public static void main(String[] args) {
        int[] Gvalues = new int []{10,5,15,7,6,18,3};
        int[] Gweights= new int[]{2,3,5,7,1,4,1};
        int Gcapacity = 15;
        
         System.out.println("\n"+"Greedy solution:");
        greedy.Greedy(Gweights,Gvalues,Gcapacity);
        
        
      }
}
