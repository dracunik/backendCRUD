package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.NutritionalPlanDTO;
import pe.edu.upc.demo.entities.NutritionalPlan;
import pe.edu.upc.demo.services.iNutritionalPlanService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nutritionalPlans")
public class NutritionalPlanController {
    @Autowired
    private iNutritionalPlanService npS;
    @GetMapping
    public List<NutritionalPlanDTO> list() {
        return npS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, NutritionalPlanDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public NutritionalPlanDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        NutritionalPlanDTO dto = m.map(npS.listId(id), NutritionalPlanDTO.class);
        return dto;
    }
    @PostMapping
    public void insert(@RequestBody NutritionalPlanDTO dto) {
        ModelMapper m = new ModelMapper();
        NutritionalPlan tp = m.map(dto, NutritionalPlan.class);
        npS.insert(tp);
    }
    @PutMapping
    public void update(@RequestBody NutritionalPlanDTO dto) {
        ModelMapper m = new ModelMapper();
        NutritionalPlan tp = m.map(dto, NutritionalPlan.class);
        npS.insert(tp);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        npS.delete(id);
    }
}
