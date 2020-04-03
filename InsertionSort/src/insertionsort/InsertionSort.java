
package insertionsort;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        
        long tempo1 = System.currentTimeMillis();
        
        System.out.println("Tempo inicial = " + tempo1);
        
        
         int[] v = gerarVetor(1000000);
         insertionSort(v);
         
         System.out.println(Arrays.toString(v));
         
         long tempo2 = System.currentTimeMillis();
        
        System.out.println("Tempo final = " + tempo2);

        System.out.println(tempo2 - tempo1);
         
         
        
    }
    
    private static void insertionSort(int[] v){
        int x, j;
        for(int i = 1; i < v.length; i++){
            x = v[i];
            j = i - 1;
            while ((j >= 0) && v[j] > x){
                v[j+1] = v[j];
                j = j - 1;
            }
            v[j + 1] = x;
            
        }
    }
    
    public static int[] gerarVetor(int n){
        int []v = new int [n];
        Random gerador = new Random();
        for(int i = 0; i < n; i++){
            v[i] = gerador.nextInt(10000000);
        }
        
        return v;
    }
    
}
