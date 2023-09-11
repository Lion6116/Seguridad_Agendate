package tutorial.misonTIC.seguridad.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tutorial.misonTIC.seguridad.Modelos.Rol;
import tutorial.misonTIC.seguridad.Modelos.Usuario;
import tutorial.misonTIC.seguridad.Repositorios.RepositorioRol;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/roles")
public class ControladorRol {

    @Autowired
    private RepositorioRol miRepositorioRol;



    @GetMapping("")//Decorador que permite definir el metodo y la ruta
    public List<Rol> index(){
        return this.miRepositorioRol.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    //Metodo que me permite crear un usuario save
    public Rol create(@RequestBody Rol infoRol){
        return this.miRepositorioRol.save(infoRol);
    }

    @GetMapping("{id}")
    public Rol show(@PathVariable String id){
        Rol rolActual=this.miRepositorioRol
                .findById(id)
                .orElse(null);
        return rolActual;
    }


    @PutMapping("{id}")
    public Rol update(@PathVariable String id,@RequestBody  Rol infoRol){
        Rol rolActual=this.miRepositorioRol
                .findById(id)
                .orElse(null);
        if (rolActual != null){
            rolActual.setNombre(infoRol.getNombre());
            rolActual.setDescripcion(infoRol.getDescripcion());
            return this.miRepositorioRol.save(rolActual);
        }else{
            return null;
        }
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Rol rolActual=this.miRepositorioRol
                .findById(id)
                .orElse(null);
        if (rolActual!=null){
            this.miRepositorioRol.delete(rolActual);
        }
    }
}
