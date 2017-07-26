import java.util.List;

/**
 * Created by alfredo on 25/07/17.
 */
public class Manager {

    List< Sentence > sentences;
    Assumptions assumptions;
    public Manager(List<String> assumptions, List<String> query) {
        for (String assumption : assumptions ) {
            int idx = assumption.indexOf("->");
            if( idx == -1 ){

            }
        }
    }

}
