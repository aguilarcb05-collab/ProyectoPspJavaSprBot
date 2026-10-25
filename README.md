# ProyectoPspJavaSprBot
Chicos y chicas del grupo:
En esta tarea vamos a trabajar todos juntos para hacer el proyecto de SpringBoot desde este repositorio a nuestro IDE de eclipe ok?
Okey, entonces. Cada individuo va a hacer una parte del proyecto para avanzar de forma paulatina es decir. EJ: Yo hago 3 clases y 3 repositorios y 3 servicios de esa misma clase. Luego otro ira avanzando y completando las clases restantes. Eso lo hiremos viendo pero vamos a lo tocho.
NOS TENEMOS QUE PONER DE ACUERDO CON QUE HACER CADA UNO. Y CUANDO HAGAMOS ESO EN ECLIPSE HACE CADA UNO SU PARTE Y LO SUBE A ESTE REPOSITORIO DESDE UNA RAMA DIFERENTE. EL MAIN NO, EL MAIN SOLO PARA UNIRLO Y COMPLETARLO OK?
ENTONCES, CADA UNO CREARA UNA RAMA, INDICANDO VUESTRO NOMBRE PARA IDENTIFICAR DE QUIEN ES ESA RAMA. HASTA AHÍ OK, EN ESA RAMA ES CUANDO VAIS A METER VUESTRA PARTE: EJ
RamaCarlos -> las clases repositorios y endpoint que yo he creado. RamaRafael -> dos clases mas, etc etc...
okey okey okey hasta este punto algunos individuos de este grupo se pensaran. vale bro y como se hace eso 😭. Yo lo explico de forma breve.

Creas un proyecto en eclipse y ahi haces tu parte, tus mamadas. Ahora, debereis instalar git bash. Una vez instalado git bash podeis subir ramas a este repositorio. COMO?
1. cd (RUTA DE MI PROYECTO) desde la terminal cmd o donde sea. Nos ubicamos en el proyecto de nuestro eclipse (NOTA: SI EN ESE PROYECTO SE ENCUENTRA .METADATA DEL WORKSPACE DEBEREIS CREAR UN .IGNOREGIT)
2. escribir git init
3. escribir git add .
4. git commit -m "LOQUESEA"
5. A partir de aqui creas una nueva rama. ACA OS DEJO TODOS LOS COMANDOS QUE QUERAIS PARA CREARLA
    🌿 Creación y Navegación de Ramas
    
    • git branch <nombre> – Crea una rama nueva sin moverte de la actual.
    • git switch -c <nombre> – Crea una rama nueva y se mueve a ella automáticamente.
    • git switch <nombre> – Cambia a una rama que ya existe.
    • git branch -a – Muestra todas las ramas (locales y las del servidor remoto).
    
    🛠️ Gestión y Limpieza de Ramas
    • git branch -m <nuevo-nombre> – Renombra la rama en la que estás posicionado actualmente.
    • git branch -d <nombre> – Borra una rama de forma segura (solo si ya has fusionado sus cambios).
    • git branch -D <nombre> – Fuerza el borrado de una rama (incluso si tiene cambios sin guardar).
    • git branch -m <nuevo-nombre> – Renombra la rama en la que estás posicionado actualmente.
    • git branch -d <nombre> – Borra una rama de forma segura (solo si ya has fusionado sus cambios).
    • git branch -D <nombre> – Fuerza el borrado de una rama (incluso si tiene cambios sin guardar).

  OBVIAMENTE CREAIS UNA RAMA NUEVA Y OS DESPLAZAIS A ELLA PARA TRABAJAR EN ESA RAMA SABES
  6. git remote add origin https://github.com
  7. git push -u origin nombre-de-tu-rama
