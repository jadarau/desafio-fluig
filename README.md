# Informações importantes:

1 - A API será inicializada na porta 8090 para evitar conflitos ou a necessidade de interromper uma gama de aplicações que utilizam essa porta para funcionar;

2 - Ao inicializar a API, serão criados, automaticamente, 4 veículos que tornarão os testes mais ágeis;

3 - O banco de dados utilizado é o H2, que é executado em memória em tempo de execução, não havendo necessidade de instalação ou configuração.


# Instruções de uso:

1 - Para consultar os veículos existentes, basta utilizar o endpoint: GET - localhost:8090/ficticius/veiculos (veículo no plural);

2 - Para inserir novos veículos, basta utilizar o endpoint: POST - "localhost:8090/ficticius/veiculo" (véiculo no singular). Também é necessário informar o JSON do corpo da requisição, conforme abaixo;

{
    "nome": "HB20",
    "marca": "Hiunday",
    "modelo": "2018",
    "fabricacao": "2018-01-28",
    "consumoCidade": 11,
    "consumoRodovias": 14
}

3 - Para consultar a previsão de gastos com combustível dos veículos cadastrados, basta utilizar o endpoint: POST - "localhost:8090/ficticius/previsao". Também é necessário informar o JSON do corpo da requisição, conforme abaixo;

{
    "Preço da Gasolina": 6.90,
    "Km total que será percorrido na cidade": 12,
    "Km total que será percorrido nas rodovias": 30
}
