package cc.niushuai.graduate;


import cc.niushuai.graduate.commons.constant.Constant;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;

import java.lang.reflect.Field;

public class ReflectTest extends TestCase {


    public void test1(){

        Field[] declaredFields = Constant.class.getDeclaredFields();

        for (Field declaredField : declaredFields) {

            System.out.println(JSONObject.toJSONString(declaredField.getName()));
        }
    }
}
