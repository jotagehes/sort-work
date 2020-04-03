
package selectionsort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {
        
        long tempo1 = System.currentTimeMillis();
        
        System.out.println("Tempo inicial = " + tempo1);
        
        int[] v = gerarVetor(10000);
        selectionSort(v);
        
        System.out.println(Arrays.toString(v));
                   
        long tempo2 = System.currentTimeMillis();
        
        System.out.println("Tempo final = " + tempo2);

        System.out.println(tempo2 - tempo1);
        
    }
    
    private static void selectionSort(int[] v){ //O(n^2)
        
        for(int i = 0; i < v.length; i++){ //O(n)
            int menor = i;
            for (int j = i + 1; j < v.length; j++){ //O(n-1)
                if (v[j] < v [menor])
                    menor = j;
            }
            trocarSelection(v, i , menor);
            
            
            
        }
    }
    
    private static void trocarSelection(int[] v, int i, int menor) {
       int aux = v[i];
       v[i] = v[menor];
       v[menor] = aux;
    }
        
    public static int[] gerarVetor(int n){
        int []v = new int [n];
        Random gerador = new Random();
        for(int i = 0; i < n; i++){
            v[i] = gerador.nextInt(100000);
        }
        
        return v;
    }

    
    
}
