
package program_processing_java;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WriteReadFile {
    private static boolean isSaving;
    
    public static void saveInt( int [] array, String fullname ){
        //Обрабатываемый ресурс
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fullname))){
            for (int i=0; i<array.length;i++)
                dos.writeInt(array[i]);
            isSaving = true;
            }
        //Улавливаемое исключение 
        catch(IOException exc){            
            System.out.println("Не удалось сохранить данные в файл");
            System.out.println(exc.getLocalizedMessage());
            isSaving = false;
        }
    }
    
    public static boolean hasSaving(){
        return isSaving;
    }
    
    
    public static int [] loadInt(String fullname){
    try(DataInputStream dis = new DataInputStream(new FileInputStream(fullname))){ 
        int [] tempArray = new int [dis.available() / 4];
        for(int i = 0; i < tempArray.length; i++) 
          tempArray[i] = dis.readInt();
       
       return tempArray;
    }
     catch (IOException exc) {
            System.out.println(exc.getLocalizedMessage());
            System.out.println("Не удалось загрузить данные");
        }
    
            return null;
    }
    
    
    
     public static void saveString(String saved, String fullname) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fullname))) {
            osw.write(saved);
            isSaving = true;
        } catch (IOException exception) {
            System.out.println(exception.getLocalizedMessage());
            isSaving = false;
        }
    }

    public static String loadString(String fullname) {
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fullname))) {
            while (reader.ready()) builder.append((char) reader.read());
        } catch (IOException exception) {
            System.out.println(exception.getLocalizedMessage());
        } return builder.toString();
    }
    
    
    
}
