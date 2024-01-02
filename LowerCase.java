/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str)); //printing the new string after lowe hiw letter
       

    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) 
    {
        String newone="";
        for(int i = 0;i<s.length(); i++)
        {   
            char newchar ='a';
            int valueofchar=s.charAt(i);//getting the value of the char
            if(valueofchar>96)//check if the letter is Capital
             newchar = (char)(valueofchar );
                else  newchar = (char)(valueofchar + 32);//32 is the diffrense between capitl and low letter
            newone+= newchar;


        }

        return newone;
    }
}
