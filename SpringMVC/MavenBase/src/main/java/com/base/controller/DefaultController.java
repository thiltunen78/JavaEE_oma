
package com.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(ModelMap map){
        //define attributes you want to use in your template index.jsp
        map.addAttribute("name","Tero Hiltunen");
        return "index";
    } 
    
    @RequestMapping(value="/second", method=RequestMethod.GET)
    public String second(ModelMap map){
        //render second.jsp
        return "second";
    }
}
