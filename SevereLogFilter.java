import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SevereLogFilter implements LogFilter {

    @Override
    public void filter(String sourceFile, String targetFile, LogLevel level) {
        int totalLines = 0;
        int matchedLines = 0;

        try (
                FileReader fileReader = new FileReader(sourceFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Scanner scanner = new Scanner(bufferedReader);

                FileWriter fileWriter = new FileWriter(targetFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)
        ) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                totalLines++;

                if (matchesLevel(line, level)) {
                    printWriter.println(line);
                    matchedLines++;
                }
            }

            System.out.println("Фільтрація завершена успішно.");
            System.out.println("Усього рядків прочитано: " + totalLines);
            System.out.println("Рядків записано у файл: " + matchedLines);

        } catch (Exception e) {
            System.out.println("Помилка під час обробки файлу: " + e.getMessage());
        }
    }

    private boolean matchesLevel(String line, LogLevel level) {
        return line.contains(level.getLabel());
    }
}
