Feature: Prueba

  @PruebaDos
  Scenario Outline: Prueba de StepDef
    When hare un post con los siguiente datos usuario: "<usuario>",nombres: "<nombres>", apellidos: "<apellidos>"

    Examples:
      | usuario | nombres | apellidos|
      | ecurinahui | emerson | curinahui |