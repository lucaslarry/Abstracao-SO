# Sobre o projeto

Esse é um projeto que tem como objetivo simular a forma que a memória é gerenciada por um sistema operacional.

Construida durando o Módulo 6 da universidade Facisa na competencia DESENVOLVER SIMULADOR DE ABSTRAÇÕES DE RECURSOS DE S.O 

### Algoritmos:
    First-Fit: inicia a procura a partir da primeira página de memória (parte baixa) e vai varrendo a memória até encontrar a primeira lacuna suficientemente grande para armazenar o processo.

    Best-Fit: varre toda a memória e escolhe a página mais ajustada ao tamanho do processo.
    
    Worst-Fit: varre toda a memória e escolhe a página menos ajustada ao tamanho do processo.

# Como executar o projeto
Pré-requisitos: Java 17
```bash
# clonar repositório
$ git clone https://github.com/lucaslarry/SoMemoryManagement
```
Dentro da pasta src:
```bash
# compilar o projeto
$ javac so/Execute.java
# executar o projeto
$ java so/Execute.java
```

# Tecnologias utilizadas
- Java

