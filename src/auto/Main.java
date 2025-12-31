package auto;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] lottoZahlen = new int[6];
        arrayInitializer(lottoZahlen);
        System.out.println("Printing Winning Numbers: \n"+ Arrays.toString(lottoZahlen));
        arraySorter(lottoZahlen);
        System.out.println(Arrays.toString(lottoZahlen));

        int[][] tippKombos = new int[10][6];
        for(int[] arr: tippKombos){
            arrayInitializer(arr);
        }
        System.out.println("\nPrinting Playing Numbers:");
        for(int[] arr: tippKombos){
            System.out.println(Arrays.toString(arr));
        }
        richtigeZahlen(tippKombos, lottoZahlen);
    }

    private static void richtigeZahlen(int[][] tippKombos, int[] lottoZahlen) {
        for (int index = 0; index< tippKombos.length; index++){
            int richtigeZahlen=0;
            for(int i = 0; i< lottoZahlen.length; i++){
                for(int j = 0; j< tippKombos[index].length; j++){
                    if(tippKombos[index][j]== lottoZahlen[i]){
                        richtigeZahlen++;
                    }
                }
            }
            System.out.println("\nIn der Zeile Z"+ (index+1)+ " gibt es "+ richtigeZahlen+ " Richtige");
        }
    }

    public static void arraySorter(int[] myArray){
        for(int i=0; i<myArray.length;i++){
            for(int j=0; j<i;j++){
                if(myArray[j]>myArray[i]){
                    int temp =myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;
                }
            }
        }
    }
    public static void arrayInitializer(int[] myArray){
        Random random = new Random();
        Arrays.fill(myArray, -1);

        for (int i = 0; i < myArray.length;) {
            int number = random.nextInt(10);
            boolean exist = false;

            for (int j : myArray) {
                if (j == number) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                myArray[i] = number;
                i++;
            }
        }
    }
}
