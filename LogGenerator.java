import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;

public class LogGenerator {

    public static void generateSampleLog(String fileName) {
        try (
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)
        ) {
            printWriter.println("1 " + Instant.now() + " [INFO] AuthModule User login successful");
            printWriter.println("2 " + Instant.now() + " [DEBUG] PaymentModule Payment validation started");
            printWriter.println("3 " + Instant.now() + " [ERROR] DatabaseModule Database connection failed");
            printWriter.println("4 " + Instant.now() + " [WARNING] SecurityModule Suspicious login attempt");
            printWriter.println("5 " + Instant.now() + " [CRITICAL] CoreModule System failure detected");
            printWriter.println("6 " + Instant.now() + " [INFO] ReportModule Daily report created");
            printWriter.println("7 " + Instant.now() + " [ERROR] NetworkModule Timeout while sending request");
            printWriter.println("8 " + Instant.now() + " [DEBUG] CacheModule Cache refreshed");
            printWriter.println("9 " + Instant.now() + " [WARNING] StorageModule Disk usage is high");
            printWriter.println("10 " + Instant.now() + " [CRITICAL] BackupModule Backup process failed");

            System.out.println("Файл журналу " + fileName + " успішно згенеровано.");
        } catch (Exception e) {
            System.out.println("Помилка генерації журналу: " + e.getMessage());
        }
    }
}
