
import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int Id;

    public Employee(String name, int Id){
        this.name  =name;
        this.Id = Id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return Id;
    }

    public abstract double calculateSalary();

    public void displayInfo(){
        System.out.println("Employee Details :");
        System.out.println("Name: "+name);
        System.out.println("Id: "+Id);
        System.out.println("Salary: $"+calculateSalary());
        System.out.println("----------------------------");
    }
}

class FullTimeEmployee extends Employee{
    private double monthSalary;

    public FullTimeEmployee(String name, int Id, double monthSalary){
        super(name , Id);
        this.monthSalary = monthSalary;
    }

    @Override
    public double calculateSalary(){
        return monthSalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hourWork;
    private double hourRate;

    public PartTimeEmployee(String name, int Id, int hourWork, double hourRate){
        super(name , Id);
        this.hourWork = hourWork;
        this.hourRate = hourRate;
    }

     @Override
    public double calculateSalary(){
        return hourWork * hourRate;
    }
}

class PayRollSystem{
    private ArrayList<Employee> employeeList;

    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee e){
        employeeList.add(e);
    }

    public void removeEmployee(int Id){
        Employee toRemove = null;
        for(Employee e : employeeList){
            if(e.getId() == Id){
                toRemove = e;
                break;
            }
        }
        if(toRemove != null){
            employeeList.remove(toRemove);
              System.out.println("Employee with ID " + Id + " removed.");
        } else {
            System.out.println("Employee with ID " + Id + " not found.");
            
        }
    }

    public void displayEmployee(){
        for(Employee e : employeeList){
            e.displayInfo();
        }
    }
}

class Main{
    public static void main(String[] args) {

        PayRollSystem pay = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Karan" , 123 ,75000);
        FullTimeEmployee emp2 = new FullTimeEmployee("Sunny" , 124 ,55000);
        PartTimeEmployee emp3 = new PartTimeEmployee("Ramesh", 221, 5, 1500);
        PartTimeEmployee emp4 = new PartTimeEmployee("Vinod", 222, 7, 1800);

        pay.addEmployee(emp1);
        pay.addEmployee(emp2);
        pay.addEmployee(emp3);
        pay.addEmployee(emp4);
        pay.displayEmployee();

        pay.removeEmployee(221);

        System.out.println("Remaining Employee Details:");
        pay.displayEmployee();
               
    }
}