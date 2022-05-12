import java.io.*;
import java.util.Scanner;

class Helper{
    public int binToDec(String[] s1){             
        String binaryString="1111";  
        int decimal=Integer.parseInt(binaryString,2);  
        System.out.println(decimal);
        return decimal;
    }
}

class ALU{
    public String ADD(String[] s1, String[] s2){
        String result;
        Helper a = new Helper();
        int res = a.binToDec(s1) + a.binToDec(s2);
        result = a.decToBin(res);
        return result;
    }
}
class Main{
    public String[][] codes;
    public int[] register = new int[8];
    public static void main(String[] args){

        File file = new File(".\\test.txt");
        try {
            Main m = new Main();
            m.fileRead(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public String[][] fileRead(File file) throws FileNotFoundException
    {
        int lines = 0;
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
            {sc.nextLine();
            lines++;}
        codes = new String[lines][4];
        sc = new Scanner(file);

        for(int i = 0; i<lines; i++)
        {
            String temp[] = sc.nextLine().split(" ", 4);
            for(int j = 0; j < 4; j++)
            {
                codes[i][j] = temp[j];
            }
        }

        for(int i = 0; i < lines; i++)
        {
            for (int j = 0; j < 4; j++) {
                System.out.print(" "+codes[i][j]);
            }
            System.out.println();
        }

        return codes;
    }

    public int binToRegister(String s)
    {
        switch(s)
        {
            case "10000001":
                return 0;
            case "10000010":
                return 1;
            case "10000011":
                return 2;
            case "10000100":
                return 3;
            case "10000101":
                return 4;
            case "10000110":
                return 5;
            case "10000111":
                return 6;
            case "10001000":
                return 7;
            default:
                return -1;
        }
    }
}