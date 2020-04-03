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
            gerarVetor(n); //esse método vai gerar o vetor com a quantidade n e irá preencher todo o vetor com números de 0 a 999;
            
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
    
    private static void bubbleSort(int[] v){
        for(int ultimo = v.length-1; ultimo > 0; ultimo--){ // O(n^2)
            for(int i = 0; i < ultimo; i++){
                if (v[i] > v[i+1]){
                    trocar (v , i , i+1);
                }
            }
        }
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
        
    }
    
 