// Product interface
interface Transport {
  void deliver();
}

// Concrete Product 1
class Truck implements Transport {
  public void deliver() {
    System.out.println("Delivering by land in a truck.");
  }
}

// Concrete Product 2
class Ship implements Transport {
  public void deliver() {
    System.out.println("Delivering by sea in a ship.");
  }
}

// Creator (Factory)
abstract class Logistics {
  // Factory Method
  public abstract Transport createTransport();

  // Business logic using the product
  public void planDelivery() {
    Transport transport = createTransport();
    transport.deliver();
  }
}

// Concrete Creator 1
class RoadLogistics extends Logistics {
  public Transport createTransport() {
    return new Truck();
  }
}

// Concrete Creator 2
class SeaLogistics extends Logistics {
  public Transport createTransport() {
    return new Ship();
  }
}

// Client Code
public class TransportFactoryDemo {
  public static void main(String[] args) {
    Logistics logistics;

    logistics = new RoadLogistics();
    logistics.planDelivery();  // Output: Delivering by land in a truck.

    logistics = new SeaLogistics();
    logistics.planDelivery();  // Output: Delivering by sea in a ship.
  }
}
