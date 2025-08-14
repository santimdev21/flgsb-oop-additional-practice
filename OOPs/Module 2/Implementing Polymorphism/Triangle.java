// Triangle class - a subclass of Shape
public class Triangle extends Shape {
    // Step 1: Declare private variables for the three sides
    // Hint: Use double for side1, side2, and side3
    private double side1;
    private double side2;
    private double side3;

    // Step 2: Create a constructor that takes name, color, and three sides as parameters
    // Hint: Use super() to call the parent constructor and then initialize the sides
    public Rectangle(String name, String color, double side1, double side2, double side3) {
        super(name, color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Step 3: Create getter methods for the three sides
    // Hint: public double getSide1(), getSide2(), and getSide3()
    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    // Step 4: Override the area() method to calculate the area of a triangle
    // Hint: Use Heron's formula: Area = √(s(s-a)(s-b)(s-c)) where s = (a+b+c)/2
    @Override
    public double area() {
        double s = (this.side1 + this.side2 + this.side3) / 2;

        return sqrt(s * (s-this.side1) * (s-this.side2) * (s-this.side3));
    }

    // Step 5: Override the perimeter() method to calculate the perimeter of a triangle
    // Hint: Perimeter of a triangle = side1 + side2 + side3
    @Override
    public double perimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    // Step 6: Override toString() method to include triangle-specific information
    // Hint: Call the parent's toString() method and append triangle-specific details
    public String toString() {
        return super.toString() + "\nSide 1: " + this.side1 + "\nSide 2: " + this.side2 + "\nSide 3: " + this.side3;
    }
}
