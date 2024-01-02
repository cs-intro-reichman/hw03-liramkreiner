/** String processing exercise 2. */
public class UniqueChars
 {
    public static void main(String[] args)
     {  
        String str = args[0];
        System.out.println(uniqueChars(str));//printing the new string after changing
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) 
    {
        String newstring= "" + s.charAt(0);
        for(int i = 0;i<s.length(); i++)
        {
            char checkdup=s.charAt(i);
            if(checkdup==' ') //checking if there is space and add
                {
                    newstring+= " ";
                }
                 else //if the char is not space
                {
                    boolean ifdup=true;
                    for(int j = 0;j<newstring.length(); j++)
                    {
                         if(checkdup==newstring.charAt(j))//if the char exsist than i will not add the char to the string
                          ifdup= false;

                     }
                     if (ifdup)//if the string not exsist add it
                        newstring+=checkdup;
                 }            
                   
               
        }
        return newstring;
    }

}
