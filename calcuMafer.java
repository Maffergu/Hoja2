public class calcuMafer implements CalculadoraGeneral{
    
    public void calculo (String  expresion){
        String retorno = "";
        boolean operaleft = false;
        boolean resultado = false;
        int result = 0;
        StackVector<Integer> numbers = new StackVector<Integer>();
        
        String[] nospace = expresion.split(" ");
        while(operaleft != true){
            //revisar si todavía hay operandos
            for (int x = 0; x < nospace.length; x++) {
                if (nospace[x].equals("+") || nospace[x].equals("-") || nospace[x].equals("*") || nospace[x].equals("/")) {
                  operaleft = false;
                }
              }
            for (int i = 1; i< nospace.length; i++){
                String number = nospace[i];
                try {
                    Integer.parseInt(number);
                    //Esto quiere decir que el valor que se está leyendo es un número
                    //resultado = true;
                    numbers.push(Integer.parseInt(number));
                    System.out.println("Agregado el "+number);
                } catch (NumberFormatException excepcion) {
                    //resultado = false;
                    //Esto significa que el valor que se está leyendo es un operador
                    if(number.equals("+")){
                        int uno = numbers.peek();
                        numbers.pop();
                        int dos = numbers.peek();
                        numbers.pop();
                        result = uno + dos;
                        numbers.push(result);
                        retorno = "\n El resultado es: " + result;
                        System.out.println(retorno);
                    }else if(number.equals("-")){
                        int uno = numbers.peek();
                        numbers.pop();
                        int dos = numbers.peek();
                        numbers.pop();
                        result = dos - uno;
                        numbers.push(result);
                        retorno = "\n El resultado es: " + result;
                        System.out.println(retorno);
                    }
                }
    
                
            }
        }
        
        
        
        //return (retorno);
    }
}