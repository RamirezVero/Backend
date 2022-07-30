
package com.portfolioveroramirez.vdr.Controller;

import com.portfolioveroramirez.vdr.Dto.dtoEducacion;
import com.portfolioveroramirez.vdr.Entity.Educacion;
import com.portfolioveroramirez.vdr.Service.ServiceEducacion;
import com.portfolioveroramirez.vdr.security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
@CrossOrigin
public class ControllerEducacion {
    @Autowired
    ServiceEducacion serviceEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = serviceEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getTitulo()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(serviceEducacion.existsByTitulo(dtoedu.getTitulo()))
            return new ResponseEntity (new Mensaje("Esa Educación ya existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(dtoedu.getTitulo(), dtoedu.getInstitucion()
        ,dtoedu.getConocimientos(), dtoedu.getInicio(), dtoedu.getFin(), dtoedu.getImg());

        serviceEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        if(!serviceEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        if(serviceEducacion.existsByTitulo(dtoedu.getTitulo()) && serviceEducacion.getByTitulo(dtoedu.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Educación ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoedu.getTitulo()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);

        Educacion educacion = serviceEducacion.getOne(id).get();
        educacion.setTitulo(dtoedu.getTitulo());
        educacion.setInstitucion(dtoedu.getInstitucion());
        educacion.setConocimientos(dtoedu.getConocimientos());
        educacion.setInicio(dtoedu.getInicio());
        educacion.setFin(dtoedu.getFin());
        educacion.setImg(dtoedu.getImg());

        serviceEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK); 

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!serviceEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);

        serviceEducacion.delete(id);

        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK); 
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!serviceEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = serviceEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
}
