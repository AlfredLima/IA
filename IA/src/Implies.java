/**
 * Created by alfredo on 24/07/17.
 */
public class Implies implements Operator{

    @Override
    public Boolean execute(String left, String right, Assumptions assumptions) {
        Atom leftAtom = assumptions.getAtom(left);
        Atom rightAtom = assumptions.getAtom(right);
        if( leftAtom != null ){
            if( rightAtom == null ){
                rightAtom = new Atom(right,leftAtom.value);
                assumptions.addAtom(rightAtom);
            }
            return true;
        }
        else if( rightAtom != null ){
            if( leftAtom == null ){
                leftAtom = new Atom(left,rightAtom.value);
                assumptions.addAtom(leftAtom);
            }
        }
        return false;
    }
}
