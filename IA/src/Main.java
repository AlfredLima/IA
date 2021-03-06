import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final String DB = "../db.txt";
    private static final String QY = "../qy.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("Init system");

        BufferedReader db = null;
        BufferedReader qy = null;
        db = new BufferedReader(new FileReader(DB));
        qy = new BufferedReader(new FileReader(QY));

        System.out.println("Read files");

        List<String> assumptions = new LinkedList<String>();
        List<String> querys = new LinkedList<String>();


        String sCurrentLine;
        while ((sCurrentLine = db.readLine()) != null) {
            assumptions.add(sCurrentLine.replace(" ",""));
        }
        while ((sCurrentLine = qy.readLine()) != null) {
            querys.add(sCurrentLine.replace(" ",""));
        }

        db.close();
        qy.close();

        System.out.println("Resolution");

        SManager manager = new SManager(assumptions,querys);

    }
}
