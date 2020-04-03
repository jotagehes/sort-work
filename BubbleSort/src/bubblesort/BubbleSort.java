
package bubblesort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
       
        long tempo1 = System.currentTimeMillis();
        
        System.out.println("Tempo inicial = " + tempo1);
        
        
         int[] v = gerarVetor(100000);
         
         bubbleSort(v);
         
         System.out.println(Arrays.toString(v));
         
         long tempo2 = System.currentTimeMillis();
        
        System.out.println("Tempo final = " + tempo2);

        System.out.println(tempo2 - tempo1 + " milissegundos");
        
    }
    
    private static void bubbleSort(int[] v){
        for(int ultimo = v.length-1; ultimo > 0; ultimo--){ // O(n^2)
            for(int i = 0; i < ultimo; i++){
                if (v[i] > v[i+1]){
                    trocar (v , i , i+1);
                }
            }
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

    private static void trocar(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
    
}
