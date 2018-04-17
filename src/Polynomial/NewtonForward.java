package Polynomial;
import java.lang.Math;
import java.util.*;

public class NewtonForward {

    int pairs = 10;
    double x0 = 2.0;
    double xn = 4.0;
    double h = (xn-x0)/pairs;

    double[] x = new double[pairs];
    double[] y = new double[pairs];
    double y0;

    public void generateXValues(){
        int j = 0;
        for(double i = this.x0; i <= this.xn; i += this.h){
            this.x[j] = Math.round(i*100)/100.0;
            j++;
        }
    }

    public void generateYValues(){
        for (int i = 0; i < this.x.length; i++){
            y[i] = Math.round((Math.pow(Math.E,this.x[i])*1000000000))/1000000000.0;
        }
        this.y0 = y[0];
    }

    public double[] generateNextYValues(double[] y){
        double[] next_y = new double[(y.length-1)];
        for (int i = 0; i < (y.length-1); i++){
            next_y[i] = (y[i+1] - y[i]);
        }

        return next_y;
    }

    public void generatePolynomial(double x_value){
        this.generateXValues();
        System.out.print("X: ");
        for (double i:this.x) {
            System.out.print(i + " , ");
        }
        System.out.println();
        this.generateYValues();
        System.out.print("Y: ");
        for (double i:this.y) {
            System.out.print(i + " , ");
        }

        double polynomial = 0;
        double p = (x_value - this.x0)/this.h;
        int i = 0;
        while (true){
            double[] y_values = generateNextYValues(this.y);
            //System.out.print(y_values.length + " , ");
            polynomial += (this.pValues(i,p)*y_values[0])/this.factorial(i+1);
            this.y = y_values;
            i++;
            if (y_values.length == 1){
                break;
            }

        }
        System.out.println();
        System.out.println("The Polynomial is: "  + Math.round((y0 + polynomial)*10000)/10000.0);
    }

    public int factorial(int x){
        int fact = x;
        for (int i=1;i<x;i++){
            fact *= i;
        }
        return fact;
    }

    public double pValues(int i, double p){
        double pValue = 1;
        for (int j=0;j<=i;j++){
            pValue *= (p-j);
        }
        return pValue;
    }
}
