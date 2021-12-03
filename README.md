<h1>Time de  Vantagens</h1>

-----

Requisições:

##Cadastro Usuário

### POST /usuario
````json
{
  "email" :"jey@zup.com",
  "nomeUsuario" : "Jeyciane Faria",
  "timeCoracao" : "ATLETICO_MG"
}

````

#### Response
- Status 201
````json
{
  "email": "jey@zup.com",
  "nomeUsuario": "Jeyciane Faria",
  "timeCoracao": "CORINTHIANS",
  "pontos": 0
}
````


##Cadastro Jogo

### POST /usuario
````json
{   "adm": {
  "login": "viniXablau",
  "senha": "documentation"
},
  "time1":"CORINTHIANS",
  "time2":"PALMEIRAS",
  "endereco":{
    "logradouro":"Rua Z",
    "numero": "123",
    "complemento":"ap 123",
    "bairro":"Centro",
    "cidade":"São Paulo",
    "cep":"12345898"
  },
  "dataDoJogo":"2021-12-27 16:00:00",
  "vantagens":[
    {
      "beneficio":"Bebida",
      "pontos":5
    },
    {
      "beneficio":"Uniforme",
      "pontos":200
    },
    {
      "beneficio":"Ingresso",
      "pontos":100
    },
    {
      "beneficio":"Comida",
      "pontos":20
    }

  ]
}
````

#### Response
- Status 201
````json
{
  "id": 3,
  "time1": "CORINTHIANS",
  "time2": "PALMEIRAS",
  "endereco": {
    "logradouro": "Rua Z",
    "numero": "123",
    "complemento": "ap 123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "cep": "12345898"
  },
  "dataDoJogo": "2021-12-27 16:00:00",
  "codigoValidacao": "0cc8d177-d0cb-4934-8903-0c633fa42bca",
  "vantagens": [
    {
      "beneficio": "Ingresso",
      "pontos": 100
    },
    {
      "beneficio": "Comida",
      "pontos": 20
    },
    {
      "beneficio": "Uniforme",
      "pontos": 200
    },
    {
      "beneficio": "Bebida",
      "pontos": 5
    }
  ]
}
````


##Exibir dados Usuário

### POST /usuario/idUsuario

#### Response
- Status 200
````json
{
  "email": "jey@zup.com",
  "nomeUsuario": "Jeyciane Faria",
  "timeCoracao": "CORINTHIANS",
  "pontos": 0,
  "vouchers": []
}
````


##Exibir Jogos Cadastrados

### GET /jogo

#### Response
- Status 200
````json
[
  {
    "id": 1,
    "time1": "FLAMENGO",
    "time2": "ATLETICO_MG",
    "endereco": {
      "logradouro": "Rua Z",
      "numero": "123",
      "complemento": "ap 123",
      "bairro": "Centro",
      "cidade": "São Paulo",
      "cep": "12345898"
    },
    "dataDoJogo": "2021-12-27 16:00:00",
    "codigoValidacao": "d3b21cb6-5729-484a-a2cb-4fc7ffeed33a",
    "vantagens": [
      {
        "beneficio": "Comida",
        "pontos": 20
      },
      {
        "beneficio": "Ingresso",
        "pontos": 100
      },
      {
        "beneficio": "Bebida",
        "pontos": 5
      },
      {
        "beneficio": "Uniforme",
        "pontos": 200
      }
    ]
  },
  {
    "id": 2,
    "time1": "FLAMENGO",
    "time2": "CORINTHIANS"
  } 
]
````


##Exibir Jogo Especifico

### GET /jogo/idJogo

#### Response
- Status 200
````json
{
  "id": 1,
  "time1": "FLAMENGO",
  "time2": "ATLETICO_MG",
  "endereco": {
    "logradouro": "Rua Z",
    "numero": "123",
    "complemento": "ap 123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "cep": "12345898"
  },
  "dataDoJogo": "2021-12-27 16:00:00",
  "codigoValidacao": "d3b21cb6-5729-484a-a2cb-4fc7ffeed33a",
  "vantagens": [
    {
      "beneficio": "Uniforme",
      "pontos": 200
    },
    {
      "beneficio": "Bebida",
      "pontos": 5
    },
    {
      "beneficio": "Comida",
      "pontos": 20
    },
    {
      "beneficio": "Ingresso",
      "pontos": 100
    }
  ]
}
````


##Realizar Check in

### PUT /usuario
````json
{
  "email":"jey@zup.com",
  "id":3,
  "codigoValidacao": "0cc8d177-d0cb-4934-8903-0c633fa42bca"
}
````

#### Response
- Status 200
````json
{
  "email": "jey@zup.com",
  "nomeUsuario": "Jeyciane Faria",
  "timeCoracao": "CORINTHIANS",
  "pontos": 30
}
````


##Realizar Troca por Vantagens

### PUT /usuario/IdJogo
````json
{
  "email": "jey@zup.com",
  "codigoValidacao": "d3b21cb6-5729-484a-a2cb-4fc7ffeed33a",
  "vantagem":
  {
    "beneficio":"Uniforme"
  }

}
````

#### Response
- Status 200
````json
{
  "email": "jey@zup.com",
  "pontos": 20,
  "vouchers": [
    {
      "codigo": "8055cc5a-4e2a-4f08-a46b-31df761db4f1",
      "beneficio": "Bebida",
      "dataValidade": "2021-12-28 16:00:00"
    },
    {
      "codigo": "f408078d-e5e7-4fcf-aa9c-f0f37813b716",
      "beneficio": "Bebida",
      "dataValidade": "2021-12-28 16:00:00"
    }
  ]
}
````
