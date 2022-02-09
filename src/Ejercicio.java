import java.util.Scanner;

public class Ejercicio {

    static int[] arreglo;

    public static void main(String... args){

        Scanner entrada = new Scanner(System.in);
        System.out.println("INGRESE EL TAMAÑO DEL ARREGLO:");
        int valor = entrada.nextInt();
        arreglo = new int[valor];

        for(int i = 0; i < arreglo.length; i++){
            int aleatorio = (int)(Math.random()*10000);
            push(aleatorio, i);


        }

        System.out.println("\n\nIMPRIMIENDO EL ARREGLO ORDENADO:");
        for(int i = 0; i < arreglo.length; i++){
            System.out.print(" - "+arreglo[i]+" - ");
        }

        System.out.println("\nINGRESE EL NÚMERO A BUSCAR:");
        valor = entrada.nextInt();

        int pasos = binarySearch(valor);
        System.out.println("PASOS TOTALES PARA ENCONTRAR EL VALOR: "+pasos);

    }

    /**
     *
     * @param dato
     * @param indice
     */
    public static void push(int dato, int indice){

        System.out.println("VALOR ALEATORIO= "+dato);
        if(indice == 0){
            arreglo[indice] = dato;
        } else {

            ordenamiento(dato, indice);
        }
    }

    /**
     *
     * @param dato
     * @param indice
     */
    public static void ordenamiento(int dato, int indice){

        for(int i = 0; i < indice+1; i++){

            if(dato <= arreglo[i] && i < indice){

                for(int j = indice; j>i; j--){

                    arreglo[j] = arreglo[j-1];

                }
                arreglo[i] = dato;

                break;

            } else{

                if(indice == i){
                    arreglo[indice] = dato;
                }
            }
        }

    }

    public static int binarySearch(int valor){

        int pasos = 0;
        int limInf = 0;
        int limSup = arreglo.length;
        int busqueda = (limSup + limInf) / 2;
        boolean encontrado = false;

        do{
            System.out.println(arreglo[busqueda]+" - "+valor);
            if(arreglo[busqueda] > valor){
                pasos++;
                if((limSup == arreglo.length) && (busqueda - limInf == 1)){
                    break;
                } else {
                    limSup = busqueda;
                }
            } else if (arreglo[busqueda] < valor){
                pasos++;
                if((limSup - busqueda == 1) && (limInf == 0)){
                    break;
                } else {
                    limInf = busqueda;
                }
            } else {
                pasos++;
                encontrado = true;
            }
            busqueda = (limSup + limInf) / 2;
        }while(!encontrado);

        return pasos;
    }
}