import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.jar.Attributes;

public class SortedArray {
    public static void main(String[] args){
        Object[] options = {"Default", "New Array"};
        int option = JOptionPane.showOptionDialog(null, "Do you want to use default array or input a new array?",
                "chosing option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
        System.out.println(option);
        int sum = 0;
        if(option == 0){
            int[] defaultArray = {1789, 2035, 1899, 1456, 2013};
            int n = defaultArray.length;
            System.out.println("Array before sorting: " + Arrays.toString(defaultArray));
            Arrays.sort(defaultArray);
            for(int i = 0; i < n; i++){
                sum += defaultArray[i];
            }
            System.out.println("Array after sorting: " + Arrays.toString(defaultArray));
            System.out.println("Sum = " + sum);
            System.out.println("Average = " + sum/n);
        }else{
            boolean isValid = false;
            int n = 0;
            do{
                String input_n = JOptionPane.showInputDialog(null, "Input the size of your array: n = ", "Input size", JOptionPane.INFORMATION_MESSAGE);
                try{
                    n = Integer.parseInt(input_n);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "The size must be an integer!!!");
                }finally {
                    if(n > 0){
                        isValid = true;
                    }
                }
            }while (!isValid);

            int[] inputArray = new int[n];
            Scanner sc = new Scanner(System.in);
            for(int i = 0; i < n; i++){
                inputArray[i] = sc.nextInt();
                sum += inputArray[i];
            }
            System.out.println("Array before sorting: " + Arrays.toString(inputArray));
            Arrays.sort(inputArray);
            System.out.println("Array after sorting: " + Arrays.toString(inputArray));
            System.out.println("Sum = " + sum);
            System.out.println("Average = " + sum/n);
        }
    }
}
