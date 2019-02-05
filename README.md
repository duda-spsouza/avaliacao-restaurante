# Avaliação Restaurante

## Introdução 
Projeto para avaliação de restaurantes como o uso das seguintes tecnologias
 - Angularjs
 - Spring book 2
 - Spring book thymeleaf
 - Java 1.8
 - Junit jupiter
 - Bootstrap
 - HTML5 

## Utilização
Para utilizar a aplicação no ambiente local, basta clonar este repositório: 
- git clone https://github.com/duda-spsouza/avaliacao-restaurante.git
- Abrir como projeto no Eclipse Jee 2018-09
- No navegador "http://localhost:8080/"

## Funcionamento
Será apresentado um formulário com os seguintes campos vazios Nome, Endereço,Voto e Dia da Semana
logo abaixo haverá um lista de restaurantes "fakes" para o usuário "votar".

**Funcionalidades

- O Campo "Dia da Semana" listará somente dias disponíveis para avaliação;
- O Campo "Voto" listará números de 1 até 5, indicando 1 como uma avaliação mais baixa e 5 como avaliação mais alta;
- Ao clicar no botão votar caso o dia da semana já esteja preenchido uma mensagem será apresentada ao usuário "Restaurante já foi frequentado essa semana" 
- Ao clicar no botão votar os dados "fakes" serão preenchidos no formulário e ficará disponível para alteração os campos "Voto" e "Dia da Semana";
- Após clicar em salvar o registro da lista é alterado
- A coluna "Humor" com icones de emotions indica através da avaliação do usuário o quanto ficou satisfeito/insatisfeito com o restaurante; 

## Aplicação
Link do projeto https://avaliacao-restaurante.herokuapp.com/
## Melhorias
- Deveria ter dado mais atenção para os testes;
- Utilizar Geolocalização para localizar os restaurantes mais próximos

