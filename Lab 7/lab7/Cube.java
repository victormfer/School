package lab7;

public class Cube {
    private double length;
    private double width;
    private double height;
    private double volume;


    public Cube(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;

        this.volume = computeVolume();
    }


    public double getVolume() {
        return volume;
    }


    private double computeVolume() {
        return length * width * height;
    }


    public String toString() {
        return "length = " + String.format("%.2f", length) + " | width = " + String.format("%.2f", width) +
                " | height = " + String.format("%.2f", height) + " | volume = " + String.format("%.2f", volume);
    }
}


