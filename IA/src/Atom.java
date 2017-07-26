/**
 * Created by alfredo on 24/07/17.
 */


public class Atom extends Sentence {

    public Atom(String name, Boolean value){

        this.value = value;
    }

    public Boolean getValue(){
        return  value;
    }
    public void setValue(Boolean value ) {
        this.value = value;
    }

}
