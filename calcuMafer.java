//María Fernanda Argueta 20458
//Hoja 2

public class calcuMafer implements CalculadoraGeneral{
    
    public String calculo (String  expresion){
        //pre: String con espacios, números y operandos
        String retorno = "";
        boolean operaleft = false;
        boolean resultado = false;
        int sum = 0;
        int rest = 0;
        int mult = 0;
        int div = 0;
        int result = 0;
        int uno = 0;
        int dos =0;
        StackVector<Integer> numbers = new StackVector<Integer>();

        //pre: string con espacios
        //Revisar cuantos operandos de cada tipo hay en la línea ingresada
        //post: arreglo con los valores contenidos en el string separados por espacio
        String[] nospace = expresion.split(" ");
        
        for (int x = 0; x < nospace.length; x++) {
            if (nospace[x].equals("+")) {
              sum = sum +1;
            }else if (nospace[x].equals("-")) {
                rest = rest + 1;
            }else if (nospace[x].equals("*")) {
                mult = mult+ 1;
            }else if (nospace[x].equals("/")) {
                div = div +1;
            }
        }


        //Si todavía hay operandos se sigue el programa, sino se devuelve el resultado al main
       while(sum != 0 || rest != 0 || mult !=0 || div !=0 ){
            //revisar si todavía hay operandos
            for (int i = 0; i< nospace.length; i++){
                //ir revisando cada uno de los valores agregados 
                String number = nospace[i];
                try {
                    Integer.parseInt(number);
                    //Esto quiere decir que el valor que se está leyendo es un número
                    //resultado = true;
                    numbers.push(Integer.parseInt(number));
                } catch (NumberFormatException excepcion) {
                    //resultado = false;
                    //Esto significa que el valor que se está leyendo es un operador
                    if(number.equals("+")){
                        //tomar los últimos dos valores ingresados para realizar la operación
                        uno = numbers.peek();
                        //eliminar el primero del stack
                        numbers.pop();
                        dos = numbers.peek();
                        //eliminar el segundo del stack
                        numbers.pop();
                         //hacer la operación
                        result = uno + dos;
                        //almacenar el resultado en el stack
                        numbers.push(result);
                        //Definir el valor del retorno agragando los resultados anteriores
                        retorno = retorno + "\n El resultado es: " + result;
                        //quitar de la cuenta el símbolo utilizado
                        sum = sum -1;
                    }else if(number.equals("-")){
                        //tomar los últimos dos valores ingresados para realizar la operación
                        uno = numbers.peek();
                        //eliminar el primero del stack
                        numbers.pop();
                        dos = numbers.peek();
                        //eliminar el segundo del stack
                        numbers.pop();
                         //hacer la operación
                        result = dos - uno;
                        //almacenar el resultado en el stack
                        numbers.push(result);
                        //definir el valor del retorno
                        retorno = retorno + "\n El resultado es: " + result;
                        //quirar uno a la cantidad de operandos de resta
                        rest = rest-1;
                    }else if(number.equals("*")){
                        //tomar los últimos dos valores ingresados para realizar la operación
                        uno = numbers.peek();
                        //eliminar el primero del stack
                        numbers.pop();
                        dos = numbers.peek();
                        //eliminar el segundo del stack
                        numbers.pop();
                         //hacer la operación
                        result = dos * uno;
                        //almacenar el resultado en el stack
                        numbers.push(result);
                        //definir el valor del retorno
                        retorno = retorno + "\n El resultado es: " + result;
                        //quitar uno a la cantidad de *
                        mult = mult-1;
                    }else if(number.equals("/")){
                        //tomar los últimos dos valores ingresados para realizar la operación
                        uno = numbers.peek();
                        //eliminar el primero del stack
                        numbers.pop();
                        dos = numbers.peek();
                        //eliminar el segundo del stack
                        numbers.pop();
                        //hacer la operación
                        result = dos / uno;
                        //almacenar el resultado en el stack
                        numbers.push(result);
                        //definir el valor de retorno
                        retorno = retorno + "\n El resultado es: " + result;
                        //quitar uno a la cantidad de simbolos / 
                        div = div - 1;
                    }
                }
                
            }
            
        }
        //post: resultado de las operaciones descritas en la línea de texto
        return (retorno);
    }
}