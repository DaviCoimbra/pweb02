package br.edu.ifal.pweb02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index.html");
        return model;
        }

    @GetMapping("/hello")
    public ModelAndView greeting(@RequestParam(name = "name", required = false, defaultValue = "mundo") String name) {

        ModelAndView model = new ModelAndView();
        model.addObject("name", name);
        model.setViewName("ola");
        return model;
    }

}
