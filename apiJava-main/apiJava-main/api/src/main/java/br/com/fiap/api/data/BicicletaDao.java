package br.com.fiap.api.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.api.model.Bicicleta;
import jakarta.ws.rs.core.Response;

public class BicicletaDao {

	
	public void inserir(Bicicleta bicicleta) {
		String comdandoSql = "INSERT INTO tbl_bicicleta_tpm (num_serie, modelo, marca, cor, tamanho, tipo, valor, nota_fiscal, ano, cpf) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(comdandoSql)) {
        	System.out.println("bikes1");
	            preparedStatement.setInt(1, bicicleta.getNum_serie());
	            preparedStatement.setString(2, bicicleta.getModelo());
	            preparedStatement.setString(3, bicicleta.getMarca());
	            preparedStatement.setString(4, bicicleta.getCor());
	            preparedStatement.setString(5, bicicleta.getTamanho());
	            preparedStatement.setString(6, bicicleta.getTipo());
	            preparedStatement.setDouble(7, bicicleta.getValor());
	            preparedStatement.setInt(8, bicicleta.getNota_fiscal());
	            preparedStatement.setInt(9, bicicleta.getAno());
	            preparedStatement.setString(10, bicicleta.getCpf());
	            preparedStatement.executeUpdate();
	            System.out.println("bikes");
        } catch (SQLException e) {
        	System.out.println("catch");
            throw new RuntimeException("Erro ao inserir bicicleta", e);
        }
    }
	
	public Response consultar(String cpf) {
		 try (Connection conn = ConnectionFactory.createConnection()) {
	            String sql = "SELECT * FROM tbl_bicicleta_tpm WHERE cpf = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, cpf);

	            ResultSet resultSet = stmt.executeQuery();
	            System.out.println(resultSet.getStatement());
	            System.out.println(cpf);
	            List<Bicicleta> bicicletas = new ArrayList<>();

	            while (resultSet.next()) {
	            	System.out.println("bikes");
	                Bicicleta bicicleta = new Bicicleta();
	                bicicleta.setNum_serie(resultSet.getInt("num_serie"));
	                bicicleta.setModelo(resultSet.getString("modelo"));
	                bicicleta.setMarca(resultSet.getString("marca"));
	                bicicleta.setCor(resultSet.getString("cor"));
	                bicicleta.setTamanho(resultSet.getString("tamanho"));
	                bicicleta.setTipo(resultSet.getString("tipo"));
	                bicicleta.setValor(resultSet.getDouble("valor"));
	                bicicleta.setNota_fiscal(resultSet.getInt("nota_fiscal"));
	                bicicleta.setAno(resultSet.getInt("ano"));
	                bicicleta.setCpf(resultSet.getString("cpf"));

	                bicicletas.add(bicicleta);
	                System.out.println(bicicleta);
	            }


	            if (!bicicletas.isEmpty()) {
	                return Response.status(Response.Status.OK).entity(bicicletas).build();
	            } else {
	                return Response.status(Response.Status.NOT_FOUND).entity("Bicicletas não encontradas").build();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao acessar o banco de dados.").build();
	        }
        
    }
	

}
