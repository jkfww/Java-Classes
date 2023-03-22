
public class Polibiusz implements Algorithm
{
    char[][] matrix = {
            {'A', 'B', 'C', 'D', 'E', 'J'},
            {'F', 'G', 'H', 'I', 'K', '.'},
            {'L', 'M', 'N', 'O', 'P', ','},
            {'Q', 'R', 'S', 'T', 'U', '-'},
            {'V', 'W', 'X', 'Y', 'Z', '!'},
    };


    public String crypt(String inputWord) {
        int x, y;

        String result = "";

        inputWord = inputWord.toUpperCase();

        for (int n = 0; n < inputWord.length(); n++) {

            if (inputWord.charAt(n) == ' ')
            {
                result += ' ';
                continue;
            } else if (inputWord.charAt(n) == '\n')
            {
                result +="\n";
            }

            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 6; j++)
                {

                    if (matrix[i][j] == inputWord.charAt(n)) {
                        x = i + 1;
                        y = j + 1;
                        result += x;
                        result += y;
                        //result += " ";
                    }

                }
            }


        }

        return result;
    }

    public String decrypt(String inputWord)
    {
        StringBuilder result = new StringBuilder();

        int x, y;

        for (int n = 0; n < inputWord.length(); n++)
        {
            if (inputWord.charAt(n) == ' ') {
                result.append(" ");

                continue;
            }else if (inputWord.charAt(n) == '\n')
            {
                result.append("\n");
                continue;
            }

            x = Integer.parseInt(String.valueOf(inputWord.charAt(n)));
            y = Integer.parseInt(String.valueOf(inputWord.charAt(n+1)));

            result.append(matrix[x-1][y-1]);
            n+=1;
        }
        return result.toString();

    }
}
