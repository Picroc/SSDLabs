import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello! Welcome to SimpleCalculator.");

        UserInputHandler ui = new UserInputHandler();
        ui.startSession();
    }
}
