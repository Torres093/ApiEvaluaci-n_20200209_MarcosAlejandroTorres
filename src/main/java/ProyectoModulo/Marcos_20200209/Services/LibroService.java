package ProyectoModulo.Marcos_20200209.Services;

import ProyectoModulo.Marcos_20200209.Entities.LibroEntity;
import ProyectoModulo.Marcos_20200209.Models.DTO.DTOlibro.libroDTO;
import ProyectoModulo.Marcos_20200209.Repositories.LibroRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@CrossOrigin
@Service
public class LibroService {
    private LibroRepository repo;

    public libroDTO insert(@Valid libroDTO json){
        if (json == null) {
            throw new IllegalArgumentException("La información del libro no puede estar vacía");
        }
        try {
            LibroEntity libro = convertirAEntity(json);
            LibroEntity libroArchivado = repo.save(libro);
            return convertirALibroDTO(libroArchivado);
        } catch (Exception e) {
            log.error("Error al archivar el libro "+ e.getMessage());
            throw new IllegalArgumentException("No se concretó la operación");
        }
    }

    public libroDTO update(Long id, @Valid libroDTO json){
        LibroEntity libroExistente = repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Producto no encontrado"));
        libroExistente.setTitulo(json.getTitulo());
        libroExistente.setGenero(json.getGenero());
        libroExistente.setAño_publicacion(json.getAño_publicacion());
        LibroEntity libroActualizado = repo.save(libroExistente);
        return convertirALibroDTO(libroActualizado);
    }

    public boolean delete(Long id){
        LibroEntity ex = repo.findById(id).orElse(null);
        if (ex != null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }


    public List<libroDTO> getAllLibros(){
        List<LibroEntity> libros = repo.findAll();
        return libros.stream()
                .map(this::convertirALibroDTO)
                .collect(Collectors.toList());
    }

    private LibroEntity convertirAEntity(@Valid libroDTO json){
        LibroEntity entity = new LibroEntity();
        entity.setId(json.getId());
        entity.setTitulo(json.getTitulo());
        entity.setIsbn(json.getIsbn());
        entity.setGenero(json.getGenero());
        entity.setAño_publicacion(json.getAño_publicacion());
        entity.setAutor_id(json.getAutor_id());
        return entity;
    }

    private libroDTO convertirALibroDTO(LibroEntity libros) {
        libroDTO dto = new libroDTO();
        dto.setId(libros.getId());
        dto.setTitulo(libros.getTitulo());
        dto.setIsbn(libros.getIsbn());
        dto.setGenero(libros.getGenero());
        dto.setAño_publicacion(libros.getAño_publicacion());
        dto.setAutor_id(libros.getAutor_id());
        return dto;
    }

    public Object actualizarLibro(Long id, libroDTO dto) {
        return null;
    }
}
