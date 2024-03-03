import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();

        if(n<4)
        {
            System.out.println("Valoarea lui n trebuie sa fie mai mare decat 4");
            scanner.close();
            return;
        }

        int[][] matrix = new int[n][n];


        //ca si in imaginea pe care am adaugat-o in repository, vom incepe numerotarea nodurilor cu nodul din centru
        //fiind un graf neorientat, vom initializa diagonala principala cu 0
        //prima coloana si prima linie vor fi initializate din start cu 1 deoarece nodul din centru are vecini toate nodurile in afara de el
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
            matrix[i][i] = 0;
            
        }

        //vom parcurge partea de deasupra diagonalei principale
        for (int i = 1; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) 
            {

                //nodul numerotat cu 2(i=1) are ca vecini nodurile 1, 3 si ultimul nod
                //celelalte noduri(excludem 1 si 2) au ca vecini pe nodul 1 si nodurile i-1 si i+1
                if (i == 1) 
                {
                    if ((j == n - 1) || (j == i + 1))
                        matrix[i][j] = 1;
                    else
                        matrix[i][j] = 0;
                }
                
                

                else 
                {
                    if ((i == j - 1) || (i == j + 1))
                        matrix[i][j] = 1;
                    else
                        matrix[i][j] = 0;
                }
            }

        //matricea unui graf neorientat are elementele de deasupra diagonalei principale simetrice cu cele de sub diagonala principala
        for(int i=0; i<n-1; i++)
            for(int j=1; j<n; j++)
                matrix[j][i]=matrix[i][j];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
