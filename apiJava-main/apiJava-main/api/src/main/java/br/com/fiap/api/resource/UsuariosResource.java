package br.com.fiap.api.resource;

import br.com.fiap.api.model.Usuario;
import br.com.fiap.api.service.UsuarioService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("usuarios")
public class UsuariosResource {

	private UsuarioService userServ = new UsuarioService();

	@GET
	@Path("/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarioByCPF(@PathParam("cpf") String cpf) {
		return userServ.consultar(cpf);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postUsuarios(Usuario user) {
		userServ.cadastrar(user);
		return Response.status(Response.Status.CREATED).build();
	}
}