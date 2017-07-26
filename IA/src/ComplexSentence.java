/**
 * Created by alfredo on 24/07/17.
 */
public class ComplexSentence implements Sentence{

    Sentence left = null;
    Sentence right = null;
    Operator operator = null;

    public ComplexSentence( String sentence ){
        int idx = sentence.indexOf("->");
        if( idx == -1 ){


            return;
        }
        operator = new Implies();
        left = new ComplexSentence( sentence.substring(0,idx) );
        right = new ComplexSentence( sentence.substring(idx+2,sentence.length()) );
    }

    public Sentence getLeftSetence(){
        return left;
    }

    public Sentence getRightSetence(){
        return right;
    }

    public Operator getOperator(){
        return operator;
    }

    public Boolean validation(){
        return operator.execute(left,right);
    }

    public Boolean isAtom(){
        if((left == null) && (right == null)){
            return true;
        }
        return false;
    }

}
