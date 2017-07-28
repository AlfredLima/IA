/**
 * Created by alfredo on 24/07/17.
 */

public class ComplexSentence extends Sentence{

    Sentence left = null;
    Sentence right = null;
    Operator operator = null;

    public ComplexSentence( String sentence ){
        this.name = sentence;
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

    public Boolean solve(Assumptions assumptions){

        int idx = name.indexOf("->");
        if( idx != -1 ) {
            operator = new Implies();
        }

        Boolean answer = operator.execute( name.substring(0,idx) ,name.substring(idx+2,name.length()),assumptions);
        return answer;
    }

}
