
import java.util.Scanner;

public class Test
{
	final static Scanner in= new Scanner(System.in);
	public static java.lang.String String()
	{
		System.out.println("Enter the Key");
		String K =   in.nextLine();
		return K;
	}
	public static java.lang.String String1()
	{
		System.out.println("Enter the Salt");
		String Y =   in.nextLine();
		return Y;
	}
    public static void main(String[] args)
    {  	
    	System.out.println("Do you want to use own Key?");
    	final Scanner in= new Scanner(System.in);
    	String Input1 = in.nextLine();
    	if(Input1.equals("YES") || Input1.equals("yes") || Input1.equals("Yes"))
    	{
    	
    	String pass= PasswordGenerator.createPassword().toString();
    	String E = OwnKey.encrypt(pass);
    	
    	System.out.println("The encrypted String is"+E);
    	
    	
    	System.out.println("Do you want to recover Password?");
    	{
    		
    		String Input=in.nextLine();
    		if(Input.equals("YES") || Input.equals("yes") || Input.equals("Yes"))
    		{
    	System.out.println("Enter the encrypted String ");
    	 String encrypt = in.nextLine();
    	 System.out.println("Enter the Key");
    	 String A =in.nextLine();
    	 System.out.println("Enter the Salt");
    	 String B = in.nextLine();
    	 byte[] C= B.getBytes();
    	  String pass1= OwnKey.forget(encrypt, A, C);
    	  System.out.println(pass1);
    		}
    		else
    		{
    			System.exit(0);
    		}
    	}
    	}
    	else
    	{
    		
    
    	String Input2;
    	
    	String pass= PasswordGenerator.createPassword().toString();
    	    	    
    	String encryptedString = AES.encrypt(pass);
    	String decryptedString = AES.decrypt(encryptedString) ;
    	
    	while(true)
    	{
    	System.out.println("Do you want to see the encrypted String");
        
        Input2 = in.nextLine();
        
        if(Input2.equals("YES") || Input2.equals("yes") || Input2.equals("Yes"))
        {
            System.out.println("The encrypted String is: "+encryptedString);
           
        }
        
        else 
        {
        	if (!Input1.equals("No") && Input1.equals("no") && !Input1.equals("NO"))
        {
            
            break;
        }
        }
        System.out.println("Do you want to see the decrypted password?");
        
        Input1 = in.nextLine();
        
        if(Input1.equals("YES") || Input1.equals("yes") || Input1.equals("Yes"))
        {
            System.out.println("The decrypted password is: "+decryptedString);
            
        }
        
        else 
        {
        	if (!(Input1.equals("NO")) && (!Input1.equals("No")) && (!Input1.equals("no")))
        {
            
            break;
        }
        }
        break;
    	}
    	
    
  

    	
}
}
}