# Proyecto Spring Boot en grupo

Chicos y chicas del grupo: en esta tarea vamos a trabajar todos juntos para hacer el proyecto de Spring Boot desde este repositorio a nuestro Eclipse, ok?

Cada uno va a hacer una parte del proyecto para ir avanzando poco a poco. Ej: yo hago 3 clases, 3 repositorios y 3 servicios de esas mismas clases. Luego otro va avanzando y completando las clases que queden. Eso ya lo iremos viendo, pero vamos a lo tocho.

**NOS TENEMOS QUE PONER DE ACUERDO EN QUÉ HACE CADA UNO. Y CUANDO LO TENGAMOS, CADA UNO HACE SU PARTE EN ECLIPSE Y LA SUBE A ESTE REPOSITORIO DESDE UNA RAMA DIFERENTE. EL MAIN NO. EL MAIN SOLO PARA UNIRLO Y COMPLETARLO, OK?**

Entonces, cada uno crea una rama con su nombre para identificar de quién es. En esa rama es donde metéis vuestra parte. Ej:

- `RamaCarlos` -> las clases, repositorios y endpoints que yo he creado
- `RamaRafael` -> dos clases más, y así

Hasta aquí ok, y algunos os estaréis pensando: vale bro, ¿y cómo se hace eso? 😭 Pues os lo explico rápido.

## Antes de nada

1. Instalad **Git** (con Git Bash): https://git-scm.com/downloads
2. Configurad vuestro nombre y correo (solo una vez):

```
git config --global user.name "Tu Nombre"
git config --global user.email "tucorreo@ejemplo.com"
```

3. Cuando hagáis push, GitHub os va a pedir contraseña y NO vale la de siempre, hay que usar un **token** (GitHub -> Settings -> Developer settings -> Personal access tokens). Ese token es lo que pegáis donde pide la contraseña.

**Proyecto base:** uno de nosotros crea el proyecto Spring Boot (pom.xml, application.properties y el paquete principal) y lo sube al main. El resto parte de ESE proyecto, no os creéis cada uno el vuestro porque luego los paquetes y las dependencias no cuadran y es un drama.

## Cómo subir vuestra parte

1. Abrid la terminal (cmd o Git Bash) en la carpeta donde queráis tener el proyecto y clonad el repositorio:

```
git clone https://github.com/....... (RUTA DE ESTE REPOSITORIO)
cd nombre-del-repositorio
```

**OJO: NO hagáis `git init`.** El repositorio ya existe, se clona. Si hacéis `git init` y luego lo conectáis a mano, vuestra carpeta no tiene nada que ver con el main y luego no se puede unir (os saldrá `refusing to merge unrelated histories`).

2. Creáis vuestra rama y os movéis a ella (esto es lo más importante, trabajáis SIEMPRE en vuestra rama):

```
git switch -c RamaCarlos
```

(ponéis vuestro nombre, claro)

3. Abrís el proyecto en Eclipse: File -> Import -> Maven -> Existing Maven Projects, y seleccionáis la carpeta que acabáis de clonar. Ahí hacéis vuestra parte, vuestras clases, repositorios, servicios y endpoints. Solo los que os tocan, no toquéis lo de los demás.

4. Cuando tengáis algo hecho, lo subís:

```
git add .
git commit -m "LO QUE SEA (mejor algo que se entienda, tipo: añado Usuario y Admin con sus repos)"
git push -u origin RamaCarlos
```

El `-u` solo la primera vez, las siguientes con `git push` vale.

Y ya está, vuestra rama aparece en GitHub.

## El .gitignore

**NOTA:** si en la carpeta se os cuelan cosas del propio Eclipse (como `.metadata` del workspace) o carpetas de compilación, tenéis que crear un archivo que se llame `.gitignore` (con el punto delante y tal cual, no `.ignoregit`) y meter dentro esto:

```
target/
.metadata/
.settings/
.classpath
.project
```

Si no, os dará conflictos a cada rato por cosas que no importan.

## Comandos de ramas

Por si queréis trastear:

```
Creación y navegación
git branch <nombre>       -> crea una rama nueva sin moverte de la actual
git switch -c <nombre>    -> crea una rama nueva y te mueve a ella
git switch <nombre>       -> cambia a una rama que ya existe
git branch -a             -> muestra todas las ramas (locales y del servidor)

Gestión y limpieza
git branch -m <nuevo>     -> renombra la rama en la que estás
git branch -d <nombre>    -> borra una rama de forma segura (solo si ya está fusionada)
git branch -D <nombre>    -> fuerza el borrado (aunque tenga cambios sin fusionar)
```

Y antes de hacer commit, mirad en qué rama estáis con `git branch` o `git status`, que como hagáis commit en main sin querer la liamos.

## Ejemplo de todo seguido

Yo soy Carlos y me tocan Usuario y Admin:

```
git clone https://github.com/....
cd nombre-del-repositorio
git switch -c RamaCarlos
(hago mis clases en Eclipse)
git add .
git commit -m "Añado Usuario y Admin con repositorios y servicios"
git push -u origin RamaCarlos
```

Rafael hace lo mismo pero con `RamaRafael` y sus clases.

## Cómo se junta todo en el main

Cuando tengáis vuestra parte subida, entráis a GitHub y os sale un botón de "Compare & pull request". Le dais, lo creáis de vuestra rama hacia main, y avisáis por el grupo para que lo miremos y lo unamos. Así el main no se rompe.

## Si os sale algún error

- `refusing to merge unrelated histories` -> hicisteis `git init` en vez de `git clone`. Borrad la carpeta y clonad de nuevo.
- `rejected` al hacer push -> alguien ha subido antes que vosotros. Haced `git pull` y luego `git push`.
- Conflicto en `pom.xml` o `application.properties` -> los han tocado dos personas. Hablad antes de tocarlos, que los cambie solo uno.
- Os pide contraseña y no va -> es el token, ya lo expliqué arriba.

Y nada, a picar código. Cualquier duda preguntad en el grupo antes de liarla. 💻
