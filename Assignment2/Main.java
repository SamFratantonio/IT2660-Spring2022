class Main {
  public static void main(String[] args) {
    Car first = new Car("Honda", "Civic", "Grey", "2019");
    Inventory i = new Inventory(first);
    i.displayCars();
    System.out.println("\nAdding Some Cars\n");
    i.addCar(new Car("Nissan", "Ultima", "Red", "2020"));
    i.addCar(new Car("Ford", "F150", "Blue", "2018"));
    i.addCar(new Car("Ford", "Escape", "White", "2016"));
    i.addCar(new Car("Toyota", "Corolla", "Orange", "1992"));
    i.addCar(new Car("Nissan", "Ultima", "Red", "2020"));
    i.displayCars();
    System.out.println("\nRemoving Car 4\n");
    i.removeCar(4);
    i.displayCars();
    System.out.println("\nInserting New Car At Position 3\n");
    i.insertCar(new Car("Lamborghini", "Aventador", "Green", "2017"), 3);
    i.displayCars();
  }
}