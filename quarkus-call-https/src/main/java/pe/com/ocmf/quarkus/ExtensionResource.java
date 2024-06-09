package pe.com.ocmf.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

@Path("/api")
public class ExtensionResource {

    @RestClient
    ExtensionService myRemoteService;

    @GET
    @Path("/extensions")
    public Set<ExtensionService.Extension> getExtensionsById(@QueryParam("id") String id) {
        return myRemoteService.getExtensionsById(id);
    }
}
