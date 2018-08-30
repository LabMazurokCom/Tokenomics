package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DBUtils {
    public static final String usersDB = "src/main/db/users.json";
    public static String readUsers(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(usersDB));){
            StringBuilder stringBuilder = new StringBuilder();
            while(bufferedReader.ready()){
                stringBuilder.append(bufferedReader.readLine());
            }
            return stringBuilder.toString();
        }
        catch(IOException e){
            return null;
        }
    }
}
