public class Square extends Figure {
    private int a;

    public Square(int a) {
        this.a = a;
        calcPerimeter();
    }

    private void calcPerimeter() {
        Perimeter = 4 * a;
    }
}
