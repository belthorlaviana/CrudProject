
/* despues de que hibernate cree les tables, hay que ejecutar esti sql pa que el campo create_at se inserte automaticamente con el valor de la hora en el que se haga cada insert
  ,esti campo sirve pa auditoria, por lo que no puede ser actualizado , ni insertado manualmente, tiene que ser automaticamente*/

/*
1-CON LA SIGUIENTE CONFIGURACION:
    defer-datasource-initialization: false
    ddl-auto: update
2-pring CREA LAS TABLAS SI NO EXISTEN O ACTUALIZA EL ESQUEMA SIN BORRAR DATOS
LA PRIMERA CONFIGURACION A FALSE EVITA QUE AL ARRANCAR SPRING EJECUTE EL SCHEMMA.SQL Y EL DATA.SQL
3-DESPUES DE QUE HIBERNATE CREE LAS TABLAS HAY QUE UPDATEAR LA TABLA PRODUCT  PARA QUE EL CAMPO createdAt DE LA ENTIDAD Product, CADA VEZ QUE SE HAGA UN INSERT
RELLENE EL CAMPO DE BASE DE DATOS created_at
4-EL ATRIBUTO DE LA CLASE DEBE LLEVAR @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    * NO PUEDE SER NULL --->PORQUE CADA VEZ QUE SE INSERTE ALGO DEBE DE QUEDAR CONSTANCIA
    * NO PUEDE SER UPDATEABLE--->ES UN REGISTRO DE AUDITORIA, NO TIENE SENTIDO QUE SE PUEDA UPDATEAR O TRAMPEAR
    * TAMPOCO SE PUEDE INSERTAR CUANDO SE INSERTE EL OBJETO,PORQUE SE PODRIA INSERTAR UNA FECHA DISTINTA DE LA DE INSERCIÓN REAL
*/

/*tambien funciona este*/
UPDATE product SET created_at = NOW() WHERE created_at IS NULL;