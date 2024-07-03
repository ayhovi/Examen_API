package com.nttdata.steps;
import static org.hamcrest.Matchers.matchesPattern;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class OrderSteps {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear una nueva orden con id: {0}, petId: {1}, quantity: {2}, shipDate: {3}, status: {4}, complete: {5}")
    public void crearOrden(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        String body = String.format("{\"id\":%d,\"petId\":%d,\"quantity\":%d,\"shipDate\":\"%s\",\"status\":\"%s\",\"complete\":%b}",
                id, petId, quantity, shipDate, status, complete);

        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .log().all()
                .post(BASE_URL)
                .then()
                .log().all();
    }

    @Step("Validar el código de estado de la respuesta es {0}")
    public void validarCodigoDeEstado(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Step("Validar que el cuerpo de la respuesta contenga los detalles de la orden creada")
    public void validarOrdenCreada(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        restAssuredThat(response -> response.body("id", equalTo(id)));
        restAssuredThat(response -> response.body("petId", equalTo(petId)));
        restAssuredThat(response -> response.body("quantity", equalTo(quantity)));
        restAssuredThat(response -> response.body("shipDate", matchesPattern(shipDate.replace("Z", "(?:Z|\\+0000)"))));
        restAssuredThat(response -> response.body("status", equalTo(status)));
        restAssuredThat(response -> response.body("complete", equalTo(complete)));
    }

    @Step("Consultar una orden con id: {0}")
    public void consultarOrden(int orderId) {
        SerenityRest.given()
                .relaxedHTTPSValidation()
                .log().all()
                .get(BASE_URL + "/" + orderId)
                .then()
                .log().all();
    }

    @Step("Validar que el cuerpo de la respuesta contenga los detalles de la orden consultada")
    public void validarOrdenConsultada(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        restAssuredThat(response -> response.body("id", equalTo(id)));
        restAssuredThat(response -> response.body("petId", equalTo(petId)));
        restAssuredThat(response -> response.body("quantity", equalTo(quantity)));
        restAssuredThat(response -> response.body("shipDate", matchesPattern(shipDate.replace("Z", "(?:Z|\\+0000)"))));
        restAssuredThat(response -> response.body("status", equalTo(status)));
        restAssuredThat(response -> response.body("complete", equalTo(complete)));
    }
}