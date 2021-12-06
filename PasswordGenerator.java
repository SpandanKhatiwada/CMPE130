import java.util.Scanner;
import java.security.*;

public class PasswordGenerator
{
    
    boolean Uppercase = false;
    boolean Lowercase = false;
    boolean Number = false;
    boolean Symbol = false;
    Character character;

    public PasswordGenerator(boolean Uppercase, boolean Lowercase, boolean Number,boolean Symbol)
    {
        character = new Character(Uppercase, Lowercase, Number, Symbol);
    }



public Strengthcheck GeneratePassword(int length)
{
	
    StringBuilder password = new StringBuilder("");
    int charlength = character.generateCharacters().length();

    int range = charlength ;

    for(int i =0; i<length; i++)
    {
    	SecureRandom secureRandom;
		try {
			secureRandom = SecureRandom.getInstance("Sha1PRNG");
			 int index = (int)(secureRandom.nextInt(range));
		        password.append(character.generateCharacters().charAt(index));
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
       
    }

    return new Strengthcheck(password.toString());
}

public static String createPassword()
{
	final Scanner in= new Scanner(System.in);
    boolean isUpper=false;
    boolean isLower = false;
    boolean isNum = false;
    boolean isSym = false;
    int input;
    String Input1;
    String Pass = "";
    System.out.println("Password Generator");
    while(true)
    {
        System.out.println("Do you want to create your own password or generate the random password");
        System.out.println("Enter 1 to generate random password and enter 2 to create your own password");
        input = in.nextInt();
        in.nextLine();
        while(input < 1 ||input >2)
        {
        	 System.out.println("Enter 1 to generate random password and enter 2 to create your own password");
             input = in.nextInt();
             in.nextLine();
        }
        if(input == 1)
        
        {
            System.out.println("Do you want to use lowercase letters?");
            Input1 = in.nextLine();
            if(Input1.equals("YES") || Input1.equals("yes") || Input1.equals("Yes"))
            {
                isLower = true;
            }
            
            else 
            {
            	if (!(Input1.equals("NO")) && (!Input1.equals("No")) && (!Input1.equals("no")))
            {
                System.out.println("Enter either yes or no");
                break;
            }
            }
           
            System.out.println("Do you want to use Uppercase letters?");
            Input1 = in.nextLine();
            if(Input1.equals("YES") || Input1.equals("yes") || Input1.equals("Yes"))
            {
                isUpper = true;
            }
            else
            {
            if (!(Input1.equals("NO")) && (!Input1.equals("No")) && (!Input1.equals("no")))
            {
                System.out.println("Enter either yes or no");
                break;
            }
            
            
            }
            System.out.println("Do you want to use Numbers?");
            Input1 = in.nextLine();
            if(Input1.equals("YES") || Input1.equals("yes") || Input1.equals("Yes"))
            {
                isNum = true;
            }
            
            else 
            {
            	if (!(Input1.equals("NO")) && (!Input1.equals("No")) && (!Input1.equals("no")))
            {
                System.out.println("Enter either yes or no");
                break;
            }
            }
            System.out.println("Do you want to use Symbols?");
            Input1 = in.nextLine();
            if(Input1.equals("YES") || Input1.equals("yes") || Input1.equals("Yes"))
            {
                isSym = true;
            }
            
            else 
            {
            	if (!(Input1.equals("NO")) && (!Input1.equals("No")) && (!Input1.equals("no")))
            {
                System.out.println("Enter either yes or no");
                break;
            }
            }

            System.out.println("Enter the length of the password:");

            int length = in.nextInt();
            in.nextLine();

             PasswordGenerator generate = new PasswordGenerator(isUpper,isLower,isNum,isSym);
             Strengthcheck Password= generate.GeneratePassword(length);
             System.out.println(Password);
             Pass= Password.toString();
             
             System.out.println("Do you want to check the strength of your password?");
             String Input2 = in.nextLine();
             if(Input2.equals("YES") || Input2.equals("yes") || Input2.equals("Yes"))
             {
                 String Strength =Password.PasswordStrength();
                 System.out.println(Strength);
                 break;
             }
             
             else 
             {
        		 if (!(Input2.equals("NO")) && (!Input2.equals("No")) && (!Input2.equals("no")))
             {
                 System.out.println("Enter either yes or no");
                 break;
             }
             
             
             }
             
             
             
        }
        else if (input==2)
        {
        	final Strengthcheck Own = new Strengthcheck(Own());
        	Pass= Own.toString();
        	System.out.println("Do you want to check the strength of your password?");
            String Input2 = in.nextLine();
        	if(Input2.equals("YES") || Input2.equals("yes") || Input2.equals("Yes"))
            {
                String Strength = Own.PasswordStrength();
                System.out.println(Strength);
                break;
            }
        	 else 
             {
        		 if (!(Input2.equals("NO")) && (!Input2.equals("No")) && (!Input2.equals("no")))
             {
                 System.out.println("Enter either yes or no");
                 break;
             }
        		 
        		 break;
              
          
             }  	
    }
}
   
	return  Pass;
	
}



public static String Own() {
	// TODO Auto-generated method stub
	Scanner in= new Scanner(System.in);
    String input = "";
    System.out.println("Enter your own password");
    input = in.nextLine();
    return input;
	
}
}