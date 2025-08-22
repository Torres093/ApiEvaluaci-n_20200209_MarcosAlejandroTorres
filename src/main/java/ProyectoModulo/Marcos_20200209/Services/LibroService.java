package ProyectoModulo.Marcos_20200209.Services;

import ProyectoModulo.Marcos_20200209.Entities.LibroEntity;
import ProyectoModulo.Marcos_20200209.Models.DTO.DTOlibro.libroDTO;
import ProyectoModulo.Marcos_20200209.Repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    private LibroRepository repo;

    public List<libroDTO> getAllLibros(){
        List<LibroEntity> libros = repo.findAll();
        return libros.stream()
                .map(this::convertirALibroDTO)
                .collect(Collectors.toList());
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
}
