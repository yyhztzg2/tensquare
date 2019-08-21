package test;

import com.tensquare.user.UserApplication;
import com.tensquare.user.controller.ConfigClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringRunner.class)
public class Test {
@Autowired
    ConfigClass configClass;

    @org.junit.Test
    public void d(){
//bean 注入
       System.out.println(configClass);
    }
}
