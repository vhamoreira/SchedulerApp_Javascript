package models;

import java.util.HashMap;
import java.util.Map;

public class MapperSingleton {
    private Map<String, String> mapping=new HashMap<>();

    private static MapperSingleton mapper=null;

    private MapperSingleton(){}

    public static MapperSingleton getInstance(){
        if(mapper==null){
            mapper=new MapperSingleton();
            mapper.mapping.put("ufp", "8080");
            mapper.mapping.put("up", "8081");
        }
        return mapper;
    }

    public String getPort(String university){
        return this.mapping.get(university);
    }
}
