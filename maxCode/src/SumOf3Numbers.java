import java.util.Arrays;
import java.util.Scanner;

public class SumOf3Numbers {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array :");
        int size =sc.nextInt();
        int[] values = new int[size];
        System.out.println("Enter array values :");
        for(int i=0;i<size;i++){
            values[i] = sc.nextInt();
        }
        System.out.println("Enter value of sum :");
        int sum = sc.nextInt();

        boolean result = findSumOf3Number(values,sum);

        if(result){
            System.out.println("Given sum is found by sum of 3 numbers in an array");
        }
        else{
            System.out.println("Not found");
        }
    }

    private static boolean findSumOf3Number(int[] values,int sum){
        Arrays.sort(values);

        for(int i=0;i<values.length-2;i++){
            int l=i+1, r = values.length - 1;
            while(l<r){
                int current_sum = values[i]+values[l]+values[r];
                if(current_sum == sum){
                    return true;
                }
                else if (current_sum < sum){
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return false;
    }
}
