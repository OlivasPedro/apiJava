package br.com.fiap.api.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.api.model.Usuario;
import jakarta.ws.rs.core.Response;

public class UsuarioDao {
	
	
	public void inserir(Usuario usuario) {
		String comandoSql = "INSERT INTO tbl_usuarios_tpm (cpf, nome, data_nascimento ,rua ,numero ,complemento, bairro, cidade, estado, email, senha) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql)) {
	            preparedStatement.setString(1, usuario.getCpf());
	            preparedStatement.setString(2, usuario.getNome());
	            java.util.Date utilDate = usuario.getData_nascimento();
	            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	            preparedStatement.setDate(3, sqlDate);
	            preparedStatement.setString(4, usuario.getRua());
	            preparedStatement.setInt(5, usuario.getNumero());
	            preparedStatement.setString(6, usuario.getComplemento());
	            preparedStatement.setString(7, usuario.getBairro());
	            preparedStatement.setString(8, usuario.getCidade());
	            preparedStatement.setString(9, usuario.getEstado());
	            preparedStatement.setString(10, usuario.getEmail());
	            preparedStatement.setString(11, usuario.getSenha());
	            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir usuário", e);
        }
		
    }
	
	
	public Response consultar(String cpf) {
		try (Connection conn = ConnectionFactory.createConnection()) {
			String sql = "SELECT * FROM tbl_usuarios_tpm WHERE cpf = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cpf);

			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setData_nascimento(resultSet.getDate("data_nascimento"));
				usuario.setRua(resultSet.getString("rua"));
				usuario.setNumero(resultSet.getInt("numero"));
				usuario.setComplemento(resultSet.getString("complemento"));
				usuario.setBairro(resultSet.getString("bairro"));
				usuario.setCidade(resultSet.getString("cidade"));
				usuario.setEstado(resultSet.getString("estado"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));

				return Response.status(Response.Status.OK).entity(usuario).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao acessar o banco de dados.")
					.build();
		}
	}

}
