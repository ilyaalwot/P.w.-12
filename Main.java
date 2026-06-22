import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LogFilter filter = new SevereLogFilter();

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Згенерувати тестовий log-файл");
            System.out.println("2. Відфільтрувати log-файл");
            System.out.println("0. Вийти");
            System.out.print("Ваш вибір: ");

            int choice = Integer.parseInt(console.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Введіть ім'я файлу для генерації (наприклад sample.log): ");
                    String generatedFile = console.nextLine();
                    LogGenerator.generateSampleLog(generatedFile);
                    break;

                case 2:
                    System.out.print("Введіть шлях до вхідного log-файлу: ");
                    String sourceFile = console.nextLine();

                    System.out.print("Введіть шлях до вихідного файлу: ");
                    String targetFile = console.nextLine();

                    System.out.println("Оберіть рівень логування:");
                    System.out.println("1 - CRITICAL");
                    System.out.println("2 - ERROR");
                    System.out.println("3 - WARNING");
                    System.out.println("4 - INFO");
                    System.out.println("5 - DEBUG");
                    System.out.print("Ваш вибір: ");

                    int levelChoice = Integer.parseInt(console.nextLine());
                    LogLevel level = getLogLevel(levelChoice);

                    if (level == null) {
                        System.out.println("Невірний вибір рівня логування.");
                    } else {
                        filter.filter(sourceFile, targetFile, level);
                    }
                    break;

                case 0:
                    System.out.println("Завершення програми...");
                    console.close();
                    return;

                default:
                    System.out.println("Невірний пункт меню.");
            }
        }
    }

    private static LogLevel getLogLevel(int choice) {
        switch (choice) {
            case 1:
                return LogLevel.CRITICAL;
            case 2:
                return LogLevel.ERROR;
            case 3:
                return LogLevel.WARNING;
            case 4:
                return LogLevel.INFO;
            case 5:
                return LogLevel.DEBUG;
            default:
                return null;
        }
    }
}
