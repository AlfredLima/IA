import java.util.List;

/**
 * Created by alfredo on 25/07/17.
 */
public class SManager {

    Assumptions assumptions;
    public SManager(List<String> assumptions, List<String> query) {

        for (String assumption : assumptions ) {
            int idx = assumption.indexOf("->");
            Sentence sentence;
            if( idx == -1 ){
                sentence = new Atom(assumption,true);
                this.assumptions.addAtom( (Atom)sentence );
            }
            else{
                sentence = new ComplexSentence( assumption );
                this.assumptions.addSentence(sentence);
            }

        }

                

    }

}