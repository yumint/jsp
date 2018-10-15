package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test() {
		/***Given : 주어진 상황 ***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"minji.jpg\""; 
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		//logic -> 하나의 메소드로 만드는것이 하나의 로직이 된다 
		String fileName = "";
		
		String[] split = contentDisposition.split(";");
		
		for(String str : split){
			if(str.indexOf("filename=") >= 0){
				// filename="minji.jpg"
				System.out.println("str.length() :"+ str.length());
				//str.lastIndexOf("\"") -> 20글자 나옴 
				fileName = str.substring(11,str.lastIndexOf("\""));
			}
		}
	
		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals("minji.jpg", fileName);

		
	}

}
