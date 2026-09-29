#  DUDES Y EXPLICACIONES SOBRE EL CODIGO
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## 1 Campo `createdAt` del bean `Product`
Este campo se utiliza para **auditoría**, por lo que no debe poder ser insertado ni actualizado manualmente desde la aplicación.
Cuando se inserta un objeto `Product` en la base de datos, el campo `createdAt` debe rellenarse **automáticamente desde la propia base de datos**.
Para ello:

```java
@Column(
    name = "created_at",
    nullable = false,
    updatable = false,
    insertable = false
)
private Instant createdAt;
```

### Propiedades importantes

* `nullable = false` → el campo no puede ser `NULL` en la base de datos.
* `updatable = false` → JPA no permite modificar el campo mediante un `UPDATE`.
* `insertable = false` → JPA no incluye el campo en el `INSERT`.
* Al no ser `insertable` ni `updatable`, el valor debe ser generado por la **base de datos**.

> **Importante:** para que `createdAt` se rellene automáticamente, la columna `created_at` debe tener configurado en la base de datos un valor por defecto, por ejemplo `CURRENT_TIMESTAMP`.

```text
INSERT Product
      ↓
```

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## 2.1 ¿Qué es un Annotation Processor?

Un **Annotation Processor** es una herramienta que se ejecuta **durante la compilación** y genera código automáticamente a partir de determinadas anotaciones.

Ejemplos:

* **Lombok** → `@Data` → genera getters, setters, constructores, etc.
* **MapStruct** → `@Mapper` → genera `ProductMapperImpl`.

```text
Código + anotaciones
        ↓
Annotation Processor
        ↓
Código generado
```



## 2.2. ¿Qué es `annotationProcessorPaths`?

Es la configuración de Maven donde indicamos **qué Annotation Processors debe utilizar durante la compilación**.

Por ejemplo:

```xml
<annotationProcessorPaths>

    <!-- Lombok -->
    <path>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </path>

    <!-- MapStruct -->
    <path>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>${mapstruct.version}</version>
    </path>

</annotationProcessorPaths>
```

En nuestro proyecto:

```text
Lombok
  → genera código de Lombok

MapStruct Processor
  → genera ProductMapperImpl
```

### ⚠️ Idea clave
Si configuramos `annotationProcessorPaths`, debemos asegurarnos de incluir **todos los Annotation Processors que necesitamos**, como Lombok y MapStruct.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## 3 Method threw 'java.lang.StackOverflowError' exception. Cannot evaluate com.example.crudproject.entity.Category.toString()

### Error `StackOverflowError` al depurar entidades JPA

El error:

```text
Method threw 'java.lang.StackOverflowError' exception.
Cannot evaluate Category.toString()
```

puede aparecer cuando IntelliJ intenta mostrar una entidad en el debugger y ejecuta su método `toString()`.

En relaciones bidireccionales como `Category` ↔ `Product`, `toString()` puede entrar en un **bucle infinito**:

```text
Category → products → Product → category → Category → ...
```

Esto provoca un `StackOverflowError`.

La solución es excluir las relaciones del `toString()` mediante Lombok:

```java
@ToString.Exclude
private List<Product> products;
```

y:

```java
@ToString.Exclude
private Category category;
```

De esta forma, IntelliJ puede mostrar las entidades durante la depuración sin recorrer continuamente la relación bidireccional.
