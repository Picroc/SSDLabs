import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInputHandler {
    SimpleCalculator calculator;
    History history;

    public UserInputHandler() {
        calculator = new SimpleCalculator();
        history = new History();
    }

    public void startSession() throws IOException {
        String buffer = "";
        Scanner sc = new Scanner(System.in);

        boolean isExit = false;

        while(!isExit) {
            System.out.print("Input cmd (calc, hist, exit): ");
            buffer = sc.next();
            switch (buffer) {
                case "calc":
                    double a, b;
                    String op = "";

                    System.out.print("First value: ");
                    a = sc.nextDouble();

                    System.out.print("Operator: ");
                    op = sc.next();

                    System.out.print("Second value: ");
                    b = sc.nextDouble();

                    double result = calculator.calculate(a, b, op);
                    String res_string = String.format("%f %s %f = %f", a , op , b, result);

                    history.saveHistoryItem(res_string);

                    System.out.println(res_string);
                    break;
                case "hist":
                    String hist = history.getHistory();
                    System.out.println(hist);
                    break;
                case "exit":
                    isExit = true;
                    break;
                default:
                    System.out.println("Command not recognised");
            }
        }
    }
}
