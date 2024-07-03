package com.nttdata.glue;

import io.cucumber.java.en.When;

public class PruebaStepdefs {
    @When("hare un post con los siguiente datos usuario: {string},nombres: {string}, apellidos: {string}")
    public void hareUnPostConLosSiguienteDatosUsuarioNombresApellidos(String arg0, String arg1, String arg2) {
        System.out.println("ejecuta codigo java");
        System.out.println("usuaio"+arg0);
        System.out.println("usuaio"+arg1);
        System.out.println("usuaio"+arg2);
    }
}
