package test;

import com.tensquare.user.UserApplication;
import com.tensquare.user.config.InterceptorConfig;
import com.tensquare.user.controller.ConfigClass;
import com.tensquare.user.interceptor.JwtInterceptor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringRunner.class)
public class Test1 {
    @Autowired
    private ConfigClass configClass;
    @Autowired
    InterceptorConfig interceptorConfig;
    @Autowired
    JwtInterceptor jwtInterceptor;

}
