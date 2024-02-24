# Descripción de Mi Proyecto

## Introducción

Este documento proporciona una descripción general de mi proyecto y presenta algunas secciones clave del código.


## Clases Principales

### `DogEntity`

La clase `DogEntity` representa la entidad de perro en la base de datos.

```kotlin
@Entity
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "breed") val breed: String,
    @ColumnInfo(name = "image") val image: String
)

### `DogDao`
La interfaz `DogDao` define las consultas de la base de datos.

```kotlin
@Dao
interface DogDao {

    @Query ("SELECT * FROM dogentity")
    suspend fun getAll(): List<DogEntity>

    @Query ("SELECT * FROM dogentity WHERE breed = :breed")
    fun getDogsByBreed(breed: String): List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDog(vararg dogs : DogEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDog(dogs: List<DogEntity>)

    @Query ("DELETE FROM dogentity")
    fun deleteAll()
}
```

### `DogEntity`

La clase `DogEntity` es la entidad de base de datos utilizada en el contexto de Room.

```kotlin

@Entity
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int =0,
    @ColumnInfo (name = "breed") val breed: String,
    @ColumnInfo (name="image") val image: String
)

```

## **Uso de Tecnologías**

`Kotlin:` Lenguaje de programación principal.
`Room:` Biblioteca de persistencia para la base de datos.
`Hilt:` Para la  inyección de dependencias.


