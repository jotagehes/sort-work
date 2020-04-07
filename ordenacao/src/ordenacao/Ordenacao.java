package ordenacao;

import java.util.Arrays;
import java.util.Random;

public class Ordenacao {
        
    public static void main(String[] args) {
        for(int i = 0; i < 6; i ++){//esse for controla a quantidade de vezes que o programa é executado
            int base = 100;
            int potencia = 2;
            int n = (int)Math.pow(base, potencia);//função que vai determinar o tamanho do vetor exponencialmente (iniciando com 10000 posições)
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
            long totmedio = System.currentTimeMillis()-tinibubble; //tempo total do médio caso
            System.out.println("O tempo de execução do médio caso Bubble Sort é: " + totmedio + "ms\n"); //gravar tempo final medio caso
            
            long tinibubble2 = System.currentTimeMillis();
            bubbleSort(vetorBubble);//melhor caso
            long totmelhor = System.currentTimeMillis()-tinibubble2; //tempo total do melhor caso
            System.out.println("O tempo de execução do Melhor caso Bubble Sort é: " + totmelhor + "ms\n");
            //criar cópia ordenada drecrescente do vetor para execução do pior caso
            
            
            
            
            long tiniquick = System.currentTimeMillis();
            quickSort(vetorQuick, 0, vetorQuick.length-1);
            long ttmedioquick = System.currentTimeMillis()-tiniquick;
            System.out.println("O tempo de execução do médio caso Quick Sort é: " + ttmedioquick + "ms\n"); //gravar tempo final medio caso
            
            long tiniquick2 = System.currentTimeMillis();
            quickSort(vetorQuick, 0, vetorQuick.length-1);
            long totmelhor2 = System.currentTimeMillis() - tiniquick2;
            System.out.println("O tempo de execução do Melhor caso Quick Sort é: " + totmelhor2 + "ms\n"); //gravar tempo final medio caso
            
            
            
            long tiniselection = System.currentTimeMillis();
            selectionSort(vetorSelection);
            long ttmedioselec = System.currentTimeMillis()- tiniselection;
            System.out.println("O tempo de execução do médio caso Selection Sort é: " + ttmedioselec + "ms\n"); //gravar tempo final medio caso
            long tiniselection2 = System.currentTimeMillis();
            selectionSort(vetorSelection);
            long ttmelhorselec = System.currentTimeMillis()- tiniselection2;
            System.out.println("O tempo de execução do Melhor caso Selection Sort é: " + ttmelhorselec + "ms\n"); //gravar tempo final medio caso
            
            
            
            
            long tiniinsertion = System.currentTimeMillis();
            insertionSort(vetorInsertion);
            long ttmedioinser = System.currentTimeMillis()- tiniinsertion;
            System.out.println("O tempo de execução do médio caso Insertion Sort é: " + ttmedioinser + "ms\n"); //gravar tempo final medio caso
            long tiniinsertion2 = System.currentTimeMillis();
            insertionSort(vetorInsertion);
            long ttmelhorinser = System.currentTimeMillis()- tiniinsertion2;
            System.out.println("O tempo de execução do médio caso Insertion Sort é: " + ttmelhorinser + "ms\n"); //gravar tempo final medio caso
            
            
            
            //int[] w = new int[n];
            //long tinimerge = System.currentTimeMillis();
            //mergeSort(vetorMerge, 0, vetorMerge.length);
            
            
            
            potencia = 2 + potencia;
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

     public static void mergeSort(int a[], int p, int r) {  
         
        int q;  
        if(p < r){  
            
            q = (p + r)/2;  
            mergeSort(a, p, q);  
            mergeSort(a, q + 1, r);  
            merge(a, p, q, r);  
        }  
    }  
    
    
    public static void merge(int a[], int p, int q, int r){
        
        int i = p, j = q + 1, k, index = p;  
        int temp[] = new int[10];  
        while(i <= q && j <= r){  
            
            if(a[i]<a[j]){  
                temp[index] = a[i];  
                i = i+1;  
            } else{  
                temp[index] = a[j];  
                j = j+1;  
            }  
            index++;  
        }  
        if(i>q){  
            
            while(j<=r){  
                
                temp[index] = a[j];  
                index++;  
                j++;  
            }  
        }  
        else{  
            while(i<=q){  
                
                temp[index] = a[i];  
                index++;  
                i++;  
            }  
        }  
        k = p;  
        while(k<index){  
            a[k]=temp[k];  
            k++;  
        }  
    }      
    }