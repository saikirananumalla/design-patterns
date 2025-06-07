// Abstract Product: Chair
interface Chair {
  void sitOn();
}

// Abstract Product: Sofa
interface Sofa {
  void lieOn();
}

// Concrete Product: Modern Chair
class ModernChair implements Chair {
  public void sitOn() {
    System.out.println("Sitting on a modern chair.");
  }
}

// Concrete Product: Victorian Chair
class VictorianChair implements Chair {
  public void sitOn() {
    System.out.println("Sitting on a victorian chair.");
  }
}

// Concrete Product: Modern Sofa
class ModernSofa implements Sofa {
  public void lieOn() {
    System.out.println("Lying on a modern sofa.");
  }
}

// Concrete Product: Victorian Sofa
class VictorianSofa implements Sofa {
  public void lieOn() {
    System.out.println("Lying on a victorian sofa.");
  }
}

// Abstract Factory
interface FurnitureFactory {
  Chair createChair();
  Sofa createSofa();
}

// Concrete Factory: Modern
class ModernFurnitureFactory implements FurnitureFactory {
  public Chair createChair() {
    return new ModernChair();
  }

  public Sofa createSofa() {
    return new ModernSofa();
  }
}

// Concrete Factory: Victorian
class VictorianFurnitureFactory implements FurnitureFactory {
  public Chair createChair() {
    return new VictorianChair();
  }

  public Sofa createSofa() {
    return new VictorianSofa();
  }
}

// Client
public class FurnitureFactoryDemo {
  public static void main(String[] args) {
    FurnitureFactory factory;

    // Switch between families here
    factory = new ModernFurnitureFactory();
    Chair modernChair = factory.createChair();
    Sofa modernSofa = factory.createSofa();

    modernChair.sitOn();
    modernSofa.lieOn();

    factory = new VictorianFurnitureFactory();
    Chair victorianChair = factory.createChair();
    Sofa victorianSofa = factory.createSofa();

    victorianChair.sitOn();
    victorianSofa.lieOn();
  }
}