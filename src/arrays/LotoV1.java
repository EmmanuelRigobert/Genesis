package arrays;

import java.util.Arrays;
import java.util.Random;

public class LotoV1 {
    public static void main(String[] args){
        int[] lottoZahlen = new int[6];
        for(int i=0; i <6; i++){
            lottoZahlen[i]= 1 + new Random().nextInt(49);
            System.out.println(lottoZahlen[i]);
            for(int j=0; j<i;j++){
                if(lottoZahlen[j]==lottoZahlen[i]){
                    System.out.println("Element " + lottoZahlen[i] + " already exist. Selecting another...");
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lottoZahlen);
        System.out.println(Arrays.toString(lottoZahlen));
    }
}
