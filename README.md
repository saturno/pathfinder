# Explorando Marte - Pathfinder

Para adequar melhor as entradas e saídas da exploração das sondas nos planaltos e Marte, preferi usar o Json.

Foi implementado um endpoint que realiza toda a tarefa. O ideal seriam vários endpoints, persistindo os planaltos, as sondas e suas posições, e possibilitando consultas mais ao estilo Rest, usando micro-serviços.

## Usando o Serviço

Depois de feito o deploy num container, o serviço pode ser acessado pela URL:

http://localhost:8080/pathfinder-0.0.1-SNAPSHOT/navegacao

Supondo que o container esteja ouvindo a porta 8080.

Implementei o método POST, por achar mais adequado.

### Chamada do serviço

POST /pathfinder-0.0.1-SNAPSHOT/navegacao HTTP/1.1

Host: localhost:8080

Content-Type: application/json

Cache-Control: no-cache

Postman-Token: a66a8aec-6730-9cd8-9133-8110fcd231bd

```json
{
    "planalto": {
        "x" : "5",
        "y" : "5"
    },
    "sondas": [
      {"x": "1", "y" : "2", "direcao" : "N", "rota" : "LMLMLMLMM"},
      {"x": "3", "y" : "3", "direcao" : "E", "rota" : "MMRMMRMRRM"}
    ]
}
```

### Retorno esperado

```json
[
  {
    "x": "1",
    "y": "3",
    "direcao": "N"
  },
  {
    "x": "5",
    "y": "1",
    "direcao": "E"
  }
]
```