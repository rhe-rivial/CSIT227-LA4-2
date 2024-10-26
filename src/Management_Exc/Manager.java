package Management_Exc;

public class Manager extends Employee {


    /**
     * TODO this implementation
     * @param e the employee to be given raise
     * @param raise the raise
     * @throws IllegalArgumentException when raise is negative
     */
    public Manager(String name, int age, double salary) {

        super(name, age, salary);
    }
    public void giveRaise(Employee e, double raise) {
        if (raise < 0){
            //System.out.println("Invalid increase");
            throw new IllegalArgumentException("Raise must be non-negative");
        }

        if (e == this){
            // manager
            this.setSalary(this.getSalary() + raise);
        } else {
            // employees
            e.setSalary(e.getSalary() + raise);

            // manager
            double half = raise / 2.00;
            this.setSalary(this.getSalary() + half);
        }

    }

    @Override
    public String toString() {

        return "Mgr. " +super.toString();
    }
}

/*

A Manager is an Employee that shall have a public method giveRaise(Employee, double) given the
Employee and the increase that shall increase the Employee's current salary with the increase.
Half of that increase shall also be added to the Manager's own salary.
salary + raise/2

If the Employee in the argument is the
Manager itself, then only the first one shall apply.
salary + raise;


For the giveRaise method, you must use the setter to
set the Employee's salary.

The said method must check the increase for validation such that it would not
process negative values and shall instead print "Invalid increase".
Additionally, when the Manager object
is printed, it will have to be prepended by the abbreviation "Mgr."

For the raise in the giveRaise, make sure that it is valid. If it is negative, throw an
IllegalArgumentException with message “Raise must be non-negative"
 */