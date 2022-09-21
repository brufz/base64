package io.github.brufz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncodeimgApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(EncodeimgApplication.class, args);
		
		//System.out.println(encodeImg("C:\\Users\\Maria Luiza\\Desktop\\encode\\foto-bruna.jpg","C:\\Users\\Maria Luiza\\Desktop\\encode\\foto-bruna.txt"));
		// decodeImg("C:\\Users\\Maria Luiza\\Desktop\\encode\\foto-bruna.txt", "C:\\Users\\Maria Luiza\\Desktop\\encode\\newImg.jpg");
	}
	
	//encode img para base64 string
	private static String encodeImg(String imgPath, String savePath) throws Exception {
		FileInputStream imageStream = new FileInputStream(imgPath);
		byte [] data = imageStream.readAllBytes();
		String imgString = Base64.getEncoder().encodeToString(data);
		
		//criando um arquivo para o base64
		FileWriter fileWriter = new FileWriter(savePath);
		fileWriter.write(imgString);
		fileWriter.close();
		imageStream.close();
		
		return imgString;
	}
	
	// decode img do base64 string e criar um novo arquivo de imagem
	
	private static void decodeImg(String txtPath, String savePath) throws Exception {
	FileInputStream inputStream = new FileInputStream(txtPath);
	inputStream.readAllBytes();
	byte [] data = Base64.getDecoder().decode(new String (inputStream.readAllBytes()));
	
	FileOutputStream fileOutputStream = new FileOutputStream(savePath);
	fileOutputStream.write(data);
	fileOutputStream.close();
	inputStream.close();
	}

}
