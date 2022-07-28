
package com.portfolioveroramirez.vdr.Service;

import com.portfolioveroramirez.vdr.Entity.Educacion;
import com.portfolioveroramirez.vdr.Repository.RepoEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceEducacion {
    @Autowired
    RepoEducacion repoEducacion;
    
    public List <Educacion> list(){
        return repoEducacion.findAll();       
    }
    
    public Optional<Educacion> getOne(int id){
        return repoEducacion.findById(id);
    }
    
    public Optional<Educacion> getByTitulo(String titulo){
        return repoEducacion.findByTitulo(titulo);
    }
    
    public void save(Educacion educ){
        repoEducacion.save(educ);
    }

    public void delete(int id){
        repoEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repoEducacion.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return repoEducacion.existsByTitulo(titulo);
    }
    
    
}
