import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String []languages= {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n=(int)(Math.random()*1_000_000);
        n=n*3;
        n=n+21; //10101 binary=21
        n=n+255; //FF hexadecimal =255
        n=n*6;
        while(n>10)
        {
            int copie=n;
            int suma=0;
            int ultimaCifra;

            while (copie!=0) {
                ultimaCifra=copie%10;
                copie=copie/10;
                suma=suma+ultimaCifra;
            }
            n=suma;
        }

            System.out.println("Willy-nilly, this semester I will learn "+ languages[n]);
        
    }
}