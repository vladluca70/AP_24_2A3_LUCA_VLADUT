import java.util.Scanner;

public class Homework{
    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        
        int a, b, k;
        String result="";
        

        a=scanner.nextInt();
        b=scanner.nextInt();
        k=scanner.nextInt();

        

        //parcurgem intervalul [a,b] folosind un contor
        for(int contor=a; contor<=b; contor++)
        {

            //voi verifica fiecare numar din interval daca este k-reductibil
            //operatiile le voi face pe o copie a numarului
            int copyOfContor=contor;


            //aplicam operatiile respective pana cand numarul meu devine o cifra, caz in care 
            //ori de cate ori as face operatii pe numarul respectiv, acesta nu se mai modifica
            while (copyOfContor >9) 
            {
                //in aceasta instructiune repetitiva voi prelucra numarul, luand din numar cate o cifra
                //pe care o multiplic si o adaug variabilei kReductibil
                int kReductibil=0;

                while(copyOfContor!=0)
                {
                    int uc=copyOfContor%10;
                    kReductibil=kReductibil+uc*uc;
                    copyOfContor=copyOfContor/10;
                }

                //in caz ca numarul obtinut are mai mult de o cifra, procesul se mai poate repeta
                //motiv pentru care avem nevoie de ultima modificare a numarului1
                copyOfContor=kReductibil;
            }


            //daca numarul obtinut este egal cu acel k citit de la tastatura, atunci numarul este k-reductibil
            //in acest caz, convertesc numarul din tipul int in String si il concatenez cu 
            //variavila result care indica numerele din interval ce respecta proprietatea
            if(copyOfContor==k)
            {
                int kNumberToString= contor;
                String conversionOfContorToString= Integer.toString(kNumberToString);

                result=result+conversionOfContorToString+" ";

                copyOfContor=0;
            }
        }

        if(result.equals(""))
            System.out.println("Nu exista numere "+k+"-reductibile in interval");
        else
            System.out.println(result);

        
        long runningTimeMillis = System.currentTimeMillis() - startTimeMillis;
        System.out.println("Timp in milisecunde: " + runningTimeMillis );
        scanner.close();
    }
}
