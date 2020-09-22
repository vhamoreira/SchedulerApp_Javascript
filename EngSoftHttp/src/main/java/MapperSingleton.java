import java.util.HashMap;
import java.util.Map;

public class MapperSingleton {
    private Map<String, String> mapping=new HashMap<>();

    private static MapperSingleton mapper=null;

    private MapperSingleton(){}

    public static MapperSingleton getInstance(){
        if(mapper==null){
            mapper=new MapperSingleton();
            mapper.mapping.put("UFP", "8081");
            mapper.mapping.put("UP", "8082");
        }
        return mapper;
    }

    public String getPort(String university){
        return this.mapping.get(university);
    }
}
