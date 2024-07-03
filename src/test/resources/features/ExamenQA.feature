Feature: Automatización del Servicio de Store de PetStore

  @test1_e
  Scenario Outline: Creación de Order
    When creo una nueva orden con id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete <complete>
    Then el código de estado de la respuesta debe ser 200
    And el cuerpo de la respuesta debe contener los detalles de la orden creada con id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete <complete>

    Examples:
      | id | petId | quantity | shipDate                    | status  | complete |
      | 2  | 3     | 4        | 2024-07-02T10:00:00.000Z    | placed  | true     |
      | 3  | 4     | 5        | 2024-07-03T11:00:00.000Z    | approved| false    |

  @test2_e
  Scenario Outline: Consulta de Order
    When consulto la orden con id <id>
    Then el código de estado de la respuesta debe ser 200
    And el cuerpo de la respuesta debe contener los detalles de la orden con id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete <complete>

    Examples:
      | id | petId | quantity | shipDate                    | status  | complete |
      | 2  | 3     | 4        | 2024-07-02T10:00:00.000Z    | placed  | true     |
      | 3  | 4     | 5        | 2024-07-03T11:00:00.000Z    | approved| false    |
