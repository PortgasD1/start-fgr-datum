package sv.gob.fgr;

//import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
/*import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;*/

import io.restassured.http.ContentType;
/*import sv.gob.fgr.models.DerechosAsiento;
import sv.gob.fgr.restClient.CnrServices;*/

@QuarkusTest
class CnrFacadeTest {

    //@InjectMock
    //CnrServices cnrServ;

    @Test
    public void testDerechoAsientoEndpoint() {
        // Crear datos simulados
        /*DerechosAsiento asiento = new DerechosAsiento();
        asiento.setCodigoComunes("55380729");
        asiento.setNombreTitular("CAJA DE CREDITO DE SAN PEDRO NONUALCO, SOCIEDAD COOPERATIVA DE RESPONSABILIDAD LIMITADA DE CAPITAL VARIABLE");
        asiento.setCorrelativoNombre(1);
        asiento.setDerecho("HIPOTECA");
        asiento.setAsiento(4);
        asiento.setPorcentajeDerecho(100);

        // Simular comportamiento del cliente REST
        when(cnrServ.rprhDerechoAsiento("201406040273")).thenReturn(List.of(asiento));
        */
        // Probar el endpoint
        given()
            .when().get("/services/derechoAsiento/201406040273")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("$.size()", greaterThan(0))
            .body("[0].codigoComunes", notNullValue())
            .body("[0].nombreTitular", notNullValue())
            .body("[0].correlativoNombre", notNullValue())
            .body("[0].derecho", notNullValue());
            // Puedes agregar más validaciones si es necesario (como la fecha)
    }

    @Test
    public void testAsientoEndpoint() {
        // Crear datos simulados
        /*DerechosAsiento asiento = new DerechosAsiento();
        asiento.setCodigoComunes("55380729");
        asiento.setNombreTitular("CAJA DE CREDITO DE SAN PEDRO NONUALCO, SOCIEDAD COOPERATIVA DE RESPONSABILIDAD LIMITADA DE CAPITAL VARIABLE");
        asiento.setCorrelativoNombre(1);
        asiento.setDerecho("HIPOTECA");
        asiento.setAsiento(4);
        asiento.setPorcentajeDerecho(100);

        // Simular comportamiento del cliente REST
        when(cnrServ.rprhDerechoAsiento("201406040273")).thenReturn(List.of(asiento));
        */
        // Probar el endpoint
        given()
            .when().get("/services/asientos/15172825-00000")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("$.size()", greaterThan(0))
            .body("[0].correlativoAsiento", notNullValue())
            .body("[0].numeroAsiento", notNullValue())
            .body("[0].clasificacion", notNullValue())
            .body("[0].servicio", notNullValue());
            // Puedes agregar más validaciones si es necesario (como la fecha)
    }

}
