public class Inventory {
  private Car[] cars;
  public Inventory(Car firstCar)
  {
    this.cars = new Car[1];
    this.cars[0] = firstCar;
  }
  public int carCount(){return this.cars.length;}
  public void displayCars()
  {
    for (int x = 0; x < cars.length; x++)
    {
      System.out.println("Car: " + (x + 1));
      System.out.println("Make: " + cars[x].getMake());
      System.out.println("Model: " + cars[x].getModel());
      System.out.println("Color: " + cars[x].getColor());
      System.out.println("Year: " + cars[x].getYear() + "\n");
    }
  }
  public boolean insertCar(Car car, int npos)
  {
    int pos = npos - 1;
    if (this.cars.length == 0 && pos == 0)
    {
      this.cars = new Car[1];
      cars[0] = car;
      return true;
    }
    if (pos < 0 || pos > this.cars.length)
    {
      return false; 
    }
    else 
    {
      Car[] tempCars = new Car[this.cars.length + 1];
      for (int x = 0; x <= this.cars.length;x++) {
        if (x < pos) {tempCars[x] = this.cars[x];}
        else if (x > pos) {tempCars[x] = this.cars[x-1];}
        else {tempCars[x] = car;}
      }
      this.cars = tempCars;
      return true;
    }
  }
  public void removeCar(int npos)
  {
    int pos = npos - 1; //so 1 removes car 0
    if (pos < 0 || pos >= cars.length)
    {
      System.out.println("INVALID POSITION");
      return;
    }
    else
    {
      Car[] tempCars = new Car[this.cars.length - 1];
      for (int x = 0; x < cars.length; x++)
      {
        if (x < pos)
        {
          tempCars[x] = this.cars[x];
        }
        if (x > pos)
        {
          tempCars[x-1] = this.cars[x];
        }
      }
      this.cars = tempCars;
    }
  }
  public void addCar(Car car) //just adds another car onto the end
  {
    Car[] tempCars = new Car[this.cars.length + 1];
    for (int x = 0; x < this.cars.length; x++){tempCars[x] = this.cars[x];}
    tempCars[tempCars.length - 1] = car;
    this.cars = tempCars;
  }
}