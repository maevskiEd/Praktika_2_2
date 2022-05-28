public class Cat {
    public String name;
    public int health;
    public int toPlay;
    public float weight;
    public int age;
    private int randInt;

    public Cat(String name) {
        this.name = name;
        this.weight = 30;
        this.age = 0;
    }

    public void lossWeight() {
        randInt = Loader.rand.nextInt(100) + 1;
        this.weight = (this.weight - randInt / 1000) > 0 ? this.weight - randInt / 1000 : 0;
        this.health = (this.health - (int) randInt / 10) > 0 ? this.health - (int) randInt / 10 : 0;
        ;
    }

    public boolean feedCat(Food food) {
        if (this.health < 50) {
            this.weight += food.weight;
            this.health = (this.health + food.fullness) <= 100 ? this.health + food.fullness : 100;
            return true;
        }
        return false;
    }

    public void toPlay() {
        randInt = Loader.rand.nextInt(10) + 1;
        this.toPlay = (this.toPlay + randInt) <= 100 ? this.toPlay + randInt : 100;
        lossWeight();
    }
}
