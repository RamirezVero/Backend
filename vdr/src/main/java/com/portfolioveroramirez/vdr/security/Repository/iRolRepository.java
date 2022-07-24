
package com.portfolioveroramirez.vdr.security.Repository;

import com.portfolioveroramirez.vdr.security.Entity.Rol;
import com.portfolioveroramirez.vdr.security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
 