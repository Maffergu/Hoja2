//María Fernanda Argueta 20458
//Hoja 2
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

        //Se verifica que exista la ruta
        //pre: valor ingresado de ruta
        try {
          //post: operaciones realizadas según lo descrito en el txt
            File myObj = new File(docname+".txt");
            Scanner myReader = new Scanner(myObj);
            //ir haciendo las operaciones línea por línea
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              //hacer la operación de la línea actual
              System.out.println(calcula.calculo(data));
              
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            //post: mensaje de error
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }

}
