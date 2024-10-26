package Management_Exc;

public abstract class Person {
    private final String name;
    private int age;

    /**
     * TODO the implementation
     * @param name the name of the person
     * @param age the age of the person
     * @throws IllegalArgumentException when age is negative
     */
    public Person(String name, int age) {

        if (age < 0){
            throw new IllegalArgumentException("Age must be non-negative.");
        }
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {

        return name + " (" + age + ")";
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public void birthday() {
        System.out.println("Happy birthday, " + name + "!");
        age++;
    }

    public abstract void performTask();
}

/*
All Persons have the following private fields: a name and an age.
Declare name as final since it would not
ever be changed after constructing. Create a public getter for both.

All Persons also celebrate birthday()s
that prints "Happy birthday, name!" and they grow one year older.
They could also performTask() that
returns nothing but its implementation is to be performed on its subclasses.
Whenever a Person is printed,
it will print the name and the age enclosed in parenthesis, i.e., "name (age)".


For the age, make sure that it is valid. If it is negative, throw an IllegalArgumentException with message
“Age must be non-negative”
 */