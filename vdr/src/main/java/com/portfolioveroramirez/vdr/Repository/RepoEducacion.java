
package com.portfolioveroramirez.vdr.Repository;

import com.portfolioveroramirez.vdr.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEducacion extends JpaRepository<Educacion, Integer> {
    public Optional<Educacion> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
