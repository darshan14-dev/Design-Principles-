abstract class ShapeApplication {
    public void run() {
        Shape s = createShape();
        s.draw();
    }

    protected abstract Shape createShape();
}


class CircleApp extends ShapeApplication {
    protected Shape createShape() {
        return new Circle();
    }
}

ShapeApplication app = new CircleApp();
app.run();
