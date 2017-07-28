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
            assumptions.addInQueue(right);
            rightAtom.setValue(leftAtom.getValue());
            System.out.println("Applied modus ponies: " + left + "->" + right);
            return true;
        }
        return false;
    }
}
