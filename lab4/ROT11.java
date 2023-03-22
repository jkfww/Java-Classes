public class ROT11 implements Algorithm
{
    static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static final int rotation = 11;

    public String crypt(String inputWord)
    {
        StringBuilder result = new StringBuilder(inputWord);
        for(int i = 0; i<inputWord.length(); i++)
        {
            char c = inputWord.charAt(i);

            if(alphabet.indexOf(c)!=-1)
            {
                result.setCharAt(i, alphabet.charAt((alphabet.indexOf(c) + rotation) % alphabet.length()));
            }
        }
        return result.toString();
    }

    public String decrypt(String inputWord)
    {
        StringBuilder result = new StringBuilder(inputWord);
        for(int i = 0; i<inputWord.length(); i++)
        {
            char c = inputWord.charAt(i);

            if(alphabet.indexOf(c)!=-1)
            {
                if(alphabet.indexOf(c)<rotation)
                {
                    result.setCharAt(i, alphabet.charAt((alphabet.length() - (rotation-alphabet.indexOf(c)))));
                }
                else
                {
                    result.setCharAt(i, alphabet.charAt((alphabet.indexOf(c) - rotation)));
                }
            }
        }
        return result.toString();
    }


}
