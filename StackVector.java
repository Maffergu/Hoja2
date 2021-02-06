//María Fernanda Argueta 20458
//Hoja 2

import java.util.*; 

public class StackVector<E> implements Stack<E>{ 

    Vector<E> nums = new Vector<E>(); 

    public void push(E item){
        // pre: 
        // post: item is added to stack
        // will be popped next if no intervening push
        nums.add(item);
    }
    
    public E pop(){
        // pre: stack is not empty
        // post: most recently pushed item is removed and returned
        return nums.remove(size()-1);
    }
    
    
    public E peek() {
        // pre: stack is not empty
        // post: top value (next to be popped) is returned
        return nums.get(size()-1);
    }
    
    public boolean empty(){
        // post: returns true if and only if the stack is empty
       boolean retorno = false;
       if(nums.isEmpty() == false){
          retorno = false;
       }else{
          retorno = true;
       }
       return retorno;
    }
    
    public int size(){
        // post: returns the number of elements in the stack
       return (nums.size()); 
    }
    
}