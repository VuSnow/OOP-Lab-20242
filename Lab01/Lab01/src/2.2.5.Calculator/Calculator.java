import javax.swing.JOptionPane;
public class Calculator {
    public static void main(String[] args){
        String strNum1, strNum2;

        String strSum = "Sum = ";
        String strDiff = "Difference = ";
        String strProduct = "Product = ";
        String strQuo = "Quotient = ";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        // calculate sum
        double sum = num1 + num2;
        strSum += sum;

        // calculate difference
        double diff = num1 - num2;
        strDiff += diff;

        // calculate quotient
        if(num2 == 0){
            strQuo += "can not calculate the quotient because the second number is 0.";
        }else{
            double quo = num1/num2;
            strQuo += quo;
        }

        // calculate product
        double pro = num1 * num2;
        strProduct += pro;

        JOptionPane.showMessageDialog(null, strSum + "\n" + strDiff + "\n" + strProduct + "\n" + strQuo + "\n", "show the input", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
