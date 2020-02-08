
package Model;

public abstract class Employee extends Person{

    double salary;
	public Employee(String name, String ssn, String gender, int age, double salary) {
        super(name, ssn, gender, age);
        this.salary = salary;
    }
	public double getSalary()
	{
		return this.salary;
	}
	public String toString()
    {
    	return "\nNome: " + this.getName() + "\n" +
    			"CPF: " + this.getSsn() + "\n" +
    			"Área de atuação: " + this.getOccupationArea() + "\n" +
    			"Idade: " + this.getAge() + "\n";
    			
    }
    public abstract String getOccupationArea();
    
}
