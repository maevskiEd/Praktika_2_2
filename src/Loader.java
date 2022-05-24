import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Loader {
    static Random rand = new Random();
    static int randInt;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Практические задачи.2.10.");
        task1();
        //       task2();
//        task4();
//        task4_2();
//        task5();
        task7();
/*
        try {
            task2_2();
        } catch (Exception e) {
            e.printStackTrace();

        }
*/
    }

    public static void task1() {
        System.out.println("Task 1. Вывод четных чисел в диапозоне от 2 до 10");
        for (int i = 2; i <= 10; i += 2) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void task2() {
        float weight = 0f, height = 0f;

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
        System.out.println();
        if (imt <= 16) System.out.println("У дефицит массы тела");
        else if (imt <= 18) System.out.println("У вас недостаточная масса тела");
        else if (imt <= 25) System.out.println("Масса тела - норма");
        else if (imt <= 30) System.out.println("Избыточная масса тела (состояние предшествующее ожирению)");
        else if (imt <= 35) System.out.println("Ожирение 1-ой степени");
        else if (imt <= 40) System.out.println("Ожирение 2-ой степени");
        else System.out.println("Ожирение 3-ей степени");
    }

    public static void task2_2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());
        System.out.printf("Ваш вес: %f кг, ваш рост: %f см", weight, height);
    }

    public static void task4() {
        int nm1;
        randInt = rand.nextInt(10) + 1;

        do {
            System.out.println("Угадайте число. Введите число от 1 до 10: ");
            nm1 = scanner.nextInt();
            if (nm1 == randInt) System.out.println("Вы угадали число. Оно равно: " + randInt);
            else if (nm1 > randInt) System.out.println("Загаданное число меньше.");
            else System.out.println("Загаданное число больше.");
        } while (nm1 != randInt);
    }

    public static void task4_2() {
        int nm2, p, min, max;

        System.out.print("Введите количество попыток: ");
        p = scanner.nextInt();
        System.out.print("Введите нижнюю границу угадываемого диапозона: ");
        min = scanner.nextInt();
        System.out.print("Введите верхнюю границу угадываемого диапозона: ");
        max = scanner.nextInt();

        randInt = rand.nextInt(max - min) + min;
        do {
            System.out.printf("Угадайте число. У вас %d попыток. Введите число от %d до %d: ", p, min, max);
            nm2 = scanner.nextInt();
            if (nm2 == randInt) System.out.println("Вы угадали число. Оно равно: " + randInt);
            else if (nm2 > randInt) System.out.println("Загаданное число меньше.");
            else System.out.println("Загаданное число больше.");
            p -= 1;
            if (p == 0) System.out.println("У вас закончились попытки.");
        } while (nm2 != randInt && p > 0);
    }

    public static void task5() {
        Fighter fRed = new Fighter("red");
        Fighter fBlue = new Fighter("blue");
        System.out.println("Name: " + fRed.getName() + " health: " + fRed.getHealth() + " damage:" + fRed.getDamage());
        System.out.println("Name: " + fBlue.getName() + " health: " + fBlue.getHealth() + " damage:" + fBlue.getDamage());
        fight(fRed, fBlue);
        if (!fRed.alive) System.out.println("Красный боец проиграл.");
        if (!fBlue.alive) System.out.println("Синий боец проиграл.");
    }

    private static void fight(Fighter left, Fighter right) {
        while (left.alive && right.alive) {
            left.hit(right.getDamage());
            left.alive = (left.getHealth() <= 0) ? false : true;
            right.hit(left.getDamage());
            right.alive = (right.getHealth() <= 0) ? false : true;
//            System.out.println("Name: " + left.getName() + " health: " + left.getHealth() + " damage:" + left.getDamage());
//            System.out.println("Name: " + right.getName() + " health: " + right.getHealth() + " damage:" + right.getDamage());
        }
    }

    public static void task7() {
        int tra = 5, trb = 6, trh = 4, sqa = 5, rd = 7;

        Perimeter triangle = new Perimeter("triangle",tra,trb,tra);
        Perimeter triangleH = new Perimeter("triangle",trb,trh);
        Perimeter square = new Perimeter("square",sqa);
        Perimeter circle = new Perimeter("circle",rd);

        System.out.println("Perimetr triangle: " + triangle.getP());
        System.out.println("Perimetr triangle: " + triangleH.getP());
        System.out.println("Perimetr square: " + square.getP());
        System.out.println("Perimetr circle: " + circle.getP());

        Circle circle2 = new Circle(rd);
        System.out.println("Perimetr circle: " + circle2.getPerimeter());
    }
}

