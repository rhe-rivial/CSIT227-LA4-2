package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        if (salary < 0){
            throw new IllegalArgumentException("Raise must be non-negative");
        }

        Person man = null;
        Person empl = null;

        for (Person person : persons){
            if (person.getName().equals(manager)){
                if (!(person instanceof Manager)){
                    throw new ClassCastException(manager + " is not a manager");
                }

                man = person;
            }

            if (person.getName().equals(employee)){
                if (!(person instanceof Employee)){
                    throw new ClassCastException(employee + " is not an employee");
                }

                empl = person;
            }
        }

        if (man == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }
        if (empl == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        ((Manager) man).giveRaise((Employee) empl, salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Manager man = null;
        Developer deve = null;

        for (Person person : persons){
            if (person.getName().equals(manager)){
                if (!(person instanceof Manager)){
                    throw new ClassCastException(manager + " is not a manager");
                }

                man = (Manager) person;
            }

            if (person.getName().equals(developer)){
                if (!(person instanceof Employee)){
                    throw new ClassCastException(developer + " is not an employee");
                }

                deve = (Developer) person;
            }
        }

        if (man == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }
        if (deve == null) {
            throw new NoSuchElementException(deve + " does not exist");
        }

        deve.setProjectManager(man);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer cust = null;
        Employee empl = null;

        for (Person person : persons) {
            if (person.getName().equals(customer)) {
                if (!(person instanceof Customer)) {
                    throw new ClassCastException(customer + " is not a customer");
                }
                cust = (Customer) person;
            }
            if (person.getName().equals(employee)) {
                if (!(person instanceof Employee)) {
                    throw new ClassCastException(employee + " is not an employee");
                }
                empl = (Employee) person;
            }
        }

        if (cust == null) {
            throw new NoSuchElementException(customer + " does not exist");
        }
        if (empl == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }


        if (empl instanceof Developer) {
            Developer dev = (Developer) empl;
            Manager pm = dev.getProjectManager();

            if (pm != null) {
                return "Can I see your manager " + pm.getName() + "?";
            } else {
                return "Oh, hello, " + empl.getName() + ". Can you assist me?";
            }
        } else {
            return "Oh, hello, " + empl.getName() + ". Can you assist me?";
        }
    }
}

/*
Additionally, implement the static methods in Main. All methods will have the list of persons and a
series of other parameters including strings for the names of the persons involved.

When the name is found and it is not the desired type, throw a ClassCastException with the message
“name is not a/n type” where type is the desired type.

When the name is not at all found in the list of persons, throw a NoSuchElementException with the
message “name does not exist”
 */