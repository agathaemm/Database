
import java.util.ArrayList;
import java.util.Scanner;
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
        ArrayList<String> camp = new ArrayList();
        String campo;
        String continua;
        String reg;
        
        Scanner entrada = new Scanner(System.in);
        
        //seta o nome da tabela
        c.setTabela("Usuarios");
        
        //SETA OS CAMPOS DA TABELA 
        /*do {
            
            System.out.println("Digite o campo: ");
            campo = entrada.next();
            camp.add(campo);
            c.setCampo(camp);
            
            System.out.println("Deseja continuar(s/n): ");
            continua = entrada.next();
            
        }while(continua.equals("sim"));
        
        c.Get();
        **/
        
        //DELETA UM REGISTRO DA TABELA
        System.out.println("Digite o registro q deseja deletar: ");
        reg = entrada.next();
        
        c.Delete(reg);
        
        //System.out.println("---->" + c.getCampo());
        
        
        
        //c.Insert("Marifanza", "Magalhães", "(15)3017-6699", "Mara");
        //c.Update();
    }
}
