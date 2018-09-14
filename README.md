# Front e Api para cadastro de endereços.

Para este  projeto é necessário utilizar o banco de dados MySql para inclusão, alteração, consulta e exclusão  dos dados.

<h1>Versões utilizadas</h1>

-Java v1.8<br>
-Framework SpringBoot v1.5.16<br>
-Maven para gerenciar as dependencias do projeto<br>
-Utilização JPA para gerenciamento do repositório<br>
-Banco de dados MySql v14.14 Distrib 5.7.23<br>
-Html/Css e Javascript<br>
-IDE Eclipse Mars.2 Release (4.5.2)<br>

<h1> EndPoints Disponiveis </h1>

<h2>GET</h2>
http://localhost:8080/address/{id}

<h2>POST</h2>
http://localhost:8080/address/
<p>Body</p>
```
{
  "rua": "rua",
  "numero": 0,
  "cep": "cep",
  "cidade": "cidade",
  "estado": "estado",
  "bairro": "bairro",
  "complemento": "complemento"
}
```
<h2>PUT</h2>
http://localhost:8080/address
<p>Body</p>
```
{
  "id": "id"
  "rua": "rua",
  "numero": 0,
  "cep": "cep",
  "cidade": "cidade",
  "estado": "estado",
  "bairro": "bairro",
  "complemento": "complemento"
}
```

<h2>DELETE</h2>
http://localhost:8080/address/{id}

<h1>Disponivel porém não utilizado no FrontEnd:</h1>
<h2>GET</h2>
<p>Retorna uma lista com todos os endereços.</p>
http://localhost:8080/address/

<h2>DELETE</h2>
<p>Apaga o registro passando o json inteiro</p>
http://localhost:8080/address/
<p>Body</p>
```
{
  "id": "id"
  "rua": "rua",
  "numero": 0,
  "cep": "cep",
  "cidade": "cidade",
  "estado": "estado",
  "bairro": "bairro",
  "complemento": "complemento"
}
```




