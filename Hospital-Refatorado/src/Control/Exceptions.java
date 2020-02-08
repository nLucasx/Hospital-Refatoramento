
package Control;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Person;
public class Exceptions {
    public int verifyMenu(int range)
    {
        int option;
        Scanner input = new Scanner(System.in);
        try
        {
            System.out.print("Digite uma opção >> ");
            option = Integer.parseInt(input.next());
        }
        catch (NumberFormatException e)
        {
        	System.out.println("Digite apenas números!");
        	return -2; // -2 para exception.
        }
        if (option >= 0 && option <= range) return option;
        System.out.println("Opção inválida");
        return -1; // -1 para opção inválida.
    }
    public String verifySsn(String header)
    {
    	Scanner input = new Scanner(System.in);
    	String ssn = null;
    	boolean correctOption = false;
    	
    	while (!correctOption)
    	{
    		System.out.print("Digite o CPF (apenas números) >> ");
    		ssn = input.nextLine();
    		correctOption = true;
    		if (ssn.length() < 11 || ssn.length() > 11)
    		{
    			System.out.println("O seu cpf não possui 11 dígitos!");
    			correctOption = false;
    		}	
	    	else
	    	{
	    		for (int i = 0; i < ssn.length(); i++)
	    		{
	    			if (ssn.charAt(i) < 48 || ssn.charAt(i) > 57) 
	    			{
	    				System.out.println("Digite apenas números!");
	    				i = ssn.length();
	    				correctOption = false;
	    			}
	    		}
	    	}	
    	}
    	return ssn;
    }
    public int verifyInteger()
    {
        int option = -1;
        try
        {
            Scanner input = new Scanner(System.in);
            option = Integer.parseInt(input.next());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Você digitou letras!");
            return -1;
        }
        if (option <= 0)
        {
        	System.out.println("Opção inválida!");
    		return -1;
        }
        return option;
    }
    public String readString(String header)
    {
    	boolean correctOption = false;
    	Scanner input = new Scanner(System.in);
    	String answer = null;
    	while (!correctOption)
    	{
    		System.out.print(header);
    		answer = input.nextLine();
    		correctOption = verifyString(answer);
    	}
    	return answer;
    }
    public int readInt(String header)
    {
    	boolean correctOption = false;
    	int answer = 0;
    	while (!correctOption)
    	{
    		System.out.print(header);
    		answer = verifyInteger();
    		if (answer != -1) correctOption = true;
    	}
    	return answer;
    }
    public boolean verifyString(String str)
    {
    	for (int i = 0; i < str.length(); i++)
    	{
    		if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
    		{
    			System.out.println("Digite apenas letras!");
    			return false;
    		}
    	}
    	return true;
    }
    public double verifyDouble()
    {
    	double option = -1, max = 999999999.9;
    	try
    	{
    		Scanner input = new Scanner(System.in);
    		option = Double.parseDouble(input.next());
    	}
    	catch(NumberFormatException e)
    	{
    		System.out.println("Você digitou letras!");
    	}
    	if (option < 0 || option > max)
    	{
    		System.out.println("Opção inválida!");
    		return -1;
    	}
    	return option;
    }
    public boolean verifyBiggest(int x, int y)
    {
    	return x > y;
    }
}
