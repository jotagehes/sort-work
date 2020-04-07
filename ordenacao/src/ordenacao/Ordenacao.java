package ordenacao;

import java.util.Arrays;
import java.util.Random;

public class Ordenacao {
        
    public static void main(String[] args) {
        for(int i = 0; i < 6; i ++){//esse for controla a quantidade de vezes que o programa é executado
            int base = 10;
            int potencia = 2;
            int n = (int)Math.pow(base, potencia);//função que vai determinar o tamanho do vetor exponencialmente (iniciando com 100 posições)
            int vetorDecrescente [] = new int [n]; // vetor auxiliar usado para o pior caso (se necessário)
            int[] v = gerarVetor(n); //esse método vai gerar o vetor com a quantidade n e irá preencher todo o vetor com números de 0 a 999;
            int vetorBubble [] = new int [n]; //copia do vetor original
            int vetorSelection [] = new int [n];//copia do vetor original
            int vetorInsertion [] = new int [n];//copia do vetor original
            int vetorMerge [] = new int [n];//copia do vetor original
            int vetorQuick [] = new int [n];//copia do vetor original
            for(int f = 0; f < n; f ++){//for de preenchimento dos vetores cópia;
                vetorBubble[f] = v[f];
                vetorSelection [f] = v[f];
                vetorInsertion [f] = v[f];
                vetorMerge [f] = v[f];
                vetorQuick [f] = v[f];
            }// aqui tenho cinco cópias identicas ao vetor gerado aleatoriamente
            
            long tinibubble = System.currentTimeMillis();
            bubbleSort(vetorBubble);//medio caso
            //gravar tempo final medio caso
            
            //chamar bubble de novo para melhor caso (ini e fim)
            
            
            //criar cópia ordenada drecrescente do vetor para execução do pior caso
            
            long tiniquick = System.currentTimeMillis();
            quickSort(vetorQuick, 0, vetorQuick.length-1);
            
            long tiniselection = System.currentTimeMillis();
            selectionSort(vetorSelection);
            
            long tiniinsertion = System.currentTimeMillis();
            insertionSort(vetorInsertion);
            
            int[] w = new int[n];
            long tinimerge = System.currentTimeMillis();
            mergeSort(vetorMerge, w, 0, vetorMerge.length);
            
            
            
            
            /*COLOCAR NO FIM DA EXECUÇÃO POTENCIA + 2*/
            
        }
        long tempo1 = System.currentTimeMillis();
        
        System.out.println("Tempo inicial = " + tempo1);
        
        
         int[] v = gerarVetor(100000);
         
         bubbleSort(v);
         
         System.out.println(Arrays.toString(v));
         
         long tempo2 = System.currentTimeMillis();
        
        System.out.println("Tempo final = " + tempo2);

        System.out.println(tempo2 - tempo1 + " milissegundos");
        
    }
    
    private static void bubbleSort(int[] v){ // logica do bubble sort;
        int aux = 0;
        int i = 0;
        for(i = 0; i<v.length; i++){
        for(int j = 0; j<v.length-1; j++){
            if(v[j] > v[j + 1]){
                aux = v[j];
                v[j] = v[j+1];
                v[j+1] = aux;
            }
        }
    }
    }
    
    private static void quickSort(int[] vetor, int inicio, int fim) {//vetor a ser ordenado, inicio (0) e fim vetor.length/
             if (inicio < fim) {
                    int posicaoPivo = separar(vetor, inicio, fim);
                    quickSort(vetor, inicio, posicaoPivo - 1);
                    quickSort(vetor, posicaoPivo + 1, fim);
             }
       }
    
    private static int separar(int[] vetor, int inicio, int fim) {
             int pivo = vetor[inicio];
             int i = inicio + 1, f = fim;
             while (i <= f) {
                    if (vetor[i] <= pivo)
                           i++;
                    else if (pivo < vetor[f])
                           f--;
                    else {
                           int troca = vetor[i];
                           vetor[i] = vetor[f];
                           vetor[f] = troca;
                           i++;
                           f--;
                    }
             }
             vetor[inicio] = vetor[f];
             vetor[f] = pivo;
             return f;
       }
    
    public static int[] gerarVetor(int l){ //botei 'l' no sentido de tamanho Leanth;
        int []v = new int [l];
        Random gerador = new Random();// instancia novo objeto da classe Random;
        for(int i = 0; i < l; i++){
            v[i] = gerador.nextInt(1000);// gera numeros inteiros entre 0 e 999;
        }
        return v; //o retorno do método será o vetor v!;
    }

    private static void trocar(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
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