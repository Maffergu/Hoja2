import java.util.*; 

public class StackVector<E> implements Stack<E>{ 

    Vector<E> nums = new Vector<E>(); 

    public void push(E item){
        nums.add(item);
    }
    
    public E pop(){
        // pre: stack is not empty
        // post: most recently pushed item is removed and returned
        return nums.remove(size()-1);
    }
    
    
    public E peek() {
        
        return nums.get(size()-1);
    }
    
    public boolean empty(){
       boolean retorno = false;
       if(nums.isEmpty() == false){
          retorno = false;
       }else{
          retorno = true;
       }
       return retorno;
    }
    
    public int size(){
       return (nums.size()); 
    }
    
}