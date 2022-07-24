
package com.portfolioveroramirez.vdr.security.Service;

import com.portfolioveroramirez.vdr.security.Entity.Rol;
import com.portfolioveroramirez.vdr.security.Enums.RolNombre;
import com.portfolioveroramirez.vdr.security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
    
}
