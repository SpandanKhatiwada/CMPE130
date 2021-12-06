
public class Character 
{
    public static final String Uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String Lowercase = "abcdefghijklmnopqrstuvwxyz";
	public static final String Numbers = "1234567890";
	public static final String Symbols = "!@#$%^&*()-_=+\\/~?";

    private StringBuilder check;

    public Character(boolean uppercase, boolean lowercase, boolean numbers, boolean symbols) {

    check = new StringBuilder();
    
    if(uppercase)
    {
        check.append(Uppercase);
    }

    if(lowercase)
    {
        check.append(Lowercase);
    }

    if(numbers)
    {
        check.append(Numbers);
    }

    if(symbols)
    {
        check.append(Symbols);
    }
    }


public String generateCharacters()
{
    return check.toString();
}

}