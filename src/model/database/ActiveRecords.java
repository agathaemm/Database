
package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author leohilariao
 */
public class ActiveRecords extends Conexao {
    
    public ActiveRecords(String h, String u, String d, String p) {
        super(h, u, d, p);
    }
    
    public void Get() {
        
        String query = "SELECT * FROM usuarios";
        
        try {
            
            Statement st = this.Conectar().createStatement();
            
            ResultSet result = st.executeQuery(query);
            
            while ( result.next() ) {
                String Nome      = result.getString("Nome");
                String Sobrenome = result.getString("Sobrenome");
                String Apelido   = result.getString("Apelido");
                String Telefone  = result.getString("Telefone");
            
                System.out.println("Nome     : " + Nome);
                System.out.println("Sobrenome: " + Sobrenome);
                System.out.println("Apelido  : " + Apelido);
                System.out.println("Telefone : " + Telefone);
            }
            
            
            
        } catch ( SQLException e ) {
            System.out.println(e);
        }
        
    }
    
    public void Delete(String idRegistro) {
        
        String query = "DELETE FROM usuarios WHERE Usuarios_ID = " + idRegistro;
        
        try {
        
            Statement st = this.Conectar().createStatement();
            
            boolean result = st.execute(query);
            
            System.out.println("Os dados foram deletados com sucesso");
        
        } catch ( SQLException e ) {
            
            System.out.println( e );
        }
        
    }
    
    public void Insert(String n, String s, String t, String a) {
        
                
        String query = "INSERT INTO usuarios" + "(Nome, Sobrenome, Telefone, Apelido)" + "VALUES(?,?,?,?)";
        
        try {
            
            PreparedStatement st = this.Conectar().prepareStatement(query);
            
            st.setString(1, n);
            st.setString(2, s);
            st.setString(3, t);
            st.setString(4, a);
            
            st.execute();
            
            System.out.println("Os dados foram inseridos com sucesso");
                      
        }catch (SQLException e) {
            
            System.out.println(e);
            
        }
    }
    
    public void Update() {
        
        String query = "UPDATE usuarios SET Nome = ?, Sobrenome = ?, Telefone = ?, Apelido = ? WHERE Usuarios_ID = ?";
        
        try {
                    
            PreparedStatement st = this.Conectar().prepareStatement(query);
        
            st.setString(1, "Rebeca");
            st.setString(2, "Magalhães");
            st.setString(3, "(15)3017-6699");
            st.setString(4, "Rê");
            st.setString(5, "6");
        
            st.execute();
            
            System.out.println("Modificaçoes efetuadas com sucesso");
        
        }catch (SQLException e) {
            
            System.out.println(e);
            
        }
     
    }
    
}

