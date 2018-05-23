package Server.controller.TestSystem;

import Server.Requests.RunTestRequest;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * Created by osech on 11.05.2018.
 */
public class TestC
{
    private static final String path  = new File("").getAbsolutePath() + "\\cppfiles\\";

    public static String RunTest(RunTestRequest request) {

        final String command = "\"C:\\Program Files (x86)\\Microsoft Visual Studio\\2017\\Professional\\Common7\\Tools\\VsDevCmd.bat\" & chcp 65001 & cd "
                             + path + " & cl " + request.namealg + ".cpp -MD & "+request.testfile+".exe";
        Process p = null;
        StringBuilder temp = new StringBuilder("");
        String line = null;
        try {
            FileOutputStream file=new FileOutputStream(path+request.namealg+".cpp");
            file.write((request.sourcefile + request.testfile).getBytes());
            p = Runtime.getRuntime().exec(command);
            //p.waitFor();
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) !=null)
                temp.append(line);
            if (temp.toString().charAt(temp.length() - 1) == '0')
            {

            }
            else
            {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
