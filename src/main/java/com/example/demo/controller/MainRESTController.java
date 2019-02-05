package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.RestauranteDAO;
import com.example.demo.model.Restaurante;
import com.example.demo.model.RestauranteForm;

@RestController 
public class MainRESTController {
  
    @Autowired
    private RestauranteDAO restauranteDAO;

  
     @RequestMapping(value = "/restaurantes", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Restaurante> getRestaurantes() {
        List<Restaurante> list = restauranteDAO.getAllRestaurantes();
        return list;
    }
 
    @RequestMapping(value = "/restaurante/{restauranteId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Restaurante getRestaurante(@PathVariable("restauranteId") Long restauranteId) {
        return restauranteDAO.getRestaurante(restauranteId);
    }
    
  
    @RequestMapping(value = "/restaurante", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Restaurante addRestaurante(@RequestBody RestauranteForm restauranteForm) {
  
        System.out.println("(Service Side) Restaurante Criado: " + restauranteForm.getRestauranteNome());
  
        return restauranteDAO.addRestaurante(restauranteForm);
    }
  
       @RequestMapping(value = "/restaurante", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Restaurante updateRestaurante(@RequestBody RestauranteForm restauranteForm) {
  
        System.out.println("(Service Side) Restaurante: " + restauranteForm.getRestauranteId());
  
        return restauranteDAO.updateRestaurante(restauranteForm);
    }
    @RequestMapping(value = "/restaurante/{restauranteId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteRestaurante(@PathVariable("restauranteId") Long restauranteId) {
  
        System.out.println("(Service Side) Deletando : " + restauranteId);
  
        restauranteDAO.deleteRestaurante(restauranteId);
    }
  
}
