package lambda;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.NoSuchFileException;

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
