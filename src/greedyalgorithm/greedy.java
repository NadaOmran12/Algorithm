/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedyalgorithm;
import java.util.Arrays;
import java.util.Comparator;


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
    
      public static void main(String[] args) {
        int[] Gvalues = new int []{10,5,15,7,6,18,3};
        int[] Gweights= new int[]{2,3,5,7,1,4,1};
        int Gcapacity = 15;
        
         System.out.println("\n"+"Greedy solution:");
        greedy.Greedy(Gweights,Gvalues,Gcapacity);
        
        
      }
}
