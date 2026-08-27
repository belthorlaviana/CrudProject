
/* despues de que hibernate cree les tables, hay que ejecutar esti sql pa que el campo create_at se inserte automaticamente con el valor de la hora en el que se haga cada insert
  ,esti campo sirve pa auditoria, por lo que no puede ser actualizado , ni insertado manualmente, tiene que ser automaticamente*/
ALTER TABLE product
    ALTER COLUMN created_at SET NOT NULL;

/*tambien funciona este*/
UPDATE product SET created_at = NOW() WHERE created_at IS NULL;
