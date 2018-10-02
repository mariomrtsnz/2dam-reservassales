## 0.1.3b - 2018-10-02
### Añadido
- Etiquetas th:text para mostrar valores de usuarioLogueado (solución temporal en HomeController?).
- Enlace a /logout funcional en la barra de navegación superior.
- Crear Sala funcional.
- Crear Usuario funcional (corregir estilo de checkbox). Un usuario recien creado no se puede loguear.
- Crear Reserva (no funcional).

### Actualizado
- Corregido problema de Logueo. Un usuario recien registrado no se puede loguear.
- data.sql y schema.sql
- Comentado CommandLineRunner y cargando datos desde data.sql y schema.sql.

## 0.1.3a - 2018-10-02
### Añadido
- PostMapping para /registro (funcional). Los usuarios se guardan en la base de datos con la contraseña encriptada.
- sala-editar.html, reserva-editar.html y usuario-editar.html.

### Actualizado
- Etiquetas de Thymeleaf th:object, th:action, th:value y th:field para todos los formularios.
- SecurityConfig y UsuarioService editados para que encripte las contraseñas al hacer save().

## 0.1.2c - 2018-10-01
### Añadido
- PostMapping para /registro (no completo).

### Actualizado
- RegisterUsuario renombrado a RegistroUsuario.
- Añadido atributos, constructores, getters y setters al formBean de RegistroUsuario.
- Añadidas etiquetas de Thyneleaf en registro.html para th:field para el formBean de RegistroUsuario.

## 0.1.2b - 2018-10-01
### Actualizado
- Cambiado Query de findUsuarioWithAuthorities para buscar por email en vez de por ID.

## 0.1.2a - 2018-10-01
### Añadido
- Línea de búsqueda por email en loadByUserName de UsuarioService (comentada).

### Actualizado
- Cambiado método findUsuarioWithAuthorities UsuarioRepositorio para buscar por ID.
- Modificado main.css para corregir colores de calendario.

## 0.1.1b - 2018-09-30
### Añadido
- SalaRepository
- ReservaRepository
- SalaService
- ReservaService
- AuthoritiesRepository y AuthoritiesService (temporales hasta crear data.sql y schema.sql correctos).
- Líneas en CommandLineRunner creando 2 Reservas, 2 Salas, 2 roles de Usuario y 1 de Admin.

### Actualizado
- CommandLineRunner temporal con base de datos creada al ejecutar el proyecto.
- SecurityConfig siguiendo el ejemplo SecuritySample2 de Luismi.

## 0.1.1a - 2018-09-30
### Añadido
- Método findUsuarioWithAuthorities en UsuarioRepository.
- Fichero data.sql en resources.

### Actualizado
- UsuarioService y Usuario implementan UserDetails
- UsuarioRepository.
- Ficher schema.sql cambiado orden de creación de constraints.

### Eliminado
- Atributos id de los constructores de las clases POJO ya que se autogeneran.

## 0.1.0c - 2018-09-28
### Añadido
- Enlace con Thymeleaf a Nueva-Reserva desde lista-usuarios.
- Paquete Service con UsuarioService y funcionalidades básicas.
- CommandLineRunner (temporal).
- Schema.sql

### Actualizado
- Corregidos enlaces con Thymeleaf.
- Modificado ruta de permiso para todos en SecurityConfig (cambiar una vez terminada fase de pruebas).

## 0.1.0b - 2018-09-28
### Añadido
- Enlace con Thymeleaf a Nueva-Reserva desde lista-usuarios.

### Actualizado
- Corregidos enlaces con Thymeleaf.
- Modificado ruta de permiso para todos en SecurityConfig (cambiar una vez terminada fase de pruebas).

## 0.1.0a - 2018-09-28
### Añadido
- Nuevo sistema de configuración basado en security-sample de Luismi. (No funcional).

### Actualizado
- Corregido enlace en admin-calendario.html de nueva reserva.
- Corregido problema de arranque debido a UsuarioRepository.

## 0.0.4e - 2018-09-27
### Añadido
- GetMappings para editarSala, editarReserva y editarUsuario en AdminController.
- Archivos relacionados con FullCalendar al proyecto de Spring.
- Elementos (fragments) comunes en admin-calendario.html.
- Elementos (fragments) comunes en reserva-nueva.html.
- Elementos (fragments) comunes en sala-nueva.html.
- Elementos (fragments) comunes en usuario-nuevo.html.
- Elementos (fragments) comunes en usuarios-lista.html.
- Elementos (fragments) comunes en salas-lista.html.

### Actualizado
- Enlaces correctos de los botones de "Nuevo".
- Enlaces correctos en los botones del SideBar en comun.html
- Enlaces correctos de los botones del menú central en index-usuario.html.
- index-usuario.html ahora contiene los elementos del antiguo index-admin.html (vista según el ROL no funcional).

### Eliminado
- index-admin.html (integrado en index-usuario.html).

## 0.0.4d - 2018-09-27
### Añadido
- Elementos (fragments) comunes en reserva-nueva.html.
- TODO importante en SecurityConfig.java (línea 18).
- GetMapping para /admin/nueva-sala.

### Actualizado
- Mapping para /registro en HomeController.
- Renombrados GetMappings en UserController y AdminController.
- Renombrado GetMapping /index por /home en HomeController.
- Enlaces puestos con th:href y rutas relativas con Thymeleaf.

## 0.0.4c - 2018-09-27
### Añadido
- AdminController.
- UserController.
- Atributos de asociación en las clases Sala, Reserva y Usuario.
- Etiquetas de Hibernate en las clases POJO.
- Métodos Helpers en la clase Usuario y Sala para Reserva.
- Clase Authorities.
- Atributo de Authorities en la POJO Usuario.

### Actualizado
- Corregido problemas de acceso a carpeta de estilo, scripts e imagenes.
- Corregido conflicto de push mediante merge manual.
- HomeController con datos del ultimo push fallido.
- Constructores, Getters, Setters y toStrings de las clases POJO.

### Eliminado
- Clase POJO Admin (se utilizarán ROLES en los Usuarios).

## 0.0.4b - 2018-09-27
### Añadido
- Elementos de fragmentos comunes: sideBar, nav o head.
- Enlaces puestos con th:href y rutas relativas con Thymeleaf.
- HomeController

### Actualizado
- Dropdown de las páginas de inicio ahora muestran "Ver Perfil" y "Cerrar Sesión".
- Reemplazado elementos comunes por fragmentos.

### Eliminado
- Etiqueta inutilizada script con "main.js" en varios htmls.

## 0.0.4a - 2018-09-27
### Añadido
- Importado workspace en clase.

## 0.0.3e - 2018-09-26
### Añadido
- Ficheros de vistas al proyecto de Spring.
- Paquetes (vacíos) para Config, Controller, Model, Repository, Service y FormBean
- Configuracion Spring Security por defecto (no personalizada para nuestra Aplicación).
- Clases POJO con atributos, getters & setters, constructores y toString (sin anotaciones).
- Clase HomeController básica (no configurada para nuestra Aplicación).

### Actualizado
- Eliminado atributo "disponible" de la clase POJO "Sala".

## 0.0.3d - 2018-09-26
### Añadido
- Carpeta "workspace" que contendrá el proyecto principal con la aplicación de Spring.
- Esqueleto de la estructura del proyecto con las dependencias H2, JPA, Hibernate, Web y Security.

## 0.0.3c - 2018-09-26
### Añadido
- Botón de añadir nuevo elemento en los archivos de listas.

### Actualizado
- Corregido posición de los elementos de menú de "index-usuario.html".
- Iconos del menú "index-usuario.html".
- Menú lateral de "index-usuario.html".
- Posición de icono de teléfono en pantallas grandes en "index-usuario.html".
- Título de "salas-lista.html"
- Posición de los iconos del botón flotante en las listas de "salas-lista.html" y "usuarios-lista.html".

## 0.0.3b - 2018-09-26
### Añadido
- Sidenav en "index-admin.html".

### Actualizado
- Corregido posición de los elementos de menú de "index-main.html" (main.css).

## 0.0.3a - 2018-09-26
### Añadido
- index-usuario.html.

### Actualizado
- Color al hover de los botones de "index-usuario.html".
- Eliminado botón contacto en "index-admin.html".
- Corregido posición de los elementos de menú de "index-main.html" (main.css).

## 0.0.2c - 2018-09-25
### Añadido
- Librería FullCalendar y Moment.js
- Calendario (no funcional).
- Lista salas.
- Formulario de Nueva Sala (reutilizable después para Editar Sala).
- Atributo "aforoMax" a la clase POJO "Sala".
- Formulario de Nuevo Usuario (reutilizable después para Editar Usuario).

### Actualizado
- Terminado index-admin.html.
- Habilitado los fines de semana en el calendario (aunque luego el Admin decidirá entre habilitarlos o no).
- Cambiado nombre del archivo "nueva-reserva.html" por "reserva-nueva.html" para seguir la nomenclatura.
- Corregido problema con el padding en los formularios de "reserva-nueva.html" y "sala-nueva.html".
- Cambiado inputs de "index.html" y de "registro.html" a "required".
- Corregido linting de todos los ficheros.
- Corregido título de "usuario-nuevo.html" y estilo de labels para cumplir las guías de diseño Material.


## 0.0.2b - 2018-09-25
### Añadido
- Navbar funcional y responsivo al index-admin.
- Archivo vacío admin-calendario.html.

### Actualizado
- Finalizada página de Admin: Nueva Reserva (reutilizable después para editar).
- Diagrama de clases (añadida clase día).

### TODO
- Corregir espacio entre elementos en pantallas Large en Admin - nueva-reserva.html

## 0.0.2a - 2018-09-25
### Añadido
- Datepicker y Timepicker con Materialize para Nueva Reserva (funcional).
- Creada estructura de página principal de Admin.
- Creada página de Registro.

### Actualizado
- Corregido error al cambiar el focus de los inputs.
- Movido localización de nueva reserva a Admin.

## 0.0.1b - 2018-09-24
### Añadido
- Añadidos favicons.
- Tarjetas y esqueleto inicial del formulario de Nueva Reserva.

### Actualizado
- Actualizados los títulos de los archivos .html creados hasta el momento.
- La tabla con la lista de usuarios es ahora responsiva.

## 0.0.1a - 2018-09-24
### Añadido
- Menú desplegable al hacer click con las opciones de Editar y Borrar.
- Fichero lista.js que aporta funcionalidad al menú desplegable.
- Creado archivo reserva.css.
- Creado archivo usuarios-lista.html al cual solo el Admin tendrá acceso.
- Creado archivo nueva-reserva.html la cual contendrá el formulario común para Admin y Usuario de creación de una reserva.

### Eliminado
- Archivo diagramaclases.lbd (archivo temporal creado cuando se tiene abierto Enterprise Architect). Innecesario.

### Actualizado
- Diagrama de clases en archivo diagramaclases.eap.