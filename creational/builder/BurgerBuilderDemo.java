// Product class
class Burger {
  private String bun;
  private int patties;
  private boolean cheese;
  private boolean lettuce;
  private boolean tomato;
  private boolean grilled;

  // Only built via BurgerBuilder
  Burger(String bun, int patties, boolean cheese, boolean lettuce, boolean tomato, boolean grilled) {
    this.bun = bun;
    this.patties = patties;
    this.cheese = cheese;
    this.lettuce = lettuce;
    this.tomato = tomato;
    this.grilled = grilled;
  }

  public void display() {
    System.out.println("Burger with " + patties + " patties on " + bun + " bun"
            + (cheese ? ", cheese" : "")
            + (lettuce ? ", lettuce" : "")
            + (tomato ? ", tomato" : "")
            + (grilled ? ", grilled" : ""));
  }
}

// Builder
class BurgerBuilder {
  private String bun = "regular";
  private int patties = 1;
  private boolean cheese = false;
  private boolean lettuce = false;
  private boolean tomato = false;
  private boolean grilled = false;

  public BurgerBuilder setBun(String bun) {
    this.bun = bun;
    return this;
  }

  public BurgerBuilder setPatties(int patties) {
    this.patties = patties;
    return this;
  }

  public BurgerBuilder addCheese() {
    this.cheese = true;
    return this;
  }

  public BurgerBuilder addLettuce() {
    this.lettuce = true;
    return this;
  }

  public BurgerBuilder addTomato() {
    this.tomato = true;
    return this;
  }

  public BurgerBuilder grill() {
    this.grilled = true;
    return this;
  }

  public Burger build() {
    return new Burger(bun, patties, cheese, lettuce, tomato, grilled);
  }
}

// Optional Director
class BurgerDirector {
  public Burger createVeggieBurger() {
    return new BurgerBuilder()
            .setBun("wheat")
            .addLettuce()
            .addTomato()
            .build();
  }

  public Burger createCheeseLoversBurger() {
    return new BurgerBuilder()
            .setPatties(2)
            .addCheese()
            .grill()
            .build();
  }
}

// Demo
public class BurgerBuilderDemo {
  public static void main(String[] args) {
    BurgerDirector director = new BurgerDirector();

    Burger veggie = director.createVeggieBurger();
    Burger cheesy = director.createCheeseLoversBurger();

    veggie.display();
    cheesy.display();
  }
}
