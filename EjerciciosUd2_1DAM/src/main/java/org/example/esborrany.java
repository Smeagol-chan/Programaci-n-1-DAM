package org.example;
import java.util.Scanner;
public class esborrany
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        String code = key.nextLine();
        int pos = code.indexOf("?"), num = 0, div = 0;

        for(int i = code.length(); i > 0; i--)
        {
            if((i-1) != pos)
            {
                num += Integer.parseInt(String.valueOf(code.charAt(code.length()-i))) * i;
            }
        }
        if(pos == 9)
        {
            while((div*(pos+1)+num)%11 != 0 && div <= 10)div++;
        }
        else
        {
            while((div*(pos+1)+num)%11 != 0 && div < 10)div++;
        }
        System.out.println((pos == 9 && div == 10 ? "X" : div));
        System.out.println(code);
        System.out.println(num);
    }
}
//6+10+12*2+10+6