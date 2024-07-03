package com.nttdata.glue;

import io.cucumber.java.ParameterType;
import com.nttdata.steps.OrderSteps;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class OrderStepdefs {

    @Steps
    OrderSteps orderSteps;

    @ParameterType("true|false")
    public boolean booleanValue(String value) {
        return Boolean.parseBoolean(value);
    }

    @When("creo una nueva orden con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete {booleanValue}")
    public void creoUnaNuevaOrden(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        orderSteps.crearOrden(id, petId, quantity, shipDate, status, complete);
    }

    @Then("el código de estado de la respuesta debe ser {int}")
    public void elCódigoDeEstadoDeLaRespuestaDebeSer(int statusCode) {
        orderSteps.validarCodigoDeEstado(statusCode);
    }

    @And("el cuerpo de la respuesta debe contener los detalles de la orden creada con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete {booleanValue}")
    public void elCuerpoDeLaRespuestaDebeContenerLosDetallesDeLaOrdenCreada(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        orderSteps.validarOrdenCreada(id, petId, quantity, shipDate, status, complete);
    }

    @When("consulto la orden con id {int}")
    public void consultoLaOrdenConId(int orderId) {
        orderSteps.consultarOrden(orderId);
    }

    @And("el cuerpo de la respuesta debe contener los detalles de la orden con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete {booleanValue}")
    public void elCuerpoDeLaRespuestaDebeContenerLosDetallesDeLaOrden(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        orderSteps.validarOrdenConsultada(id, petId, quantity, shipDate, status, complete);
    }
}