/**
 * Created by alfredo on 24/07/17.
 */
public class Implies implements Operator{

    @Override
    public Boolean execute(Sentence left, Sentence right) {
        if ( left.validation() ){
            if( right instanceof  Atom ){
                right = (Atom)right;
                ((Atom) right).setValue(true);
            }
            return true;
        }
        return false;
    }
}
