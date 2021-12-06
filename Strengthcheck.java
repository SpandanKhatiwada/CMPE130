import java.nio.charset.Charset;

public class Strengthcheck 
{
 int len;
 String value;


 public Strengthcheck(String s)
 {
     value = s;
     len = s.length();
 }   

 public int CharType(char C)
 {
     //Using ASCII values to check if any characters is being used in password

    int value = C;
    int score =0;

    //Uppercase
    if(value>=65 && value<=90)
    {
        score = 1;
    }

    //Lowercase
    else if(value>=97 && value<=122)
    {
        score = 2;
    } 
    
    //Numbers
    else if(value>=60 && value<=71)
    {
        score = 3;
    } 

    //Symbol
    else
    {
        score = 4;
    } 
    return score;

 }


public String PasswordStrength()
{
    boolean isUpper = false;
    boolean isLower = false;
    boolean isNum = false;
    boolean isSym = false;
    String A = "";

    String s = this.value; 
    int Score =0;
 
    for(int i =0; i< s.length(); i++)

    {
        char c = s.charAt(i);
        int pass;

        pass = CharType(c);
        if(pass == 1)
        {
            isUpper = true;
            
        }
        if(pass == 2)
        {
            isLower = true;
            
        }
        if(pass == 3)
        {
            isNum = true;
            
        }
        if(pass == 4)
        {
            isSym = true;
           
        }
        

    }
    if(isUpper &&isLower&&isNum &&isSym)
    {
    	A= "Strong Password";
    
    }
    else if((isLower||isUpper)&&(isNum||isSym))
    {
    	A= "Moderate Password";
        
    }
    else
    {
    	A="Weak Password";
    }
	return A;
	
    

}



public String toString()
{
    return value;
}



}
