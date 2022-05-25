import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Loader {
    static Random rand = new Random();
    static int randInt;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Практические задачи.2.10.");
        //task1();
        //       task2();
//        task4();
//        task4_2();
//        task5();
//        task7();
//        task8();
//        task9();
//        task10();
        //    task13();
        task14();
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

        Perimeter triangle = new Perimeter("triangle", tra, trb, tra);
        Perimeter triangleH = new Perimeter("triangle", trb, trh);
        Perimeter square = new Perimeter("square", sqa);
        Perimeter circle = new Perimeter("circle", rd);

        System.out.println("Perimetr triangle: " + triangle.getP());
        System.out.println("Perimetr triangle: " + triangleH.getP());
        System.out.println("Perimetr square: " + square.getP());
        System.out.println("Perimetr circle: " + circle.getP());

        Circle circle2 = new Circle(rd);
        System.out.println("Perimetr circle: " + circle2.getPerimeter());
        Square square2 = new Square(sqa);
        System.out.println("Perimetr square: " + square2.getPerimeter());
        Triangle triangle2 = new Triangle(tra, tra, trb);
        System.out.println("Perimetr triangle: " + triangle2.getPerimeter());
        Triangle triangleH2 = new Triangle(trb, trh);
        System.out.println("Perimetr triangle: " + triangleH2.getPerimeter());
    }

    public static void task8() {
//        DecimalFormat dF = new DecimalFormat("0.00");
        double min = 0, max = 2 * Math.PI, step = Math.PI / 18;
        double sinCosY, cosSinY;

        for (double x = min; x <= max; x += step) {
            sinCosY = Math.sin(Math.cos(x));
            cosSinY = Math.cos(Math.sin(x));
            if (sinCosY > cosSinY)
                System.out.printf("sin(cos(x)) = %.2f больше cos(sin(x)) = %.2f%n", sinCosY, cosSinY);
            else if (sinCosY < cosSinY)
                System.out.printf("sin(cos(x)) = %.2f меньше cos(sin(x)) = %.2f%n", sinCosY, cosSinY);
            else System.out.printf("sin(cos(x)) = %.2f равно cos(sin(x)) = %.2f%n", sinCosY, cosSinY);
//            System.out.print(dF.format(+" ");
        }
    }

    public static void task9() {
        int j, iterN = 0;
        int[] arrNum = new int[100];
        arrNum[0] = 1;
        arrNum[1] = 2;
        for (int n = 3, i = 2; n <= 100; i++, n += 2) arrNum[i] = n;
        System.out.println(Arrays.toString(arrNum));
        int i = 2;
        while (arrNum[i] <= 10) {
            if (arrNum[i] != 0)
                for (j = i + 1; j < arrNum.length; j++) {
                    if ((arrNum[j] % arrNum[i]) == 0) arrNum[j] = 0;
                }
            i++;
        }
        System.out.println(Arrays.toString(arrNum));
        for (i = 0; i < arrNum.length; i++) if (arrNum[i] != 0) iterN++;
        int[] arrSimpleNum = new int[iterN];
        j = 0;
        for (i = 0; i < arrNum.length; i++) if (arrNum[i] != 0) arrSimpleNum[j++] = arrNum[i];
        System.out.println(Arrays.toString(arrSimpleNum));
    }

    public static void task10() {
        int age;

        System.out.print("Введите возраст клиента: ");
        age = scanner.nextInt();
        if (age < 14) System.out.println("прокол ушей в присутствии родителей;");
        else if (age < 18) System.out.println("прокол ушей, пупка, языка, носа в присутствии родителей;");
        else System.out.println("без ограничений.");
    }

    public static void task13() {
        for (int lVedro1 = 30, lVedro2 = 0, lMimo = 0; lVedro1 > 0; ) {
            lVedro1--;
            lMimo++;
            System.out.printf("%d порция, 1-ое ведро %d литров, ", lMimo, lVedro1);
            if (lMimo == 10) {
                lMimo = 0;
                System.out.printf("2-ое ведро %d литров.%n", lVedro2);
                continue;
            }
            lVedro2++;
            System.out.printf("2-ое ведро %d литров.%n", lVedro2);
        }
    }

    public static void task14() {
        Cat barsik = new Cat("Barsik");
        System.out.println(barsik.name + " weight: "+barsik.weight+" age: "+barsik.age);
    }
}

