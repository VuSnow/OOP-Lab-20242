import javax.swing.JOptionPane;
public class SolveEquation {
    public static void main(String[] args){
        String choice;
        choice = JOptionPane.showInputDialog(null, "Choose the type of equation: \n1.First-degree equation with one variable. (ax + b = 0)\n2.Second-degree equation with one variable. (ax^2+bx+c=0)", "Input the type of equation", JOptionPane.INFORMATION_MESSAGE);

        int choice_int = Integer.parseInt(choice);
        if(choice_int == 1){
            String a = JOptionPane.showInputDialog(null, "Input a = ", "Input the first coefficient", JOptionPane.INFORMATION_MESSAGE);
            double a_dou = Double.parseDouble(a);

            String b = JOptionPane.showInputDialog(null, "Input b = ", "Input the second coefficient", JOptionPane.INFORMATION_MESSAGE);
            double b_dou = Double.parseDouble(b);

            if(a_dou == 0){
                if(b_dou != 0){
                    JOptionPane.showMessageDialog(null, "This equation has no solution", "solution", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "This equation has infinite solution", "solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                double solution = (-1) * b_dou / a_dou;
                JOptionPane.showMessageDialog(null, "This equation has 1 solution: \nx = " + solution, "solution", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(choice_int == 2){
            String a = JOptionPane.showInputDialog(null, "Input a = ", "Input the first coefficient", JOptionPane.INFORMATION_MESSAGE);
            double a_dou = Double.parseDouble(a);

            String b = JOptionPane.showInputDialog(null, "Input b = ", "Input the second coefficient", JOptionPane.INFORMATION_MESSAGE);
            double b_dou = Double.parseDouble(b);

            String c = JOptionPane.showInputDialog(null, "Input c = ", "Input the third coefficient", JOptionPane.INFORMATION_MESSAGE);
            double c_dou = Double.parseDouble(c);

            if(a_dou == 0){
                if(b_dou == 0){
                    if(c_dou == 0){
                        JOptionPane.showMessageDialog(null, "This equation has infinite solution", "solution", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "This equation has no solution","solution", JOptionPane.INFORMATION_MESSAGE) ;
                    }
                }else{
                    double result = (-1) * c_dou / b_dou;
                    JOptionPane.showMessageDialog(null, "This equation has 1 solution: \nx = " + result, "solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                double delta = b_dou * b_dou - 4 * a_dou * c_dou;
                if(delta < 0){
                    JOptionPane.showMessageDialog(null, "This equation has no solution","solution", JOptionPane.INFORMATION_MESSAGE) ;
                }else if(delta == 0){
                    double result = (-1) * b_dou / (2 * a_dou);
                    JOptionPane.showMessageDialog(null, "This equation has 1 solution: \nx = " + result, "solution", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    double x1 = ((-1) * b_dou + Math.sqrt(delta))/(2 * a_dou);
                    double x2 = ((-1) * b_dou - Math.sqrt(delta))/(2 * a_dou);
                    JOptionPane.showMessageDialog(null, "This equation has 2 solution: \nx1 = " + x1 + "\nx2 = " + x2, "solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
        System.exit(0);
    }
}
