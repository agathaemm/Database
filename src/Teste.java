
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
    
    
    //---------------MENU-----------------//
        public static void Menu(){
            
            System.out.println("1-Select");
            System.out.println("2-Delete");
            System.out.println("3-Insert");
            System.out.println("4-Update");
            System.out.println("5-Sair");
            System.out.print("Digite a opcao: ");
            
        }
       
   
    public static void main(String[] args){
        
        ActiveRecords c = new ActiveRecords("127.0.0.1","root","rocket","");
        
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do {
            
            Menu();
            opcao = entrada.nextInt();
            
            switch (opcao) {
                case 1:
                    
                    c.setTabela("Usuarios");
                    
                    ArrayList<String> camp = new ArrayList();
                    String campo;
                    String continua;
                    
                    do {
            
                            System.out.println("Digite o campo: ");
                            campo = entrada.next();
                            camp.add(campo);
                            c.setCampo(camp);

                            System.out.println("Deseja continuar(s/n): ");
                            continua = entrada.next();
            
                    }while(continua.equals("sim"));
                    c.Select();
                    break;
                 
                case 2 :
                    
                    c.setTabela("usuarios");
                    c.Delete("1");
                    break;
                    
                case 3: 
                    
                    c.setTabela("usuarios");
                    c.Insert("Marifanza", "Magalhães", "(15)3017-6699", "Mara");
                    break;
                    
                case 4:
                    
                    c.setTabela("usuarios");
                    c.Update(); 
                    break;
                    
                default:
                    System.out.println("Opcao invalida");
                    break;
                           
            }
        
        
        }while (opcao != 0);

    }  

}
        
        

