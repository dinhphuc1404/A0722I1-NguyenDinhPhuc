package CaseStudy.services;

import CaseStudy.models.Facility;
import CaseStudy.models.Villa;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityServiceImpl implements FacilityService{
    private static final Map<Facility, Integer> FACILITY_INTEGER_MAP;
    static {
        FACILITY_INTEGER_MAP =new LinkedHashMap<>();
    }

    @Override
    public void display() {
        for (int i=0;i<FACILITY_INTEGER_MAP.size();i++){
            System.out.println(FACILITY_INTEGER_MAP.get(i));
        }

    }

    @Override
    public void addNew() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
