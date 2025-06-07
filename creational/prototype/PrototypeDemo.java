// Prototype interface
interface Shape {
  Shape cloneShape();
  void display();
}

// Concrete Prototype: Circle
class Circle implements Shape {
  private int x, y, radius;

  public Circle(int x, int y, int radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  // Copy constructor
  public Circle(Circle source) {
    this.x = source.x;
    this.y = source.y;
    this.radius = source.radius;
  }

  @Override
  public Shape cloneShape() {
    return new Circle(this);
  }

  @Override
  public void display() {
    System.out.println("Circle at (" + x + "," + y + "), radius " + radius);
  }
}

// Concrete Prototype: Rectangle
class Rectangle implements Shape {
  private int width, height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public Rectangle(Rectangle source) {
    this.width = source.width;
    this.height = source.height;
  }

  @Override
  public Shape cloneShape() {
    return new Rectangle(this);
  }

  @Override
  public void display() {
    System.out.println("Rectangle " + width + "x" + height);
  }
}

// Demo
public class PrototypeDemo {
  public static void main(String[] args) {
    Shape circle1 = new Circle(10, 20, 30);
    Shape circle2 = circle1.cloneShape();

    Shape rect1 = new Rectangle(40, 50);
    Shape rect2 = rect1.cloneShape();

    circle1.display();
    circle2.display();
    rect1.display();
    rect2.display();
  }
}
