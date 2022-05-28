public class Tamagochi {
    public int iterN;
    public boolean isExit = false;
    Cat cat;

    public Tamagochi(String name) {
        cat = new Cat(name);
        this.iterN = 0;
    }

    public void status() {
        System.out.printf("Cat: %s, Возраст: %d, Вес: %f.%n", cat.name, cat.age, cat.weight);
        System.out.println(" Насыщен пищей от 0 (очень голоден) до 100 (сытый) -> " + cat.health);
        System.out.println(" Хочет играть от 0 (очень хочет) до 100 (отвали) -> " + cat.toPlay);
    }

    public void menu() {
        String str;
        addIterN();
        cat.lossWeight();
        System.out.println("Введите цифру от 1 до 3 для выбора пункта меню:");
        System.out.println("1. Состояние кота (кошки).");
        System.out.println("2. Кормить кота (кошку).");
        System.out.println("3. Играть с котом (кошкой).");
        System.out.println("S. Выход - нажмите 's'.");
        System.out.print(">>>");
        str = Loader.scanner.next();
        switch (str) {
            case "1":
                status();
                System.out.println();
                menu();
                break;
            case "2":
                feed();
                break;
            case "3":
                toPlayWithCat();
                break;
            case "s":
            case "S":
            case "Ы":
            case "ы":
                exit();
                break;
            default:
                menu();
        }
    }

    public void addIterN() {
        if ((++this.iterN) == 20) {
            cat.age++;
            this.iterN = 0;
        }
    }

    public void feed() {
        String str;
        Food food;

        System.out.println();
        System.out.println("Введите цифру от 1 до 3 для выбора еды:");
        System.out.println("1. Кошачий корм. Вес 100г., сытность - 10.");
        System.out.println("2. Молоко. Вес 200г, сытность - 20.");
        System.out.println("3. Живая мышь. Вес 50г, сытность - 5.");
        System.out.print(">>>");
        str = Loader.scanner.next();
        switch (str) {
            case "1":
                food = new Food("wiskas",0.1f,10);
                break;
            case "2":
                food = new Food("milk",0.2f,20);
                break;
            case "3":
                food = new Food("mouse",0.05f,5);
                break;
            default:
                food = new Food("mice",0.5f,50);
        }

        if (!cat.feedCat(food)) System.out.println("Кот сыт и не хочеть есть.");
        menu();
    }

    public void toPlayWithCat() {
        if (cat.health < 20) System.out.println("Кот не хочет играть, потому что голоден.");
        else if (cat.health > 90) System.out.println("Кот не хочет играть, потому что наелся.");
        else if (cat.toPlay == 100) System.out.println("Кот не хочет играть, потому что набегался.");
        else cat.toPlay();
        menu();
    }

    public void exit() {
        this.isExit = true;
    }
}
