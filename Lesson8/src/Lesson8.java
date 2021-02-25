
import com.Readers.ConsoleMyReader;
import com.Readers.FileMyReader;
import com.Readers.MyReader;
import com.handlers.HandlerLesson1;
import com.handlers.HandlerLesson2;
import com.handlers.MyHandler;


import java.io.IOException;


public class Lesson8 {
    public static void main(String[] args) throws IOException {


        MyReader myConsoleReader = new ConsoleMyReader();
        MyReader myFileReader = new FileMyReader();

//        Homework 8.1
//        Hello. My name is Lolka.
        MyHandler someHandler1 = new HandlerLesson1("/home/user/IdeaProjects/tms2021Android/Lesson8/src/com/data/12");
        someHandler1.handleSomeString(myConsoleReader.someReadToOneString());


        //Homework 8.2
//        /home/user/IdeaProjects/tms2021Android/Lesson8/src/com/data/InputText
        MyHandler someHandler2 = new HandlerLesson2("/home/user/IdeaProjects/tms2021Android/Lesson8/src/com/data/Out");
        someHandler2.handleSomeString(myFileReader.someReadToOneString());

    }
}

