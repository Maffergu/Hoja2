import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException;
public class main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        calcuMafer calcula = new calcuMafer();
        String docname = "";
        System.out.println("Bienvenido a la calculadora, ingrese el nombre del archivo de texto a utilizar");
        docname = scan.nextLine();
        System.out.println("Grax");

        try {
            File myObj = new File(docname+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              calcula.calculo(data);
              
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }

}
