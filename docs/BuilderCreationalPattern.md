### Builder Creational Pattern

The **Builder pattern** is a creational design pattern that simplifies the construction of complex objects by separating the process of building from the object’s actual representation. 
Instead of a large constructor with multiple parameters, the builder pattern allows step-by-step object creation while preserving the immutability of the final product.

### When to use Builder Pattern

#### 1. **Creation of complex objects**
If a class has a constructor with many parameters, using the builder pattern can make the object creation more readable and flexible.
When the class has multiple optional fields or parameters, the builder pattern prevents the need for multiple overloaded constructors, making code more flexible and easier to maintain

**Example**:
```java
public class User {
    private final String username;
    private final String email;
    private final String address;
    private final String phoneNumber;

    // Private constructor
    private User(UserBuilder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class UserBuilder {
        private final String username;
        private final String email;
        private String address;
        private String phoneNumber;

        public UserBuilder(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

// Usage
User user = new User.UserBuilder("JohnDoe", "john@example.com")
                 .setAddress("123 Main St")
                 .setPhoneNumber("555-1234")
                 .build();
```

#### 2. **When creating immutable objects with many configuration options**
The builder pattern is commonly used when constructing immutable objects that require a lot of configuration. Each step in the building process customizes the object, but once the object is built, it can’t be modified.

**Example**:  
Immutable classes, such as configurations or complex reports, can benefit from the builder pattern.
```java
public class Report {
    private final String title;
    private final String content;
    private final String author;
    private final boolean isPublished;

    private Report(ReportBuilder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.author = builder.author;
        this.isPublished = builder.isPublished;
    }

    public static class ReportBuilder {
        private final String title;
        private final String content;
        private String author = "Unknown";
        private boolean isPublished = false;

        public ReportBuilder(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public ReportBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public ReportBuilder publish() {
            this.isPublished = true;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}

// Usage
Report report = new Report.ReportBuilder("Annual Report", "The content of the report")
                 .setAuthor("Jane Doe")
                 .publish()
                 .build();
```


#### 3. **When the construction process involves multiple steps**
Sometimes constructing an object requires a complex, multi-step process (e.g., preparing a series of components). The builder pattern allows breaking down the construction into smaller methods and handling dependencies between those steps.

**Example**:  
In cases like assembling a car, where multiple subcomponents are built in different stages, the builder pattern allows each component to be constructed individually.

```java
public class Car {
    private String engine;
    private String wheels;
    private String body;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.body = builder.body;
    }

    public static class CarBuilder {
        private String engine;
        private String wheels;
        private String body;

        public CarBuilder buildEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder buildWheels(String wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder buildBody(String body) {
            this.body = body;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

// Usage
Car car = new Car.CarBuilder()
                .buildEngine("V8 Engine")
                .buildWheels("Alloy Wheels")
                .buildBody("Sedan")
                .build();
```

#### 4. **When an object requires validation during creation**
The builder pattern can enforce validation logic before final object creation. This is useful when certain combinations of parameters need to be validated or rejected.

**Example**:  
A `Pizza` class where certain combinations of toppings need to be validated, and errors should be thrown during the build process if the configuration is invalid.

```java
public class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    private Pizza(PizzaBuilder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.topping = builder.topping;
    }

    public static class PizzaBuilder {
        private String dough;
        private String sauce;
        private String topping;

        public PizzaBuilder setDough(String dough) {
            this.dough = dough;
            return this;
        }

        public PizzaBuilder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder setTopping(String topping) {
            if ("Anchovies".equals(topping)) {
                throw new IllegalArgumentException("Anchovies are not allowed");
            }
            this.topping = topping;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

// Usage
Pizza pizza = new Pizza.PizzaBuilder()
               .setDough("Thin Crust")
               .setSauce("Tomato")
               .setTopping("Pepperoni")
               .build();
```

### Advantages of Builder Pattern

1. **Flexible Object Construction**: The builder pattern allows constructing objects in a flexible and customizable manner.
2. **Improved Readability**: It makes the object creation code more readable, especially when dealing with many parameters or optional fields.
3. **Immutable Objects**: It can be used to build immutable objects by ensuring that all properties are set during the building process.
4. **Separation of Concerns**: It separates the logic of building complex objects from the final representation, following the Single Responsibility Principle.