import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class History {
    public void saveHistoryItem(String item) {
        File file = new File("history.txt");
        FileWriter fr = null;

        String out = "";

        try {

            if (file.exists()) {
                out = getLastLines(file, 4);
            }
            fr = new FileWriter(file);

            if (out.length() > 0){
                fr.write(String.format("%s%s", out, item));
            } else {
                fr.write(String.format("%s", item));
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHistory() throws IOException {
        File file = new File("history.txt");
        StringBuilder buffer = new StringBuilder();
        if (file.exists()) {
            Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
            while (sc.hasNextLine()){
                buffer.append(sc.nextLine());
                buffer.append(System.lineSeparator());
            }
            return buffer.toString();
        } else {
            return "No history saved yet!";
        }
    }

    private String getLastLines(File file, int num) throws IOException {
        Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
        int counter = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            counter++;
        }

        counter -= num;

        sc = new Scanner(file, StandardCharsets.UTF_8);

        while (counter > 0) {
            sc.nextLine();
            counter--;
        }

        StringBuilder outString = new StringBuilder();

        while (sc.hasNextLine()) {
            outString.append(sc.nextLine());
            outString.append(System.lineSeparator());
        }

        sc.close();

        return outString.toString();
    }
}
