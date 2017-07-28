

import java.util.*;

/**
 * Created by alfredo on 25/07/17.
 */

public final class Assumptions {

    private Map< String , Sentence > sentences;
    private Map< String , Atom > atoms;
    private Queue<String> queueSolveds;
    private Set<Atom> tempAtoms;
    private Set<String> tempSolvers;
    private Set<Sentence> tempSentences;
    private Set<String> setAtoms;

    public Assumptions(){

        sentences = new HashMap< String , Sentence >();
        atoms = new HashMap< String , Atom >();
        queueSolveds = new LinkedList<String>();
        tempAtoms = new HashSet<Atom>();
        tempSentences = new HashSet<Sentence>();
        tempSolvers = new HashSet<String>();
        setAtoms = new HashSet<String>();

    }

    public Atom getAtom( String name ){
        if( atoms.containsKey(name) ){
            return atoms.get(name);
        }
        return null;
    }

    public void addSentence(Sentence sentence) {
        tempSentences.add(sentence);
    }

    public void addInQueue(String atom){
        System.out.println("Step into queue of solved " + atom);
        tempSolvers.add(atom);
    }

    public void addAtom(Atom atom){
        tempAtoms.add(atom);
        addInQueue(atom.name);
        addSentence(atom);
    }


    public void solved(){

        transfer();

        while ( !queueSolveds.isEmpty() ){
            String element = queueSolveds.poll();
            setAtoms.add(element);
            for ( String sentence : sentences.keySet() ) {
                if( sentence.contains(element) ){
                    Sentence sent = sentences.get(sentence);
                    if (sent instanceof ComplexSentence ) {
                        ComplexSentence complexSentence = (ComplexSentence) sent;
                        if( sent.getValue() != null )
                            continue;
                        if( complexSentence.solve(this) )
                            complexSentence.setValue(true);
                    }
                }
            }
        }
        if( !tempSolvers.isEmpty() )
            solved();
    }

    private void transfer(){

        for ( String solved : tempSolvers )
            if( !setAtoms.contains(solved) )
                queueSolveds.add(solved);

        tempSolvers.clear();

        for ( Atom atom : tempAtoms )
            atoms.put( atom.name, atom );

        tempAtoms.clear();

        for( Sentence sentence : tempSentences )
            sentences.put( sentence.name, sentence );

        tempSentences.clear();

    }

    public void test(){
        System.out.println("----------------Atoms----------------");
        for ( String atom : atoms.keySet() ) {
            System.out.println(atom);
        }
        System.out.println("-------------------------------------");
    }

}
