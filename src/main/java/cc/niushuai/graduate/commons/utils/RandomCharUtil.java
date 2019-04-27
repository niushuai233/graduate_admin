package cc.niushuai.graduate.commons.utils;

import java.util.UUID;

/**
 *  生成随机标识
 * @author
 */
public class RandomCharUtil {
	
    
    public static void main(String[] args){
    	System.out.println(generateUUID());
    	/*for(int i=0;i<100;i++){
    		System.out.println(getSixNumRand());
    	}*/
    }
    
    /**
	 * @author niushuai
	 * @Description  生成UUID
	 * @param
	 * @date 2016-12-31 下午4:37:16
	 */
    public static String generateUUID(){
    	UUID uuid = UUID.randomUUID();
    	return uuid.toString().replace("-", "");
    }

    
    /**
     * 方法描述：生成十位随机字符
     * @return
     */
    public static String getNumberRand(){
    	String tenChar = generateUUID();
    	tenChar = tenChar.substring(0,10);
        return tenChar;
    }

}