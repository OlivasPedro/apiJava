package br.com.fiap.api.resource;

import br.com.fiap.api.model.Bicicleta;
import br.com.fiap.api.service.BicicletaService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("bicicletas")
public class BicicletasResource {

	private BicicletaService bikeServ = new BicicletaService();

	@GET
	@Path("/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBicicletasByCPF(@PathParam("cpf") String cpf) {
		return bikeServ.consultar(cpf);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postBicicletas(Bicicleta bike) {
		bikeServ.cadastrar(bike);
		return Response.status(Response.Status.CREATED).build();
	}

}