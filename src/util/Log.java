package util;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Log {
    public static void setLog(String log){
        try{
            File file=new File("Log.txt");
            OutputStream outputStream=new FileOutputStream(file,true);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(log+"\r\n");
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

//    public static void main(String[] args){
//        Log.txt.setLog("test");
//    }

}
