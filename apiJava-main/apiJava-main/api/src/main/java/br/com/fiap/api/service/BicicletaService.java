package br.com.fiap.api.service;

import br.com.fiap.api.data.BicicletaDao;
import br.com.fiap.api.model.Bicicleta;
import jakarta.ws.rs.core.Response;


public class BicicletaService {
	
	private BicicletaDao bikeDao = new BicicletaDao();

	public Response consultar(String cpf) {
		return bikeDao.consultar(cpf);
	}
	
	public void cadastrar(Bicicleta bike) {
		bikeDao.inserir(bike);
	}
}
