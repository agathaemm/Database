
import model.database.ActiveRecords;
import model.database.Conexao;

/*
 * pra quarta feira:  insert update --> prof: Vilas Bôas
 */

/**
 *
 * @author leohilariao
 */
public class Teste {
    public static void main(String[] args){
        ActiveRecords c = new ActiveRecords("127.0.0.1","root","rocket","");
       
        c.Get();
        c.Delete("1");
        c.Insert("Marifanza", "Magalhães", "(15)3017-6699", "Mara");
        c.Update();
    }
}
