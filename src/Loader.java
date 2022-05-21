import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Практические задачи.2.10.");
//        task1();
        try {
            task2_2();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void task1() {
        System.out.println("Task 1. Вывод четных чисел в диапозоне от 2 до 10");
        for (int i = 2; i <= 10; i += 2) {
            System.out.print(i + ",");
        }
    }

    public static void task2() {
        float weight = 0f, height = 0f;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите вес вашего тела в кг.: ");
        if (scanner.hasNextFloat()) {
            weight = scanner.nextFloat();
        }
        System.out.print("Введите ваш рост в см.: ");
        if (scanner.hasNextFloat()) {
            height = scanner.nextFloat();
            height /= 100;
        }
        float imt = weight / (height * height);
        System.out.printf("Ваш индекс массы тела составляет: %f", imt);

    }

    public static void task2_2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());
        System.out.printf("Ваш вес: %d кг, ваш рост: %d см", weight, height);
    }

    @Override
    public static void task3() {

    }
}
