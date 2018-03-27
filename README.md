
Universidad Rafael Landívar
Arquitectura del Computador
Proyecto No. 6 del curso

# Hack Assembler
El proyecto consiste en un Assembler que traduce código en Assembly a Lenguaje Máquina que puede ser interpretado por la Hack CPU construida en un proyecto anterior.
## Manual de Usuario

A continuación se describe la forma de uso del software "Hack Assembler". El uso del mismo se divide en varias etapas:

 - Iniciando la aplicación
 - Cargando archivo .asm
 - Guardando archivo .hack

### Iniciando la Aplicación

La aplicación puede ser ejecutada por medio de la línea de comandos o dando doble click sobre el ícono de la aplicación.
#### Línea de comandos
Ubicarse en la carpeta del proyecto y ejecutar el siguiente comando:
```
java -jar HackAssembler\dist\HackAssembler.jar
```
#### Clic sobre ícono de aplicación.
Ubicar la carpeta que contiene el archivo JAR por medio del explorador de archivos. La ruta del archivo relativa a la carpeta del proyecto es la siguiente:
```
\HackAssembler\dist\HackAssembler.jar
```
Hacer doble clic sobre el ícono  
![Ícono del proyecto.](https://lh3.googleusercontent.com/4rMAm8nv2OyLfZ69qBaDPqxERc9AIIOxxZTZSGoZJWRAPRiHTthza6Nx0HOX7e7JhZrifl-vprRr)

Después de abierta la aplicación, debería mostrarse en pantalla algo similar a esto:  
![Ventana inicial del proyecto](https://lh3.googleusercontent.com/X5cSg7ncYTJxia7KYC5El5DtxCL_WY_mOvxqt4wafoZNGv3QBYYnK4uxTFbx_DRLGH6TC1suc6xZ)

### Cargando el archivo *".asm"*
Un archivo .asm puede ser cargado desde el menú *File* o dando clic sobre el ícono de la carpeta. Independientemente de la forma que se escoja, se abrirá un cuadro solicitándole abrir el archivo deseado.
![Cuadro de diálogo](https://lh3.googleusercontent.com/RwcfCYEHL8XrkTBtpbGARCcf7cS-owDgGokL-YlWxfWFcrF0kz3FzDHyHFSIA_CusJNG-_uIMGHD)

Todo lo que debe hacer es seleccionar el archivo y hacer clic sobre el botón abrir.
Inmediatamente después de haber abierto el archivo, se llenarán dos columnas que se verán similar a esto:
![enter image description here](https://lh3.googleusercontent.com/rp_eokHVtj9BwsMY1Fiiq24g81rpVTgZ6YcTDtBpbS3nrD9nIrQ9-hh4FpyinUwzss4paORme_SZ)

Del lado izquierdo se muestra el archivo tal cual se cargó y del lado izquierdo se muestra una vista previa del lenguaje máquina generado por el programa. En la parte inferior se muestra un mensaje indicando si el archivo contenía errores y el tiempo que tardó el programa en traducir a lenguaje máquina.

### Generando el archivo ".hack"
Para generar el archivo .hack, basta con hacer clic sobre el ícono del disquete. Al hacer clic sobre el ícono se abrirá un cuadro de diálogo similar a este:
![enter image description here](https://lh3.googleusercontent.com/ua7YFCasodmhPszybFAS0F5m-XPNIxtaZXpMSf5BvIypI3SOXW4-iKxffi7Jz8epsEqtDwQB8RCF)

En este cuadro de diálogo debe especificarse el nombre que se le desea dar al archivo de salida, mismo que tendrá la extensión .hack.

## IDE Utilizado
El entorno de desarrollo utilizado para construir la aplicación fue NetBeans IDE 8.2.


## Autor

* **Mynor Ottoniel Xico Tzian**
