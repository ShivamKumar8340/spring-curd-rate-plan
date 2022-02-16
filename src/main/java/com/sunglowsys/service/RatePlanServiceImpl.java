package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.repository.RatePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RatePlanServiceImpl implements RatePlanService{

    @Autowired
    private RatePlanRepository ratePlanRepository;
    @Override
    public RatePlan save(RatePlan ratePlan) {

        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public RatePlan update(RatePlan ratePlan, Long id) {
        RatePlan ratePlan1=ratePlanRepository.getById(id);
        ratePlan1.setName(ratePlan.getName());
        return ratePlanRepository.save(ratePlan1);
    }

    @Override
    public List<RatePlan> findAll() {
        return ratePlanRepository.findAll();
    }

    @Override
    public RatePlan findById(Long id) {
        Optional<RatePlan> optional=ratePlanRepository.findById(id);
        RatePlan ratePlan=null;
        if (optional.isPresent()) {
            ratePlan=optional.get();
        }
        else {
            throw new RuntimeException("record not found for idNo:" +id);
        }
        return ratePlan;
    }

    @Override
    public void delete(Long id) {
        ratePlanRepository.deleteById(id);

    }
}
