public class Perimeter {
    private String nmFigure;
    private int a;
    private int b;
    private int c;
    private int h;
    private int r;
    private double P;

    public double getP() {
        return P;
    }


    public Perimeter(String nmFigure, int a, int b, int c) {
        this.nmFigure = nmFigure;
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
        P = calcPerimeter();
    }

    public Perimeter(String nmFigure, int c, int h) {
        this.nmFigure = nmFigure;
        this.c = c;
        this.h = h;
        P = calcPerimeter();
    }

    public Perimeter(String nmFigure, int a) {
        this.nmFigure = nmFigure;
        if (nmFigure == "circle") this.r = a;
        if (nmFigure == "square") this.a = a;
        P = calcPerimeter();
    }

    private double calcPerimeter() {
        return switch (nmFigure) {
            case "triangle" -> ((h == 0) ? (a + b + c) : (2 * Math.sqrt((c * c) / 4 + h * h) + c));
            case "square" -> (4 * a);
            case "circle" -> (2 * Math.PI * r);
            default -> 0;
        };
    }
}
