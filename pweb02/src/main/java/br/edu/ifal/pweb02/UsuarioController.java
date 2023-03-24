package br.edu.ifal.pweb02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository repo;
    
    @GetMapping 
    @ResponseBody 
    Iterable<Usuario> all(){
        return repo.findAll();
    }
    
    @GetMapping("formulario") 
    ModelAndView usuario(Model m){        
        m.addAttribute("usuario", new Usuario());                
        return new ModelAndView("usuario.html");
    }

    @PostMapping 
    @ResponseBody 
    Usuario add(@RequestParam String nome, @RequestParam String email){
        Usuario n = new Usuario();
        n.setNome(nome);
        n.setEmail(email);
        return repo.save(n);
    }
}
