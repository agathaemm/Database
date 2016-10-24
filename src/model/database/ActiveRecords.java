
package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author leohilariao
 */
public class ActiveRecords extends Conexao {
    
    private String Tabela = "";
    private ArrayList<String> campo = new ArrayList();
    private String Value;
    
    public ActiveRecords(String h, String u, String d, String p) {
        super(h, u, d, p);
        
    }

    public String getTabela() {
        return Tabela;
    }

    public void setTabela(String Tabela) {
        this.Tabela = Tabela;
    }

    public void setCampo(ArrayList<String> campo) {
        this.campo = campo;
    }

    public ArrayList<String> getCampo() {
        return campo;
    }
 
    
    public void Get() {
        
        String query = "SELECT * FROM " + Tabela;
        
        try {
            
            Statement st = this.Conectar().createStatement();
            
            ResultSet result = st.executeQuery(query);
            
            while ( result.next() ) {
                    
               for (String c : campo) {
                   
                   ArrayList<String> ct = new ArrayList();
                   
                   String cmp;
                   cmp = result.getString(c);
                   ct.add(cmp);
                   
                   System.out.println(c + " : " + cmp);
                   
               }
               
                System.out.println("------------------------------");
               
                //String Nome      = result.getString("Nome");
                //String Sobrenome = result.getString("Sobrenome");
                //String Apelido   = result.getString("Apelido");
                //String Telefone  = result.getString("Telefone");
            
                //System.out.println("Nome     : " + Nome);
                //System.out.println("Sobrenome: " + Sobrenome);
                //System.out.println("Apelido  : " + Apelido);
                //System.out.println("Telefone : " + Telefone);
                
               
            }
            
        } catch ( SQLException e ) {
            System.out.println(e);
        }
        
    }
    
    public void Delete(String idRegistro) {
        
        String query = "DELETE FROM " + Tabela + " WHERE Usuarios_ID = " + idRegistro;
        
        try {
        
            Statement st = this.Conectar().createStatement();
            
            boolean result = st.execute(query);
            
            System.out.println("Os dados foram deletados com sucesso");
        
        } catch ( SQLException e ) {
            
            System.out.println( e );
        }
        
    }
    
    public void Insert(String n, String s, String t, String a) {
        
                
        String query = "INSERT INTO" + Tabela + "(Nome, Sobrenome, Telefone, Apelido) VALUES(?,?,?,?)";
        
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
        
        //String query = "UPDATE" + Tabela + "SET Nome = ?, Sobrenome = ?, Telefone = ?, Apelido = ? WHERE Usuarios_ID = ?";
        for(String c : campo) {

                String query = "UPDATE" + Tabela + "SET" + c + " = " + "?";

            try {

                PreparedStatement st = this.Conectar().prepareStatement(query);

                for(int x = 0; x < campo.size(); x++) {

                    st.setString(x+1, "Rebeca");

                }

                st.execute();

                System.out.println("Modificaçoes efetuadas com sucesso");

            }catch (SQLException e) {

                System.out.println(e);

            }
        
        }
     
    }

    
}

