public class calcuMafer implements CalculadoraGeneral{
    
    public String calculo (String  expresion){
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
        
        //Revisar cuantos operandos de cada tipo hay en la línea ingresada
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

       while(sum != 0 || rest != 0 || mult !=0 || div !=0 ){
            //revisar si todavía hay operandos
            for (int i = 0; i< nospace.length; i++){
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
                        uno = numbers.peek();
                        numbers.pop();
                        dos = numbers.peek();
                        numbers.pop();
                        result = uno + dos;
                        numbers.push(result);
                        retorno = retorno + "\n El resultado es: " + result;
                        sum = sum -1;
                    }else if(number.equals("-")){
                        uno = numbers.peek();
                        numbers.pop();
                        dos = numbers.peek();
                        numbers.pop();
                        result = dos - uno;
                        numbers.push(result);
                        retorno = retorno + "\n El resultado es: " + result;
                        rest = rest-1;
                    }else if(number.equals("*")){
                        uno = numbers.peek();
                        numbers.pop();
                        dos = numbers.peek();
                        numbers.pop();
                        result = dos * uno;
                        numbers.push(result);
                        retorno = retorno + "\n El resultado es: " + result;
                        mult = mult-1;
                    }else if(number.equals("/")){
                        uno = numbers.peek();
                        numbers.pop();
                        dos = numbers.peek();
                        numbers.pop();
                        result = dos / uno;
                        numbers.push(result);
                        retorno = retorno + "\n El resultado es: " + result;
                        div = div - 1;
                    }
                }
                
            }
            
        }
        return (retorno);
    }
}