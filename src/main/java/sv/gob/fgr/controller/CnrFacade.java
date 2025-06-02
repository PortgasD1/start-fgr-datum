package sv.gob.fgr.controller;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sv.gob.fgr.models.AsientosModels;
import sv.gob.fgr.models.DerechosAsiento;
import sv.gob.fgr.restClient.CnrServices;

@Path("/services")
public class CnrFacade {

    @Inject
    @RestClient
    CnrServices cnrServ;

    @GET
    @Path("/derechoAsiento/{presente}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DerechosAsiento> derechoAsiento(@PathParam("presente") String presente) {
        return cnrServ.rprhDerechoAsiento(presente);
    }

    @GET
    @Path("/asientos/{matricula}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AsientosModels> asientos(@PathParam("matricula") String matricula) {
        return cnrServ.rprhAsiento(matricula);
    }
}
