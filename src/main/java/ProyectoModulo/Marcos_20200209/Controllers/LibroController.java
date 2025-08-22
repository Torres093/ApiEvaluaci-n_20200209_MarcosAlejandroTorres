package ProyectoModulo.Marcos_20200209.Controllers;

import ProyectoModulo.Marcos_20200209.Models.DTO.DTOlibro.libroDTO;
import ProyectoModulo.Marcos_20200209.Services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LibroController {


    //Peticion GET
    @Autowired
    private LibroService service;

    @GetMapping("/libros")
    public List<libroDTO> datosLibros(){
        return service.getAllLibros();
    }

    //Peticion Post


    @PutMapping("/actualizar/{id}")

    public ResponseEntity<?> actualizarLibro(@PathVariable Long id, @Valid @RequestBody LibroDTO dto, BindingResult result){
        if (result.hasErrors()){
            Map<String,String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> errores.put(error.getField(),error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        try {
            return ResponseEntity.ok(service.actualizarLibro(id,dto));
        }catch (RuntimeException e){
            return  ResponseEntity;
        }


}
