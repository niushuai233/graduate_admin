package cc.niushuai.graduate;

import cc.niushuai.graduate.commons.enumresource.ReverseSexEnum;
import cc.niushuai.graduate.commons.utils.EnumUtil;
import org.junit.Test;

public class EnumTest {

    @Test
    public void test1(){
        String 男 = EnumUtil.getValueByCode("男", ReverseSexEnum.class);
        System.out.println(男);

    }

}
