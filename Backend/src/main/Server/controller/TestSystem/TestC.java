package Server.controller.TestSystem;

import Server.Requests.RunTestRequest;
import Server.Responses.RunTestResponse;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;
import org.apache.commons.io.Charsets;

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

    public static RunTestResponse RunTest(RunTestRequest request) {

        final String include = "#pragma comment(lib, \"C:/Users/Osechkin/Downloads/google/googletest-release-1.8.0/googletest/msvc/gtest-md/Release/gtest.lib\") \n" +
                "#pragma comment(lib, \"C:/Users/Osechkin/Downloads/google/googletest-release-1.8.0/googletest/msvc/gtest-md/Release/gtest_main-md.lib\") \n" +
                "#include <gtest/gtest.h> \n" +
                "#include <iostream> \n \n" +
                "using namespace std;";

        final String main = "void main(int argc, char **argv) {\n" +
                "\ttesting::InitGoogleTest(&argc, argv);\n" +
                "\tcout << RUN_ALL_TESTS();\n" +
                "}";
        final String command = "\"C:\\Program Files (x86)\\Microsoft Visual Studio\\2017\\Professional\\Common7\\Tools\\VsDevCmd.bat\" & chcp 65001 & cd "
                             + path + " & cl " + request.namealg + ".cpp -MD & "+request.namealg+".exe & exit";
        Process p;
        StringBuilder temp = new StringBuilder("");
        String line;
        char successful = '1';
        try {
            FileOutputStream file=new FileOutputStream(path+request.namealg+".cpp");
            file.write((include + request.sourcefile + request.testfile + main).getBytes());
            file.close();
            p = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) !=null)
                temp.append(line + "<br>");
            if (temp.toString().charAt(temp.length() - 5) == '0')
            {
                successful = '0';
                temp.delete(temp.length() - 5,temp.length());
                temp.delete(0,temp.indexOf("obj") + 8);
            }
            else if (temp.toString().charAt(temp.length() - 5) == '1')
            {
                successful = '1';
                temp.delete(temp.length() - 5,temp.length());
            }
            File cpp = new File(path+request.namealg+".cpp");
            File obj = new File(path+request.namealg+".obj");
            File exe = new File(path+request.namealg+".exe");
            cpp.delete();
            obj.delete();
            exe.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RunTestResponse(temp.toString(), successful);
    }
}
