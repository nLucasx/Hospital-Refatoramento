package Control;

import java.util.ArrayList;
import java.util.Scanner;

import View.AdminScreen;
import Model.*;
public class AdminManager {
	
	private Admin admin;
	private ArrayList<Doctor> doctors;
	
	public AdminManager(Admin admin, ArrayList<Doctor> doctors) {
		this.admin = admin;
		this.doctors = doctors;
	}
	
	public void adminRegisterEmployees()
	{
		boolean end = false;
        while (!end)
        {
            System.out.println("\nCadastro de funcionários");
            AdminScreen screen = new AdminScreen();
            Exceptions filter = new Exceptions();
            boolean correct_option = false;
            int option = 0;
            while (!correct_option)
            {
            	screen.drawAdminEmployee();
            	option = filter.verifyMenu(4);
                if (option >= 0) correct_option = true;

            }
            correct_option = false;
            if (option > 0)
            {
                String name = null, ssn = null, gender = null;
                int age = 0;
                Employee e = null;
                Scanner input = new Scanner(System.in);
                System.out.println("Entre com as informações do funcionário.");
                name = filter.readString("Digite o nome >> ");
                gender = filter.readString("Digite o sexo >> ");       
                age = filter.readInt("Digite a idade >> ");
                ssn = filter.verifySsn("Digite o CPF (apenas números) >> ");
          
                correct_option = false;
                if (!admin.existSsn(ssn))
                {
                    if (option == 1)
                    {
                        String crm, specialization;
                        System.out.print("Digite o CRM do médico >> ");
                        crm = input.nextLine();
                        System.out.print("Digite a especialização >> ");
                        specialization = input.nextLine();
                        Doctor doctor = new Doctor(name, ssn, gender, age, crm, specialization);
                        admin.registerDoctor(doctor, doctors);
                    }
                    else // este else é necessário, pois o sistema não utiliza o AddEmployee para cadastrar médicos
                    {
	                    if (option == 2)
	                    {
	                        String specialization;
	                        System.out.print("Digite a especialização >> ");
	                        specialization = input.nextLine();
	                        e = new Nurse(name, ssn, gender, age, specialization);
	                    }
	                    else if (option == 3)
	                    {
	                        e = new Recepcionist(name, ssn, gender, age);
	                    }
	                    else 
	                    {
	                    	e = new GeneralServices(name, ssn, gender, age);
	                    }
	                    admin.AddEmployee(e);
                    }
                    System.out.println("Funcionário cadastrado com sucesso!");
                }
                else System.out.println("Erro! Esse cpf já está cadastrado!");
            }
            else end = true;
        }
	}
	public void adminRemoveEmployees()
	{
		if (!admin.isEmpty())
        {
            System.out.println("\nFuncionários cadastrados: ");
            admin.showAllEmployees();
            Scanner input = new Scanner(System.in);
            String ssn;
            char choice;
            Exceptions filter = new Exceptions();
            int index = -1;
            ssn = filter.verifySsn("Digite o CPF (apenas números) >> ");
            index = admin.returnIndexOfPerson(ssn);
            if (index == -1)
            {
            	System.out.println("Funcionário não encontrado!");          
            }
            else
            {
            	System.out.print("Você tem certeza que deseja excluir o funcionário? S(sim)/N(não) >> ");
            	choice = input.next().charAt(0);
            	if (choice == 'S' || choice == 's')
            	{
            		admin.deleteEmployee(index);
            		System.out.println("O funcionário foi excluído!");
            	}
            	else System.out.println("Saindo...");
            }
        }
        else System.out.println("Não existe nenhum usuário cadastrado no momento!");
	}
    public void adminSearchEmployee()
    {
    	Exceptions filter = new Exceptions();
    	String ssn = null;
    	ssn = filter.verifySsn("Digite o CPF (apenas números) >> ");
    	
    	if (admin.existSsn(ssn))
    	{
    		admin.showEmployee(admin.returnIndexOfPerson(ssn));
    	}
    	else System.out.println("Funcionário não encontrado!");
    }
    public void adminPayEmployees()
    {
    	char choice;
    	Scanner input = new Scanner(System.in);
    	System.out.println("No momento, a clínica possui " + admin.getBalance() + " R$");
    	if (admin.getBalance() < admin.getAllSalary()) System.out.println("Não há saldo o suficiente para pagar todos os funcionários!");
    	else
    	{
    		System.out.println("Deseja pagar todos funcionários? S(sim) / N(não) >> ");
    		choice = input.next().charAt(0);
            if (choice == 'S' || choice == 's')
            {
            	admin.PayEmployees();
        		System.out.println("Foram gastos " + admin.getAllSalary() + " R$ do saldo da clínica");
        		System.out.println("Saldo atual: " + admin.getBalance() + " R$");
            }
    		
    	}
    	
    }
    public void adminAddBalance()
    {
    	Exceptions filter = new Exceptions();
    	double money = 0;
    	boolean correct_option = false;
    	while (!correct_option)
    	{	
    		System.out.print("Digite quanto de saldo você quer adicionar >> ");
    		money = filter.verifyDouble();
    		if (money > 0) correct_option = true; 
    	}
    	admin.addBalance(money);
    	System.out.println("Saldo atual: " + admin.getBalance());
    }
    public void adminAddProducts()
    {
    	AdminScreen screen = new AdminScreen();
    	Exceptions filter = new Exceptions();
    	int option = 0, number = 0;
		boolean correct_option = false, correct_option2 = false;
    	String name = null;
    	Scanner input = new Scanner(System.in);
    	
    	while (!correct_option)
    	{
    		screen.drawAdminProductsMenu();
    		option = filter.verifyMenu(2);
    		if (option > 0)
    		{
    			System.out.print("Digite o nome do produto >> ");
    			name = input.nextLine();
    			while(!correct_option2)
    			{	
    				System.out.print("Digite a quantidade >> ");
    				number = filter.verifyInteger();
                    if (number != -1) correct_option2 = true;
    			}
    			admin.addProduct(option, name, number);
    			System.out.println("\n Produto Registrado com sucesso!");
    		}
    		else correct_option = true;
    	}
    }
    public void adminRemoveProducts()
    {
    	boolean correct_option = false, correct_option2 = false, correct_option3 = false;
    	int option = 0, number = 0, product = 0, amount = 0;
    	Scanner input = new Scanner(System.in);
    	Exceptions filter = new Exceptions();
    	AdminScreen screen = new AdminScreen();
    	while (!correct_option)
    	{
    		screen.drawAdminProductsMenu();
    		option = filter.verifyMenu(2);
    		if (option > 0)
    		{
    			while(!correct_option2)
    			{
    				admin.showProducts(option);
    				if (option == 1) 
    				{
    					product = filter.verifyMenu(admin.getSizeOfQueueH());
    					if (product > 0) amount = admin.getHProduct(product-1).getAmount();
    				}
   					else if (option == 2) 
   					{
   						product = filter.verifyMenu(admin.getSizeOfQueueC());
   						if (product > 0) amount = admin.getCProduct(product-1).getAmount();
   					}
   					
    				if (product > 0 && amount > 0) 
    				{
    					while(!correct_option3)
    					{
    						System.out.print("Digite a quantidade a ser removida do registro >> ");
    						number = filter.verifyInteger();
    						if (number > 0)
    						{
    							if (option == 1)
    							{	
    								if (amount >= number)
    								{
    									admin.removeProducts(option, product-1, number);
    									System.out.println("Materiais removidos com sucesso!");
    									correct_option3 = true;
    								}
    								else System.out.println("Esta quantidade é maior que a registrada!");
    							}
    							else
    							{
    								if (amount >= number)
    								{
    									admin.removeProducts(option, product-1, number);
    									System.out.println("Materiais removidos com sucesso!");
    									correct_option3 = true;
    								}
    								else System.out.println("Esta quantidade é maior que a registrada!");
    							}
    						}
    					}
    					correct_option3 = false;
    				}
    				else if (product > 0 && amount == 0) System.out.println("Este produto está em falta!");
    				else correct_option2 = true;
   				}
    			correct_option2 = false;
   			} 
    		else correct_option = true;
    	}
   	}
    	
}
