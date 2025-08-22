package ProyectoModulo.Marcos_20200209.Models.DTO.DTOlibro;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @EqualsAndHashCode
@Getter @Setter
public class libroDTO {
    //Validación básica para que los datos no se envíen si los campos están vacíos, acompañados del sus getters y setters
private  Long id;
@NotBlank(message = "El titulo es obligatorio")
private String titulo;
@NotBlank(message = "El ISBN es obligatorio")
private  String isbn;
@Getter @Setter
private long año_publicacion;
@Getter @Setter @NotBlank(message = "Debe incluir el genero")
private String genero;
private  Long autor_id;

}
