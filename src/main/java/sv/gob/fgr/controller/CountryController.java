package sv.gob.fgr.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sv.gob.fgr.dto.FullCountryInfoRequest;
import sv.gob.fgr.dto.FullCountryInfoResponse;
import sv.gob.fgr.service.CountryService;

@Path("/")
@Tag(name = "Country API", description = "Operaciones relacionadas con países")
public class CountryController {

    @Inject
    CountryService countryService;

    @Path("/fullcountryinfo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Obtener información completa del país",
        description = "Devuelve información detallada del país según los datos enviados en el request"
    )
    @RequestBody(
        description = "Código ISO del país deseado",
        required = true
    )
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Respuesta exitosa"),
        @APIResponse(responseCode = "400", description = "Solicitud inválida"),
        @APIResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public FullCountryInfoResponse fullCountryInfo(FullCountryInfoRequest fullCountryInfoRequest) {
        return countryService.processRequest(fullCountryInfoRequest);
    }

}