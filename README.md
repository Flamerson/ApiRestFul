# ApiRestFul 

Essa é uma api criada com SpringBoot, utilizando o modelo de maturidade de Richardson, seguindo todos requisitos.

****

## Ferramentas utilizadas
- Java, SpringBoot, SpringWeb, Spring Hateoas, Spring Data, PostreSQL. 
- Intellij, Insomnia.

## Padrão de richardson
A maturidade de richardson é aplicado para dizer que uma api é restful, sendo assim é preciso seguir algumas regras
para que esse método seja aplicado corretamente.

Um pouco mais sobre A Maturidade de Richardson no link: https://rivaildojunior.medium.com/modelo-de-maturidade-de-richardson-para-apis-rest-8845f93b288

## Sobre o projeto

Esse projeto é uma Api Restful, a api está salvando uma todoList, no banco levando em conta toda a maturidade de Richardson, o intuito é realizar um crud no banco onde iremos salvar e recuperar esses dados da maneira correta.
****

# Minhas configurações iniciais

Para iniciar o projeto utilizei o Spring Initializer, com as configurações que estão na imagem abaixo.

<br/>
<img src="./ExternalPhotos/projeto.png" >

- Utilizei as dependências SpringWeb, SpringDataJpa, Validation, PostgreSQL_Driver, Spring HATEOAS.


Após iniciar o projeto na ide realizei a criação dos pacotes, como na imagem abaixo.

<br/>
<img src="./ExternalPhotos/PastasDoProjeto.png">

- Utilizei um padrão de pacotes bem próximo com o padrão Mvc.

Depois de criar todas as classes e colocar nos seus pacotes, denominei todas as rotas como "todos", ficando "localhost:8080/todos", como podem ver utilizei 3 dos padrões de richardson nesse modelo, faltando somente adicionar o último para tornar a api restful.

<br/>
<img src="./ExternalPhotos/RotaGet.png" >

## Adicionando o Hateoas

Para que minha aplicação se torne Restful, estava faltando somente as Hipermídias, sendo assim utilizei a biblioteca Spring HATEOAS, para adicionar todas as Hipermídias, no final a resposta da aplicação ficou como na imagem abaixo.

<br/>
<img src="./ExternalPhotos/respostaGet.png" >

## Como utilizar o projeto

**Configuração**

É preciso alterar o documento application.properties que está dentro do diretório, src/main/resources.

<br/>
<img src="./ExternalPhotos/aplicationProperties.png">
<br/>

Nele temos 5 linhas precisando alterar somente as linhas de acordo com seu banco.

Após isso é preciso entrar no diretório pom.xml e utilizar a sua ide para baixar as External Libraries do projeto, onde teremos todas as dependências dentro dela.

**Rotas da aplicação**

A aplicação está na rota "http://localhost:8080/todos", onde graças ao Modelo de Richardson só precisamos alterar o verbo Http da aplicação para assim conseguirmos seguir todo o fluxo da api.

**Post** :

A rota post recebe um objeto no formato Json, onde esse objeto precisa ter os seguintes parâmetros, name e descrição, ambos no formato string.

<br/>
<img src="./ExternalPhotos/postRotaObj.png">

- A resposta esperada é o elemento cadastrado no banco com seu ID, e uma rota que leva para a listagem geral.

<img src="./ExternalPhotos/postRes.png">

**Get** :

Na rota do get, temos duas rotas, uma que trás um único resultado e outra que lista todos os resultados, na rota que traz todos os resultados não precisamos passar nenhum parâmetro extra somente a rota e o Verbo Http correto.<br/>
Já na segunda rota, onde temos somente um elemento do banco selecionado, temos que passar o parâmetro id na url da nossa api, assim retornando apenas um elemento da nossa lista.

<br/>
<img src="./ExternalPhotos/getTodos.png">
<br/>

- A resposta esperada aqui é uma lista com todos os objetos do banco.

<img src="./ExternalPhotos/listAllRes.png" >

<br/>

<img src="./ExternalPhotos/getId.png">
<br/>

- A resposta esperada aqui é um objeto com todos os dados dele e uma rota para a listagem geral.

<img src="./ExternalPhotos/listOneItem.png" >

**Put**

Na rota put, devemos passar dois parâmetros antes de atualizar, precisamos passar o ID do elemento na url, e o que precisa ser atualizado no corpo da requisição.

<br/>
<img src="./ExternalPhotos/put.png" >

- A resposta esperada aqui é um objeto com todos os dados do mesmo e uma rota para a listagem geral.

<img src="./ExternalPhotos/putRes.png" >

**Delete**

Na rota delete, devemos passar apenas um argumento que é o Id na url da requisição e ele já irá deletar o elemento do banco.

<br/>
<img src="./ExternalPhotos/delete.png"/>

- A resposta esperada aqui é uma mensagem falando que o objeto foi deletado com sucesso.

<img src="./ExternalPhotos/deleteRes.png" >

## Resumo Final

Eu aprendi bastante sobre Hateoas e como funciona para uma api ser restful, claro utilizando a Maturidade de Richardson, claro o projeto é bem simples, mas trago todos os pontos estudados e reforçá los ao longo do tempo mesmo com projetos simples é ótimo para não esquecer. 