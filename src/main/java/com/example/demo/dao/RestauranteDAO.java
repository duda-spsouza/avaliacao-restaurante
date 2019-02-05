package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Restaurante;
import com.example.demo.model.RestauranteForm;

@Repository
public class RestauranteDAO {
  
    private static final Map<Long, Restaurante> restauranteMap = new HashMap<Long, Restaurante>();
  
    static {
        initEmps();
    }
    
    private static void initEmps() {
        Restaurante restaurante1 = new Restaurante(1L, "Via Natural", "Rua A", "","");
        Restaurante restaurante2 = new Restaurante(2L, "Severo Garage", "Rua B", "","");
        Restaurante restaurante3 = new Restaurante(3L, "Silva", "Rua C", "","");
        Restaurante restaurante4 = new Restaurante(4L, "Padaria Paris", "Rua D", "1","Segunda-feira");
        Restaurante restaurante5 = new Restaurante(5L, "Benedito", "Rua E", "5","Sexta-feira");
        Restaurante restaurante6 = new Restaurante(6L, "Nino", "Rua F", "","");
  
        restauranteMap.put(restaurante1.getRestauranteId(), restaurante1);
        restauranteMap.put(restaurante2.getRestauranteId(), restaurante2);
        restauranteMap.put(restaurante3.getRestauranteId(), restaurante3);
        restauranteMap.put(restaurante4.getRestauranteId(), restaurante4);
        restauranteMap.put(restaurante5.getRestauranteId(), restaurante5);
        restauranteMap.put(restaurante6.getRestauranteId(), restaurante6);
    }
  
    public Long getMaxEmpId() {
        Set<Long> keys = restauranteMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }
  
    public Restaurante getRestaurante(Long restauranteId) {
        return restauranteMap.get(restauranteId);
    }
    
    public Restaurante addRestaurante(RestauranteForm restauranteForm) {
        Long empId= this.getMaxEmpId()+ 1;
        restauranteForm.setRestauranteId(empId);
        Restaurante newEmp = new Restaurante(restauranteForm);  
         
        restauranteMap.put(newEmp.getRestauranteId(), newEmp);
        return newEmp;
    }
  
    public Restaurante updateRestaurante(RestauranteForm restauranteForm) {
        Restaurante restaurante = this.getRestaurante(restauranteForm.getRestauranteId());
        if(restaurante!= null)  {
        	restaurante.setRestauranteNome(restauranteForm.getRestauranteNome());
        	restaurante.setRestauranteEndereco(restauranteForm.getRestauranteEndereco());
        	restaurante.setRestauranteVoto(restauranteForm.getRestauranteVoto());
        	restaurante.setRestauranteDiaSemana(restauranteForm.getRestauranteDiaSemana());
        }  
        return restaurante;
    }
  
    public void deleteRestaurante(Long restaurenteId) {
    	restauranteMap.remove(restaurenteId);
    }
  
    public List<Restaurante> getAllRestaurantes() {
        Collection<Restaurante> c = restauranteMap.values();
        List<Restaurante> list = new ArrayList<Restaurante>();
        list.addAll(c);
        return list;
    }
  
}

