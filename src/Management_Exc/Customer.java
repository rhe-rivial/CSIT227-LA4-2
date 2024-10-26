package Management_Exc;

public class Customer extends Person {

    public Customer(String name, int age) {

        super(name, age);
    }

    @Override
    public void performTask() {

        System.out.println(getName() + " is browsing through");
    }

    /**
     * TODO implementation
     * @param e employee to be spoken to
     * @return the dialogue of the customer
     */
    public String speak(Employee e) {
        if (e instanceof Developer && getAge() > e.getAge()) {
            return "Can I see your manager " + ((Developer) e).getProjectManager().getName() + "?";
        } else {
            return "Oh, hello, " + e.getName() + ". Can you assist me?";
        }
    }

}

/*
A Customer is a Person that will print name " is browsing through" in its performTask method.
It also has a method speak(Employee) where it will print "Oh, hello, [employee name]. Can you assist me?", except
when the Employee is a Developer and the Customer's age is more than the Developer's age, in which
case it will instead ask "Can I see your manager [name of manager]?"

cos > dev age
Can I see your manager [name of manager]?

Oh, hello, [employee name]. Can you assist me?
 */
