package mergesort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {

        long tempo1 = System.currentTimeMillis();

        System.out.println("Tempo inicial = " + tempo1);

        int[] v = gerarVetor(100);
        int[] w = new int[v.length];

        mergeSort(v, w, 0, v.length-1);

        System.out.println(Arrays.toString(v));

        long tempo2 = System.currentTimeMillis();

        System.out.println("Tempo final = " + tempo2);

        System.out.println(tempo2 - tempo1);

    }

    public static int[] gerarVetor(int n) {
        int[] v = new int[n];
        Random gerador = new Random();
        for (int i = 0; i < n; i++) {
            v[i] = gerador.nextInt(1000);
        }

        return v;
    }

    private static void mergeSort(int[] v, int[] w, int ini, int fim) {
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(v, w, ini, meio);
            mergeSort(v, w, meio+1, fim);
            intercalar(v, w, ini, meio, fim);
        }
    }

    private static void intercalar(int[] v, int[] w, int ini, int meio, int fim) {
        for (int k = ini; k <= fim; k++) 
            w[k] = v[k];

            int i = ini;
            int j = meio + 1;

        for (int k = ini; k <= fim; k++){
            if (i > meio) v[k] = w[j++];
            else if (j > fim) v[k] = w[i++];
            else if (w[i] < w[j]) v[k] = w[i++];
            else v[k] = w[j++];
        }
    }

}
