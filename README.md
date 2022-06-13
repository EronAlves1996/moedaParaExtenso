# Conversor número para extenso

Classe em Java criada para implementar minha versão do algoritmo que transforma um número em sua representação por extenso.

## Como usar

Após dar clone neste projeto, basta incluí-lo como uma dependência em seu projeto. A classe é estática, portanto não é necessário criar uma nova instância para utilizar.

A classe é utilizada através do método #convert que aceita um argumento do tipo int, e retorna a representação por extenso.

``````Java
System.out.println(int2stringConverter.convert(24));
// vinte e quatro
System.out.println(int2stringConverter.convert(1_099));
// mil e noventa e nove
````````
