package model.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leohilariao
 */
public abstract class Conexao {
    
    private String DataBase;
    private String UserName;
    private String Password;
    private String Host;
    
    public static String status = "Nao conectou...";
    
    public Conexao(String h, String u, String d, String p) {
       this.UserName = u;
       this.DataBase = d;
       this.Host = h;
       this.Password = p;
    }
    
    //Faz a conexao com o banco de dados
    public java.sql.Connection Conectar() {
        
        //Cria uma nova conexao e seta como null
        Connection conexao = null;
        
        //tenta realizar a conexao
        try {
            
            //Carrega o drive
            String nomeDrive = "com.mysql.jdbc.Driver";
            Class.forName(nomeDrive);
            
            String nomeServer = this.Host;
            String dataBase   = this.DataBase;
            String url        = "jdbc:mysql://" + nomeServer + "/" + dataBase;
            String user       = this.UserName;
            String password   = this.Password;
            
            //Faz a conexao
            conexao = DriverManager.getConnection(url, user, password);
            
            //indicar o status da conexao
            if (conexao != null) {
                
                status = "conectado com sucesso";
                
            }else {
                
                status = "nao foi possivel realizar a conexao";
                
            }
            
            return conexao;           
            
        }catch (ClassNotFoundException e) {
            
            System.out.println("Nao foi possivel conetar ao banco de dados");
            
            return null;
   
        }catch (SQLException e){
            
            System.out.println("As informacaoes informadas estao incorretas");
            System.out.println(e);
            
            return null;
            
        }
        
    }
    
    //retorna o status da conexao com o banco de dados
    public String statusConexao() {
        return status;
    }
    
    //Fecha a conexao com o banco de dados
    public boolean fechaConexao() {
        
        try {
            
            this.Conectar().close();
            
            return true;
            
        }catch (SQLException e) {
            
            return false;
            
        }
    }
    
    //Reinicia a conexao com o banco de dados
    public java.sql.Connection reiniciarConexao() {
        
        this.fechaConexao();
        
        return this.Conectar();
    }
    
}
