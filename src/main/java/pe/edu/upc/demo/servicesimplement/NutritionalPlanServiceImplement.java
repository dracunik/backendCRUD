package pe.edu.upc.demo.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.NutritionalPlan;
import pe.edu.upc.demo.repositories.iNutritionalPlanRepository;
import pe.edu.upc.demo.services.iNutritionalPlanService;

import java.util.List;

@Service
public class NutritionalPlanServiceImplement implements iNutritionalPlanService {
    @Autowired
    private iNutritionalPlanRepository npR;
    @Override
    public void  insert (NutritionalPlan nutritionalPlan){
        npR.save(nutritionalPlan);
    }
    @Override
    public List<NutritionalPlan> list(){
        return npR.findAll();
    }
    @Override
    public void delete(int idNutritionalPlan){
        npR.deleteById(idNutritionalPlan);
    }
    @Override
    public NutritionalPlan listId(int idNutritionalPlan){
        return npR.findById(idNutritionalPlan).orElse(new NutritionalPlan());
    }
}
