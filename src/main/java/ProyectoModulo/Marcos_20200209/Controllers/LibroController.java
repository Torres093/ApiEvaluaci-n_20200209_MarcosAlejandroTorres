package ProyectoModulo.Marcos_20200209.Controllers;

import ProyectoModulo.Marcos_20200209.Models.DTO.DTOlibro.libroDTO;
import ProyectoModulo.Marcos_20200209.Services.LibroService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/libros")
public class LibroController {


    //Peticion GET
    @Autowired
    private LibroService service;

    @GetMapping("/libros")
    public List<libroDTO> datosLibros(){
        return service.getAllLibros();
    }

    //Peticion Post
    @PostMapping("/postearlibro")
    private ResponseEntity<Map<String, Object>> insertarLibro(@Valid @RequestBody libroDTO json, HttpServletRequest request){
        try {
            libroDTO response = service.insert(json);
            if (response == null){
                return ResponseEntity.badRequest().body(Map.of(
                "Error", "inserción incorrecta",
                    "Estatus", "Inserción incorrecta",
                    "Descripción", "Verifique los valores"
                ));
                return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                        "Estado", "completado",
                        "data", response
                ));
            }
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(Map.of(
                           "status", "error",
                           "message", "Error al registrar el libro",
                           "Detail",  e.getMessage()
                   ));

        }

    }

    @PutMapping("/actualizarLibro/{id}")
    public ResponseEntity<?> modificarLibro(
            @PathVariable Long id,
            @Valid @RequestBody libroDTO libros,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            Map<String, String> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
            }
        try{
            libroDTO libroActualizado = service.update(id, libros);
            return ResponseEntity.ok(libroActualizado);
        }
        catch (ExceptionInInitializerError e){
            return ResponseEntity.notFound().build();
        }

        }
    }







}
