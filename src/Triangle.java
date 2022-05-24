public class Triangle extends Figure {
    private int a, b, c, h;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = 0;
        calcPerimeter();
    }

    public Triangle(int c, int h) {
        this.a = 0;
        this.b = 0;
        this.c = c;
        this.h = h;
        calcPerimeter();
    }

    private void calcPerimeter() {
        Perimeter = (h == 0) ? (a + b + c) : (2 * Math.sqrt((c * c) / 4 + h * h) + c);
    }
}
