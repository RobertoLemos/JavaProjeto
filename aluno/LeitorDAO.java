package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.unicid.model.Leitor;
import br.edu.unicid.util.ConnectionFactory;

public class LeitorDAO {
	
	private Connection conn; //conexao
	private PreparedStatement ps;
	private ResultSet rs;
	private Leitor leitor;
	
	public LeitorDAO() throws Exception {
		
		try {
			conn = ConnectionFactory.getConnection();
		}
		catch(Exception e) 
		{
			throw new Exception ("Erro: " + e.getMessage());
		}
		
		
		
	}
	
	
	public void salva(Leitor leitor) throws Exception {
		
		try {
			
			String sql = "INSERT INTO tbLeitor(codleitor, "
					        +  "nomeLeitor, tipoLeitor)"
							+ "values(?, ?, ?)" ;
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, leitor.getCodLeitor());
			ps.setString(2, leitor.getNomeLeitor());
			ps.setNString(3, leitor.getTipoLeitor());
			ps.executeUpdate();
			
		}
		catch(Exception e) {
			throw new Exception ("Erro: " + e.getMessage());
		}
	}
}

//Leitor leitor = new Leitor ();
//leitor.getCodLeitor(ExtCodLeitor.getText());