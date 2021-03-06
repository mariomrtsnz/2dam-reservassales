## 1.0.0 - 2018-10-09
### Añadido
- Editar reserva (funcional).

## 0.9.9 - 2018-10-09
### Añadido
- Repetir Reserva en nueva-reserva (funcional).
- Limitación de interacción entre usuario y calendario-general.
- Página de error genérico y mappings para ella con internacionalización.

### Actualizado
- Problema al editar-usuario.

## 0.2.2b - 2018-10-09
### Añadido
- Función en calendario.js para pinchar sobre una reserva y llevar a editar dicha reserva.
- Función eliminar reserva (funcional).

### Actualizado
- Fichero admin-calendario.html con botón de Deshabilitar Fines de Semana corregido tras ultimo merge.
- usuario-editar corregido problema causado por la foto de usuario.
- sala-editar corregido problema causado por la foto de usuario.
- Internacionalización de Editar Reserva.
- Fullcalendar.min.css modificado para mostrar en modo cursor al hacer hover sobre una tarjeta de evento.

## 0.2.2a - 2018-10-09
### Añadido
- Toast de éxito al cambiar el estado de activación de reservar los fines de semana.
- Interruptor en admin-calendario.html para el Admin para modificar el estado de activación de reserva de los fines de semana (funcional).
- Internacionalización de "Deshabilitar Fines de Semana".
- Foto a la clase modelo Usuario.
- Método de editar y de eliminar reserva (no funcional).

### Actualizado
- Foto de la sala en editar-sala.
- Longitud del formulario de nueva-reserva y visualización del botón de Enviar.
- Foto del usuario y en la base de datos (funcional).

### Eliminado
- Tarjeta en nueva-reserva.
- "Sala 1" de ejemplo en el nueva-reserva.

## 0.2.1b - 2018-10-08
### Añadido
- Atributo imagen en clase modelo Sala.
- Comprobación hora inicio de la cita dentro del mínimo y el máximo (con toast).

### Actualizado
- Calendario (fullcalendar) ahora muestra de 08:00 a 21:00 (mínimo y máximo establecido).
- calendario.js ahora tiene por defecto deshabilitado los fines de semana.
- calendario.js ahora muestra los Lunes como el primer día de la semana.

## 0.2.1a - 2018-10-08
### Añadido
- Imágenes de las 2 entidades creadas por defecto de las salas.
- Botón para ir a registro y para volver a inicio de sesión.

### Actualizado
- z-index en el desplegable de usuario.
- Visibilidad de botón de verificar usuario en editar-usuario.html.
- Método save para asignar al usuario el rol de usuario automáticamente.
- data.sql y schema.sql con tabla Event
- Comentado CommandLineRunner

## 0.2.0a - 2018-10-06
### Añadido
- Ficheros necesarios para funcionamiento de Calendario (funcional).

## 0.1.7a - 2018-10-06
### Añadido
- Finalizado solapamiento de fechas (funcional).

## 0.1.6b - 2018-10-05
### Añadido
- Variables de comparación de solapamiento en usuarioController.

## 0.1.6a - 2018-10-05
### Añadido
- Variables para mejor comprensión en UserController.

### Actualizado
- Corregido paleta de colores en nuevo-usuario, nueva-sala, editar-usuario y editar-sala.
- Corregido visibilidad de checkbox.

## 0.1.5c - 2018-10-04
### Añadido
- Comprobación de nueva reserva de solapamiento (no completo funcional).
- Comprobación de nueva reserva de fechaInicial menor que la fechaFinal (funcional).
- Toast al Eliminar en usuarios-lista.html.
- Toast al Editar en usuarios-lista.html.
- Toast al Crear en usuarios-lista.html.
- Toast al Eliminar en salas-lista.html.
- Toast al Editar en salas-lista.html.
- Toast al Crear en salas-lista.html.
- Toast al Crear en admin-calendario.html.
- Toast al Editar en admin-calendario.html.
- Toast de error de solapamiento en nueva-reserva.html.
- Toast de error de orden de fecha inicial y final en nueva-reserva.html.

### Actualizado
- Corregido i18n 'Elegir usuario' en formulario de Nueva Reserva desde Admin.
- Corregido i18n 'Editar Usuario' en formulario de Editar Usuario desde Admin.
- Corregido i18n 'Editar Sala' en formulario de Editar Sala desde Admin.

## 0.1.5b - 2018-10-04
### Actualizado
- Botón flotante con submenú en usuarios-lista.html y salas-lista.html ahora son dos columnas cada una con el icono y su función.

### Eliminado
- Archivo lista.js inutilizado.

## 0.1.5a - 2018-10-04
### Añadido
- Editar Sala funcional.
- Editar Usuario funcional.

### Actualizado
- Corregida internacionalización en dropdown y sidebar.
- Mappings para enviar a editar.
- Movido reserva-editar.html a la carpeta admin.

## 0.1.4d - 2018-10-03
### Añadido
- Mappings en AdminController para editarSala, editarUsuario y editarReserva.

### Actualizado
- Internacionalización en inglés completamente funcional.

## 0.1.4c - 2018-10-03
### Añadido
- Las listas de Sala y Usuario ahora muestran los datos reales.
- Lineas comentadas para asignarle un rol de usuario por defecto a cada nuevo usuario creado.
- Finalizado internacionalización (sin comprobar funcionalidad).
- Etiquetas Thymeleaf a SideNav para nombre e email del usuarioLogueado.
- Eliminar Usuario (sin notificación de éxito).
- Eliminar Sala (sin notificación de éxito).

### Actualizado
- Renombrado atributo validado en POJO Usuario por "enabled" para mayor consistencia de nomenclatura.
- Corregido problema en usuario-nuevo.html con el atributo enabled.
- Corregido problema de estilo en "Administrar Usuarios" de sidenav de Admin.
- Corregido problema de script en "Administrar Usuarios".
- Corregido problema de script en "Administrar Salas".

## 0.1.4b - 2018-10-03
### Añadido
- Nueva Reserva por Usuario logueado funcional.
- Nueva Reserva por Admin funcional.

### Actualizado
- Clase POJO Usuario para que no puedan loguearse usuarios no validados.
- Corregido problema de roles en los usuarios y mostrar el menú principal correspondiente a cada usuario según rol.
- Fichero nueva-reserva.js para cumplir con el formato de ReservaFormBean.java en fecha y hora.
- Ruta de nueva-reserva desde vista calendario según el rol.

### Eliminado
- Archivo index-admin.html inutizilado.

## 0.1.4a - 2018-10-03
### Añadido
- Estructura de ficheros de internacionalización.
- Spring Security Extras para Thymeleaf en pom.xml para el uso de sec:authorize.

### Actualizado
- Select de Salas y Usuarios en nuevaReserva.html puesto para generar opciones por Thymeleaf.


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