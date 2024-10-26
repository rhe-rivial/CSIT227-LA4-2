package Management_Exc;

public class Developer extends Employee {
    private Manager projectManager;

    public Developer(String name, int age, double salary) {
        super(name, age, salary);
        projectManager = null;
    }

    public Manager getProjectManager() {

        return projectManager;
    }

    /**
     * TODO the implementation
     * @param projectManager to be added as project manager
     * @throws IllegalStateException when this developer already has a project manager
     */
    protected void setProjectManager(Manager projectManager) throws IllegalStateException{
        if (this.projectManager != null){
            throw new IllegalStateException(getName() + " already has a manager: " + this.projectManager.getName());
        }

        this.projectManager = projectManager;
    }

    public void removePM() {

        projectManager = null;
    }

    @Override
    public void birthday() {
        super.birthday();
        if (projectManager != null) {
            projectManager.giveRaise(this, this.getSalary()*0.05);
        }
    }

    @Override
    public void performTask() {

        System.out.println(getName() + " is coding");
    }

    @Override
    public String toString() {
        if (projectManager != null) {
            return super.toString() + " [" + projectManager.getName() + "]";
        }
        return super.toString();
    }
}

/*
A Developer is an Employee that has a Manager projectManager. Create a public getter and protected
setter for this field. The setter must only set the project manager when there is none, otherwise throw
exception name " already has a manager".

The Developer also has a method removePM() where it
unassigns the developer's project manager.

When a Developer has his birthday, the projectManager, if
any, must also give him a raise amounting to 5% of the Developer's current salary.

This must use the
getter method of the salary; if there is no project manager, the Developer would not get a raise.
Additionally, the performTask of the Developer must be changed to name "is coding".

Additionally, when
the Developer object is printed and it has a project manager, it will also output the name of the project
manager inside square brackets i.e., "name (age) - salary [PM name]".

For the setProjectManager as mentioned above, when the developer already has a manager, throw an
IllegalStateException with message “name already has a manager: managername”

 */
