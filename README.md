# Calculator

This Java console calculator allows you to perform basic arithmetic operations such as addition (+), subtraction (-), multiplication (*), and division (/) between two numbers. 
To use the calculator, you need to input a statement in the format: `operation number1 number2`. For example, to add 5 and 3, you would input `+ 5 3`. The calculator will then perform the operation and output the result.

## Team Members
This project was a collaborative effort that involved pair programming and online collaboration.
In the initial stages of the project, we used pair programming extensively. This approach was particularly useful when we were working on the base project at school. Pair programming allowed us to share ideas and solve problems more effectively. One of us would write the code (the "driver"), while the other would review each line of code as it was written (the "navigator"). We would then switch roles regularly. This not only improved the quality of our code, but also helped us learn from each other.
After the base project was completed at school, we continued to work on the project remotely. We used online collaboration tools to communicate and coordinate our work. We used Git for version control, which allowed us to work on different parts of the project independently and then merge our changes together. We also used code reviews to maintain the quality of our code. Before any code was merged into the main branch, it was reviewed by the other team member. This helped us catch any bugs or issues early on.
This project was developed in collaboration between [MellowRainn] and [TygovanderLinde2]. Both team members contributed equally to the development of the program. The commits and pull requests in the GitHub repository provide a detailed record of each member's contributions.

## Design Patterns

### Creational Design Patterns

1. **Singleton**: The Singleton pattern is used in the `CalculatorConfig` class (in [`CalcHelper.java`](src/Calculator/CalcHelper.java)). This class ensures that there's only one instance of the configuration settings across the application. This is achieved by making the constructor private and providing a static method to get the instance.

2. **Factory Method**: The Factory Method pattern is used in the `CalcHelper` class (in [`CalcHelper.java`](src/Calculator/CalcHelper.java)) to create different types of calculators based on the operation. This pattern provides a way to delegate the instantiation logic to child classes.

### Structural Design Patterns

1. **Template Method**: The Template Method pattern is used in the [`CalcBase`](src/Calculator/CalcBase.java) class. This class defines the structure of the `calculate` method, which must be implemented by any class that extends `CalcBase`. The classes [`CalcAdder`](src/Calculator/CalcAdder.java), [`CalcSubtracter`](src/Calculator/CalcSubtracter.java), [`CalcMultiplier`](src/Calculator/CalcMultiplier.java), and [`CalcDivider`](src/Calculator/CalcDivider.java) all provide their own implementations of this method. This pattern allows subclasses to redefine certain steps of an algorithm without changing the algorithm's structure.

### Behavioural Design Patterns

1. **Command**: The Command pattern is used in the [`CalcBase`](src/Calculator/CalcBase.java) class and its subclasses ([`CalcAdder`](src/Calculator/CalcAdder.java), [`CalcSubtracter`](src/Calculator/CalcSubtracter.java), [`CalcMultiplier`](src/Calculator/CalcMultiplier.java), [`CalcDivider`](src/Calculator/CalcDivider.java)). Each subclass represents a specific command (addition, subtraction, multiplication, division) that can be performed on two numbers. The `calculate` method in `CalcBase` is the method that executes the command. This pattern allows you to encapsulate a request as an object, thereby letting you parameterize clients with queues, requests, or operations.

2. **Composite**: The Composite pattern is used in the [`CalcBase`](src/Calculator/CalcBase.java) class. This class can represent either a single calculator or a composition of calculators. It has a method `add` that allows adding instances of `CalcBase` (or its subclasses) to a list of `childCalculators`. This pattern allows you to compose objects into tree structures to represent part-whole hierarchies.