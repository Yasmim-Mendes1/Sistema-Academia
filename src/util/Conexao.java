/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Yasmim Mendes
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection conector;
    
    public void conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/academia";
            String usuario = "root";
            String senha = "1234";
            conector = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Aplicação conectada com Banco!");
        }catch(ClassNotFoundException e){
            System.out.println("Driver não encontrado! "+ e.getMessage());
        }catch(SQLException e){
            System.out.println("Erro na conexão com banco!"+e.getMessage());
        }
    }
    public void desconectar(){
        try{
            conector.close();
        }catch(SQLException e){
            System.out.println("Erro ao fechar conexão!"+e.getMessage());
        }
    }
}