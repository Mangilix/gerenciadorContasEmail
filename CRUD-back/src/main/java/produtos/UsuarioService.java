package produtos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {
    
    @PersistenceContext(unitName = "ProdutosPU")
    private EntityManager entityManager;
        
    public  UsuarioService() {
    }
    
    @GET
    public List<Usuario> getUsuario() {
        Query query = entityManager.createQuery("SELECT p FROM Usuario p");
        return query.getResultList();
    }
    
    @POST
    public Usuario adcionar(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }
    
    @PUT
    @Path("{codigo}")
    public Usuario atualizar(@PathParam("codigo") Integer codigo, Usuario usuarioAtualizado) {
        Usuario UsuarioEncontrado = getUsuario(codigo);
        UsuarioEncontrado.setEmail(usuarioAtualizado.getEmail());
        UsuarioEncontrado.setNome(usuarioAtualizado.getNome());
        UsuarioEncontrado.setSenha(usuarioAtualizado.getSenha());
        entityManager.merge(UsuarioEncontrado);
        return UsuarioEncontrado;
    }
    
    @DELETE
    @Path("{codigo}")
    public Usuario excluir(@PathParam("codigo") Integer codigo) {
        Usuario usuario = getUsuario(codigo);
        entityManager.remove(usuario);
        return usuario;
    }
    
    @GET
    @Path("{codigo}")
    public Usuario getUsuario(@PathParam("codigo") Integer codigo) {
        return entityManager.find(Usuario.class, codigo);
    }
       
    
}
