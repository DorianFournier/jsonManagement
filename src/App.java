import java.io.FileReader;
import org.json.simple.parser.*;
import java.util.Iterator;
import java.util.Map;
  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {
        Object obj = new JSONParser().parse(new FileReader("network.json"));
        
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
          
        // getting firstName and lastName
        String ipServer = (String) jo.get("ipServer");
        String nickName = (String) jo.get("nickName");
          
        System.out.println("IP :" + ipServer);
        System.out.println("NickName :" + nickName);
          
        // getting age
        long maxUser = (long) jo.get("maxUser");
        System.out.println("maxUser : " + maxUser);
            
        // getting address
        Map host = ((Map)jo.get("host"));

        System.out.println("--- host ---");
        // iterating address Map
        Iterator<Map.Entry> itr1 = host.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        
        // getting phoneNumbers
        JSONArray ja = (JSONArray) jo.get("users");
          
        // iterating phoneNumbers
        Iterator itr2 = ja.iterator();

        System.out.println("--- user client ---");
        while (itr2.hasNext()) 
        {
            System.out.println("- new user -");
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
     }

     public void parseFile(){
     }

     public void writeFile(){
        
     }
}
