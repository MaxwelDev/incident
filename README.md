# incident

Este projeto foi desenvolvido para resolver um desafio, onde cada desenvolvedor fica responsável por uma tarefa durante o dia. Assim para que cada desenvolvedor consiga saber em qual dia ele será responsável pela tarefa e quem foi o responsável no dia anterior, para caso ele precise tirar alguma dúvida, foi desenvolvida um serviço rest que pode ser acessado na url https://responsibleincident.herokuapp.com/im-day, o código fonte desse serviço está neste repositório e veremos como executar esse código localmente a seguir. Na url http://incident.surge.sh/ você pode verificar a aplicação front-end desenvolvida para consumir o serviço, o código fonte dessa aplicação está disponível no repositório https://github.com/MaxwelDev/front-incident.


Para rodar esse projeto localmente você precisa seguir as seguintes instruções e atender aos requisitos descritos abaixo:


- O projeto foi desenvolvido em java, utlizando o Spring Boot como framework web, para que você possa executar o projeto você precisa previamente do java 1.8 ou superior intalado, você pode encontrar instruções para a instalação na seguinte url https://docs.oracle.com/javase/8/docs/technotes/guides/install/linux_jdk.html#A1098871.

![Alt Text](https://www.hostingireland.ie/images/java-logo.png)</br></br></br>


- Como gerenciador de dependências o projeto utiliza o maven, é necessária a instalação do mesmo para que as dependências necessárias para a perfeita execução do projeto possam ser baixadas como sucesso, você pode encontrar instruções para instalação do maven na seguinte url https://maven.apache.org/install.html.

![Alt Text](http://www.viamais.net/blog/wp-content/uploads/2016/08/como-instalar-o-maven-no-macos.png)</br></br></br>


- Projeto foi desenvolvido utilizando a IDE IntelliJ que pode ser encontrada na seguinte url https://www.jetbrains.com/idea/, o projeto pode ser executado em qualquer outra IDE como Eclipse, NetBeans, ou qualquer outra desde que a mesma tenha suporte a Java. Seja qual for a sua escolha é necessária a instalação de um plugin que seja compativel com o lombok (https://projectlombok.org/) para que você consiga editar os códigos. Caso você queira apenas executar o projeto, você pode iniciar a aplicação que ela funcionara normalmente. 

![Alt Text](https://confluence.jetbrains.com/download/attachments/10818/IDEADEV?version=6&modificationDate=1449747979000&api=v2)</br></br></br>


- Caso você queira mais praticidade você pode rodar o projeto através do Docker, você apenas precisará ter o mesmo instalado para que consiga executar a aplicação, nesta url https://docs.docker.com/engine/installation/ você encontra instruções para a instalação do docker. Após ter instalado o docker, certifiquesse que o possui o maven instalado em sua maquina e ai você precisa apenas entrar na pasta do projeto após ter clonado o mesmo e executar o comando "mvn package" para empacotador o projeto, depois executar o comando "sudo docker:build" para que a imagem seja gerada, em seguida utilize o comando "docker run -p 8080:8080 -t incident --name incident", neste momento o docker subirá a aplicação que ficará disponível na porta 8080 da sua maquina. O projeto se conectará ao banco de dados que está hospedado no heroku, portanto uma pequena demora na subida do projeto é normal.

![Alt Text](https://www.docker.com/sites/default/files/social/docker_twitter_share.png)</br></br></br>

- Caso você não consiga executar o projeto ou tenha alguma dúvida entre em contato comigo por email maxwel.silva2@fatec.sp.gov.br
