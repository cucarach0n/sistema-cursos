
package com.rysoft.cursos.InterfaceModelos;

import com.rysoft.cursos.Modelos.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_usuario extends CrudRepository<Usuario,Integer> {
    @Query(value="select * from basefarmacia.usuarios where usuarios.correo like ?1 and usuarios.contrasena like ?2",nativeQuery = true)
    public List<Usuario> findbyverificarLOGINdasboard(String correo, String contrasena);
}
