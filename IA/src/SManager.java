import java.util.List;

/**
 * Created by alfredo on 25/07/17.
 */
public class SManager {

    Assumptions assumptions = new Assumptions();
    public SManager(List<String> assumptions, List<String> querys) {

        for (String assumption : assumptions ) {
            System.out.println("Sentence " + assumption);
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

        this.assumptions.solved();

        System.out.println("--------------------****--------------------");
        System.out.println("Querys:");

        for ( String query : querys ) {
            if( this.assumptions.getAtom(query) != null ){
                System.out.println( this.assumptions.getAtom(query) );
            }
            else{
                System.out.println( query + " - Not have information " );
            }
        }

        this.assumptions.test();


    }

}