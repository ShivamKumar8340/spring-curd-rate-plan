package com.sunglowsys.controller;


import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.service.RatePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatePlanResource {
    @Autowired
    private RatePlanService ratePlanService;


    @PostMapping("/rateplans")
    public RatePlan create(@RequestBody RatePlan ratePlan) {
        return ratePlanService.save(ratePlan);
    }

    @PutMapping("/rateplans/{id}")
    public RatePlan update(@RequestBody RatePlan ratePlan,@PathVariable("id") Long id) {
        return ratePlanService.update(ratePlan,id);

    }
    @GetMapping("/rateplans")
    public List<RatePlan> getAll() {
        List<RatePlan> ratePlans=ratePlanService.findAll();
        return ratePlans;
    }

    @GetMapping("/rateplans/{id}")
    public RatePlan getById(@PathVariable("id") Long id) {
        return ratePlanService.findById(id);
    }

    @DeleteMapping("/rateplans/{id}")
    void delete(@PathVariable("id") Long id) {
        ratePlanService.delete(id);
    }

}
