package pe.edu.upc.demo.services;

import pe.edu.upc.demo.entities.NutritionalPlan;

import java.util.List;

public interface iNutritionalPlanService {
    public void  insert (NutritionalPlan nutritionalPlan);
    List<NutritionalPlan> list();
    public void delete(int idNutritionalPlan);
    public NutritionalPlan listId(int idNutritionalPlan);
}
