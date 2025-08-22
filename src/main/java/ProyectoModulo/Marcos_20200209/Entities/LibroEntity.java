package ProyectoModulo.Marcos_20200209.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "libros")
@Setter @Getter @ToString @EqualsAndHashCode
public class LibroEntity {

    //Le indicamos a la API la secuencia a utilizar en la BD
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Libros")
    @SequenceGenerator(name = "seq_Libros", sequenceName = "seq_Libros", allocationSize = 1)
    //Referenciamos las columnas de la tabla "libros" con las variables de la API
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "año_publicacion")
    private long año_publicacion;
    @Column(name = "genero")
    private String genero;
    @Column(name = "autor_id")
    private long autor_id;
}
