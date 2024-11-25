
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("D:\\UCU 4to semestre\\AED\\UT5\\ut05-m301-equipo-6\\TA3\\src\\main\\java\\palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        System.out.println(trie.predecir("co"));
    }
}