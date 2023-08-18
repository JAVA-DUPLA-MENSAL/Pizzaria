# Pizzaria API

Bem-vindo à documentação da API da Pizzaria Delícia! Esta API permite gerenciar informações sobre clientes, endereços e pedidos de pizza. Com esta API, você pode cadastrar novos clientes, seus endereços e seus pedidos personalizados, incluindo tamanho da pizza, sabores e opção de entrega.

# Recursos Disponíveis
## 1. Cadastrar um Cliente
Registra um novo cliente na base de dados da pizzaria.

* URL: /usuario
* Método: POST
* Resposta de Sucesso:
* Código: 201 Created
* Corpo: O ID do cliente recém-criado.
## 2. Cadastrar um Pedido
Cria um novo pedido de pizza para um cliente.

* URL: /pedido
* Método: POST
* Resposta de Sucesso:
* Código: 201 Created
* Corpo: O ID do pedido recém-criado.
## 3. Consultar Informações do Cliente
Recupera informações detalhadas de um cliente.

* URL: /usuario/buscar/{id}
* Método: GET
* Parâmetros de URL: Substituir {id} pelo ID do cliente desejado.
* Resposta de Sucesso:
* Código: 200 OK
* Corpo: Detalhes do cliente.
## 4. Consultar Informações do Pedido
Recupera detalhes de um pedido de pizza.

* URL: /pedido/buscar/{id}
* Método: GET
* Parâmetros de URL: Substituir {id} pelo ID do pedido desejado.
* Resposta de Sucesso:
* Código: 200 OK
* Corpo: Detalhes do pedido.
