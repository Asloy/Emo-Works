/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodsactivity;

/**
 *
 * @author Emo_CPE*/
 
import javax.swing.JOptionPane;

public class ConicSectionsCalculator {
    public static void main(String[] args) {
        // Prompt user to enter the coefficients of the conic section equation using JOptionPane
        JOptionPane.showMessageDialog(null, "Please enter the coefficients of the conic section equation in the following format:\nAx^2 + Bxy + Cy^2 + Dx + Ey + F = 0\n(For example, for x^2 + y^2 = 25, enter 1 0 1 0 0 -25)");

        // Prompt user to enter the coefficients using JOptionPane
        String input = JOptionPane.showInputDialog(null, "Enter coefficients separated by spaces:");

        // Split the input string to extract coefficients
        String[] coefficients = input.split(" ");

        // Parse coefficients from the input string
        double A = Double.parseDouble(coefficients[0]);
        double B = Double.parseDouble(coefficients[1]);
        double C = Double.parseDouble(coefficients[2]);
        double D = Double.parseDouble(coefficients[3]);
        double E = Double.parseDouble(coefficients[4]);
        double F = Double.parseDouble(coefficients[5]);

        // Determine the type of conic section based on the equation
        String resultMessage = "";
        if (B * B - 4 * A * C > 0) {
            resultMessage = "This equation represents a hyperbola.";
            resultMessage += "\nCoordinates on the hyperbola:\n" + calculateHyperbola(A, B, C, D, E, F);
        } else if (B * B - 4 * A * C == 0) {
            if (A == C) {
                resultMessage = "This equation represents a circle.";
                resultMessage += "\nCoordinates on the circle:\n" + calculateCircle(A, B, C, D, E, F);
            } else {
                resultMessage = "This equation represents an ellipse.";
                resultMessage += "\nCoordinates on the ellipse:\n" + calculateEllipse(A, B, C, D, E, F);
            }
        } else {
            resultMessage = "This equation represents a parabola.";
            resultMessage += "\nCoordinates on the parabola:\n" + calculateParabola(A, B, C, D, E, F);
        }

        // Show the result using JOptionPane
        JOptionPane.showMessageDialog(null, resultMessage);
    }

    public static String calculateCircle(double A, double B, double C, double D, double E, double F) {
        double h = -D / (2 * A);
        double k = -E / (2 * C);
        double rSquared = F + (D * D) / (4 * A) + (E * E) / (4 * C);
        double r = Math.sqrt(rSquared);

        StringBuilder coordinates = new StringBuilder();
        for (double theta = 0; theta <= 2 * Math.PI; theta += 0.1) {
            double x = h + r * Math.cos(theta);
            double y = k + r * Math.sin(theta);
            coordinates.append("(").append(x).append(", ").append(y).append(")\n");
        }
        return coordinates.toString();
    }

    public static String calculateEllipse(double A, double B, double C, double D, double E, double F) {
        double h = -D / (2 * A);
        double k = -E / (2 * C);
        double aSquared = -F / A + h * h;
        double bSquared = -F / C + k * k;
        double a = Math.sqrt(aSquared);
        double b = Math.sqrt(bSquared);

        StringBuilder coordinates = new StringBuilder();
        for (double theta = 0; theta <= 2 * Math.PI; theta += 0.1) {
            double x = h + a * Math.cos(theta);
            double y = k + b * Math.sin(theta);
            coordinates.append("(").append(x).append(", ").append(y).append(")\n");
        }
        return coordinates.toString();
    }

    public static String calculateHyperbola(double A, double B, double C, double D, double E, double F) {
        double h = -D / (2 * A);
        double k = -E / (2 * C);
        double aSquared = F / A - h * h;
        double bSquared = -F / C + k * k;
        double a = Math.sqrt(aSquared);
        double b = Math.sqrt(bSquared);

        StringBuilder coordinates = new StringBuilder();
        for (double theta = 0; theta <= 2 * Math.PI; theta += 0.1) {
            double x = h + a * Math.cosh(theta);
            double y = k + b * Math.sinh(theta);
            coordinates.append("(").append(x).append(", ").append(y).append(")\n");
        }
        return coordinates.toString();
    }

    public static String calculateParabola(double A, double B, double C, double D, double E, double F) {
        double a;
        String coordinates = "";

        if (A == 0) {
            a = -F / (4 * C);
            for (double y = -10; y <= 10; y += 0.5) {
                double x = (y * y) / (4 * a);
                coordinates += "(" + x + ", " + y + ")\n";
            }
        } else {
            a = -F / (4 * A);
            for (double x = -10; x <= 10; x += 0.5) {
                double y = (x * x) / (4 * a);
                coordinates += "(" + x + ", " + y + ")\n";
            }
        }
        return coordinates;
    }
}