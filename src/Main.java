import java.io.*;
import java.util.Arrays;

public class Main {
    public static boolean isRussianVowel(char letter) {
        String vowels = "аеёиоуыэюя";
        char lowerCaseLetter = Character.toLowerCase(letter);
        return vowels.contains(Character.toString(lowerCaseLetter));
    }
    public static void main(String[] args) {
        int count = 0;
        String line = "";
        try (FileReader reader = new FileReader("textInput.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) != -1) {
                line += new String(Arrays.copyOf(buf, c));
            }
            System.out.print(line);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        for(char symbol : line.toCharArray()) {
            if (isRussianVowel(symbol)) {
                count++;
            }
        }

        try(FileWriter writer = new FileWriter("output.txt", false)) {
            writer.write("Количество гласных в строке: " + count);
            writer.flush();
            System.out.println("Количество гласных в строке: " + count);

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }





    }
}
