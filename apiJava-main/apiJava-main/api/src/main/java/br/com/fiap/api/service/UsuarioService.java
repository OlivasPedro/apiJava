package br.com.fiap.api.service;

import br.com.fiap.api.data.UsuarioDao;
import br.com.fiap.api.model.Usuario;
import jakarta.ws.rs.core.Response;

public class UsuarioService {
	private UsuarioDao userDao = new UsuarioDao();

	public Response consultar(String cpf) {
		return userDao.consultar(cpf);
	}
	
	public void cadastrar(Usuario user) {
		userDao.inserir(user);
	}
}
