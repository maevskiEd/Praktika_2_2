public class Circle extends Figure {
    private int r;

    public Circle(int r) {
        this.r = r;
        calcPerimeter();
    }

    private void calcPerimeter() {
        Perimeter = 2 * Math.PI * r;
    }
}
