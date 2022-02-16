public class Car {
  private String make;
  private String model;
  private String color;
  private String year;

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public String getYear() {
    return year;
  }

  public Car(String make, String model, String color, String year) {
    this.make = make;
    this.model = model;
    this.color = color;
    this.year = year;
  }
}