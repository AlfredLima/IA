

import java.util.*;

/**
 * Created by alfredo on 25/07/17.
 */
public final class Assumptions {

    private Map< String , Sentence > sentences;
    private Map< String , Atom > atoms;
    private Queue<String> queueSolveds;
    private Queue<Atom> tempAtoms;
    private Queue<String> tempSolvers;
    private Queue<Sentence> tempSentences;
    private Set<String> setAtoms;

    public Assumptions(){

        sentences = new HashMap< String , Sentence >();
        atoms = new HashMap< String , Atom >();
        queueSolveds = new LinkedList<String>();
        tempAtoms = new LinkedList<Atom>();
        tempSentences = new LinkedList<Sentence>();
        tempSolvers = new LinkedList<String>();
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

        System.out.println("Solved");

        transfer();

        System.out.println("Transfer");
        while ( !queueSolveds.isEmpty() ){
            String element = queueSolveds.poll();
            setAtoms.add(element);
            for ( String sentence : sentences.keySet() ) {
                System.out.print("E: " + element + " - " + sentence);
                if( sentence.contains(element) ){
                    System.out.print(" - Check");
                    Sentence sent = sentences.get(sentence);
                    if (sent instanceof ComplexSentence ) {

                        System.out.print(" - Complex");
                        ComplexSentence complexSentence = (ComplexSentence) sent;
                        if( complexSentence.solve(this) )
                            complexSentence.setValue(true);
                    }
                }
                System.out.println();
            }
        }
        if( !tempSolvers.isEmpty() )
            solved();
    }

    private void transfer(){

        while ( !tempSolvers.isEmpty() ) {
            String e = tempSolvers.poll();
            if( !setAtoms.contains(e) )
                queueSolveds.add(e);
        }

        while ( !tempAtoms.isEmpty() )
            atoms.put( tempAtoms.element().name, tempAtoms.poll() );

        while ( !tempSentences.isEmpty() )
            sentences.put( tempSentences.element().name, tempSentences.poll() );

    }

    public void test(){
        System.out.println("----------------Atoms----------------");
        for ( String atom : atoms.keySet() ) {
            System.out.println(atom);
        }
        System.out.println("-------------------------------------");
    }

}
