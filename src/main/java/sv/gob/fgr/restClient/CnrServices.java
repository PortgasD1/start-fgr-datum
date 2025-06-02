package sv.gob.fgr.restClient;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import sv.gob.fgr.models.AsientosModels;
import sv.gob.fgr.models.DerechosAsiento;

@Path("/services")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "cnr-fgr-service")
public interface CnrServices {

    @GET
    @Path("/consultas/rprh/derechosAsiento")
    List<DerechosAsiento>  rprhDerechoAsiento(@QueryParam("presen") String presen);

    @GET
    @Path("/consultas/rprh/asientos")
    List<AsientosModels>  rprhAsiento(@QueryParam("matricula") String matricula);


}
