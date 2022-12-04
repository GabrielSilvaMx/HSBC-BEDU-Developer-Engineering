
# Checkpoint Proyecto Final Sesión 01 - Desarrollo de software ágil

Rúbrica entrega de tareas:

<https://github.com/GabrielSilvaMx/HSBC-BEDU-Developer-Engineering/tree/main/Modulo%201>

## **Rúbrica Checkpoint - Proyecto Final**

Video de entrega del Checkpoint:

<https://youtu.be/NzNpYxqptZE>

**1) Proyecto prácticas ágiles**

El proyecto se encuentra en la carpeta de entregable en la Sesión 01:

<https://github.com/GabrielSilvaMx/HSBC-BEDU-Developer-Engineering/tree/main/Modulo%201/Sesi%C3%B3n%201>


**2) Objetivos**

-   Crear infraestructura con Terraform
-   Crear Pipelines en Jenkins
-   Instalar y configurar un SonarQube.
-   Conectar el SonarQube con Jenkins.
-   Escaneo vulnerabilidades OWASP Zap con Jenkins.

## Generación de plantilla de infraestructura a través de Terraform

Con el uso de Terraform construiremos una imágen, la almacenaremos en el servidor en la nube y montaremos un contenedor MySQL, Jenkins y SonarQube para luego probar su funcionamiento y revisar el log del contenedor.

El primer paso es inicializar el directorio de trabajo que contiene archivos de configuración de Terraform. Este es el primer comando que debe ejecutarse después de escribir una nueva configuración de Terraform o clonar una existente desde el control de versiones.

![Texto Descripción generada automáticamente](media/53621fcda97ea43772a9497755728da8.png)

El **terraform validate** valida los archivos de configuración en un directorio, refiriéndose solo a la configuración y sin acceder a ningún servicio remoto, como el estado remoto, las API del proveedor, etc.

![Captura de pantalla de computadora Descripción generada automáticamente](media/1fddb4c9acba8e8de0e29e1563a89797.png)

El **terraform plan** crea un plan de ejecución, que le permite obtener una vista previa de los cambios que Terraform planea realizar en su infraestructura.

Se generaron varios archivos tf los cuales van a crear

![Texto Descripción generada automáticamente](media/0152468b512851f2f7b067d19577315c.png)

El terraform apply ejecuta las acciones propuestas en un plan Terraform.

![Texto Descripción generada automáticamente](media/7336be4578042e4cd211996481c25562.png)

Cuando estemos seguros de aplicarlo, escribimos “**yes**” y la tecla *Enter* para ejecutarlo:

![Texto Descripción generada automáticamente](media/312a7e773f42102a1517e06d76e23214.png)

## Construcción de imagen de Docker

Los contenedores se crean y nos muestra las IP de Jenkins y MySQL.

![Texto Descripción generada automáticamente](media/83608896a493006e9f4db2d8a6ccb526.png)

Ejecutamos el comando **docker ps -a** para revisar que estén arriba los servicios ya en ejecución:

![Texto Descripción generada automáticamente](media/e7d78ccc697b2f52b50daa7d7c1beee7.png)

## Pipeline de despliegue automático

Posteriormente ingresamos al navegador web y revisamos que es posible loguearse al servidor de Jenkins y de SonarQube:

![Interfaz de usuario gráfica, Aplicación Descripción generada automáticamente](media/334b801a6c6d1a5d290d484fcf568e7e.png)

![Interfaz de usuario gráfica Descripción generada automáticamente](media/9c696b33d3c31ca070929f46079f02c9.png)

Al ingresar a Jenkins, se generó un Pipeline llamado “BowlingGame with SonarQube”.

![Interfaz de usuario gráfica, Aplicación Descripción generada automáticamente](media/bd1b105c808e33486c8c9828e73ae317.png)

Este Pipeline se configuró para que el Trigger se dispare de manera automática cada vez que haya un cambio en la rama Master del reposiorio de GitHub. Mas adelante veremos cómo al hacer un cambio en la rama Master el Pipeline automáticamente realiza la ejecución de manera automática.

![Interfaz de usuario gráfica, Texto, Aplicación Descripción generada automáticamente](media/3865b634c56078ba263a0ccb3f44a508.png)

Así también, se configuró un archivo JenkinsFile dentro de este repositorio para automatizar las pruebas del proyecto.

| Archivo JenkinsFile: | <https://github.com/GabrielSilvaMx/BowlingGame/blob/master/Jenkinsfile> |
|----------------------|-------------------------------------------------------------------------|

![Interfaz de usuario gráfica, Texto, Aplicación Descripción generada automáticamente](media/0b01ce4aae60a880341a66172d506a96.png)

El repositorio para llevar a cabo las pruebas se encuentra en la siguiente dirección:

<https://github.com/GabrielSilvaMx/BowlingGame>

![Captura de pantalla de computadora Descripción generada automáticamente](media/11cf2a3c984613d5174acbfb61523535.png)

El repositorio contiene un proyecto sencillo en Java donde se utilizó parte de una Kata llamada “Bowling Game”.

| Información de la Kata | <https://github.com/scturkey/bowling-game-kata>                                       |
|------------------------|---------------------------------------------------------------------------------------|
| Archivos de pruebas    | <https://github.com/GabrielSilvaMx/BowlingGame/tree/master/src/test/java/com/example> |

## Pruebas de código estático

Antes de ejecutar el PipeLine realizamos las pruebas del código para verificar que efectivamente el código está funcionando correctamente. Para ello, en IntellIj Idea efectuamos las pruebas del código:

![Captura de pantalla de computadora Descripción generada automáticamente](media/b4e1c8da8fa29d92a84611f061df5474.png)

Observamos que todas las pruebas están correctas y se sube a la rama Master del repositorio los cambios del proyecto.

Una vez configurado nuestro PipeLine lo ejecutamos con la opción “Construir ahora”

Observamos que el Pipeline empieza a realizar las tareas realizadas a través del escenario propuesto mediante el archivo de JenkinsFile.

![](media/b34e6cab66427c66f91285ba5487bb74.png)

Podemos ingresar a la tarea para observar la salida en tiempo de ejecución.

![Interfaz de usuario gráfica, Aplicación Descripción generada automáticamente](media/51a05cb5c76783337f5f3fa99d5970f6.png)

Observamos que está llevando a cabo los pasos indicados:

![Interfaz de usuario gráfica, Texto, Aplicación Descripción generada automáticamente](media/4b3a418fe733605d09d6f9c53bcc5e49.png)

Una vez finalizada la ejecución nos mostrará la leyenda: “**Finished: SUCCESS**”

![Interfaz de usuario gráfica, Texto, Aplicación, Correo electrónico Descripción generada automáticamente](media/45f90ea336003af048f568bc0ecaaff6.png)

Volvemos al PipeLine y revisamos que efectivamente terminó con éxito el escenario:

![](media/56818a546a8fd150e9159e7c330baa10.png)

## Ejecución del pipeline

El siguiente paso es verificar cuando las pruebas no se ejecutan correctamente.

En IntelliJ Idea modificamos el código para que las pruebas no pasen correctamente, por lo que vamos a simular que la máquina de bolos se descompuso y por lo tanto las pruebas no son válidas.

En la siguiente pantalla observamos que se hizo un cambio a la línea 8 del archivo BowlingGame.java cambiando el valor de la variable privada de 0 a 1. Al ejecutar las pruebas observamos que se envía el error:

![Captura de pantalla de computadora Descripción generada automáticamente](media/da73e284fa2ffa002dd8d0dbfe60e886.png)

Pero supongamos que el programador sube este código al repositorio

![](media/a9d0664d89ea49f34aab79516f5ce426.png)

Una vez que le aprueban sus cambios en el repositorio, el Pipeline automáticamente empezará a realizar la siguiente tarea de validación:

![Interfaz de usuario gráfica, Aplicación Descripción generada automáticamente](media/4bd96872bbe871b6c890dd0cfdc59a45.png)

Se observa que ya no pasó uno de los escenarios y si nos dirigimos a los logs de esta tarea se verifica que fue debido a que los tests no pasaron correctamente:

![Interfaz de usuario gráfica, Texto, Aplicación Descripción generada automáticamente](media/a23e6b3d34ceeb3c6b02aba53bdeb3c1.png)

## Despliegue

El programador verifica y hace ajustes al código por lo que arregla la línea de código, ejecuta las pruebas y vuelve a subir los cambios al repositorio en GitHub.

![](media/d34ff024923db4b096cccb5cd1b377bc.png)

![Captura de pantalla de computadora Descripción generada automáticamente](media/803a7da9735483a39e400f5873ca2334.png)

Se observa en el repositorio de GitHub que se actualizó la rama master:

![Captura de pantalla de computadora Descripción generada automáticamente](media/c3e3656412c80de0b298908fe684977c.png)

Observamos que nuevamente el Pipeline en Jenkins se vuelve a ejecutar ya que hubo un cambio en la rama Master:

![Una captura de pantalla de una computadora Descripción generada automáticamente](media/38a00388072067ceb995121eb1e37c95.png)

Y nuevamente, verificamos que todos los escenarios se ejecutaron correctamente

![Interfaz de usuario gráfica, Aplicación, Teams Descripción generada automáticamente](media/81529e032883c7133a2945f805061e4d.png)

## Pruebas de código dinámico

Siguiente, escaneamos las vulnerabilidades encontradas con OWASP Zap y generamos el reporte por parte de Jenkins:

![](media/8e6739d970901daf0aa48422e1e00f10.png)

## Aprobaciones para después del despliegue

Posteriormente, ingresamos al reporte generado por SonarQube. Nos mostrará los problemas encontrados (issues) desde el más grave hasta el más bajo con un detalle del problema y cómo resolverlo:

![](media/5c2d7da87ec48a64f1c20176800c6ba1.png)

![Interfaz de usuario gráfica, Texto, Aplicación, Word Descripción generada automáticamente](media/dfafa1c9a6b8a5c8ed63c0397f9c3f28.png)

Por último, en nuestra consola ejecutamos el comando terraform destroy, escribimos “**yes**” y la tecla *Enter* para confirmar:

![Texto Descripción generada automáticamente](media/6237440d311e8bf9d38a2d08a1840103.png)

Nuestros contenedores creados serán eliminados con éxito.
