package tutorial.misonTIC.seguridad.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tutorial.misonTIC.seguridad.Modelos.Permiso;
import tutorial.misonTIC.seguridad.Modelos.Rol;
import tutorial.misonTIC.seguridad.Repositorios.RepositorioPermiso;
import tutorial.misonTIC.seguridad.Repositorios.RepositorioRol;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos")
public class ControladorPermiso {

    @Autowired
    private RepositorioPermiso miRepositorioPermiso;

    @GetMapping("")//Decorador que permite definir el metodo y la ruta
    public List<Permiso> index(){
        return this.miRepositorioPermiso.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    //Metodo que me permite crear un usuario save
    public Permiso create(@RequestBody Permiso infoPermiso){
        return this.miRepositorioPermiso.save(infoPermiso);
    }

    @GetMapping("{id}")
    public Permiso show(@PathVariable String id){
        Permiso permisoActual=this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        return permisoActual;
    }

    @PutMapping("{id}")
    public Permiso update(@PathVariable String id,@RequestBody  Permiso infoPermiso){
        Permiso permisoActual=this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if (permisoActual != null){
            permisoActual.setUrl(infoPermiso.getUrl());
            permisoActual.setMetodo(infoPermiso.getMetodo());
            return this.miRepositorioPermiso.save(permisoActual);
        }else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Permiso permisoActal=this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if (permisoActal != null){
            this.miRepositorioPermiso.delete(permisoActal);
        }
    }
}
