package Management_Exc;

public class Employee extends Person {
    private double salary;

    /**
     * TODO implementation
     * @param name the name of the employee
     * @param age the age of the employee
     * @param salary the salary of the employee
     * @throws IllegalArgumentException when salary does not reach minimum salary of 30,000
     */
    public Employee(String name, int age, double salary)  {

        super(name, age);
        if (salary < 30000){
            throw new IllegalArgumentException("Salary must be greater than or equal to 30000");
        }

        this.salary = salary;
    }

    public double getSalary() {

        return salary;
    }

    protected void setSalary(double salary) {
        if (salary < 30000){
            throw new IllegalArgumentException("Salary must be greater than or equal to 30000");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {

        return super.toString() + " - " + salary;
    }

    @Override
    public void performTask() {

        System.out.println(getName() + " is working");
    }
}

/*
The Employee is a Person that has the following field: double salary.
Create a public getter and a protected
setter for this field. The Employee's performTask() will simply print the following: name " is working".
Whenever an Employee is printed, it would also have its salary listed after, i.e., "name (age) - salary", and
there is no particular formatting for the salary's decimal places.
As we attempt to promote reusability, try
not to implement the same printing of the name and age again, but instead use the concept of inheritance,
similar to the other tasks in this problem.


For the salary, make sure that it cannot go lower than 30,000. If it does, throw an
IllegalArgumentException with message “Salary must be greater than or equal to 30000”

 */