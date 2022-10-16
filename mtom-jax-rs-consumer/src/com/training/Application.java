package com.training;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.training.client.ImageProcessing;
import com.training.client.ImageProcessingImplService;

public class Application {
	
		
		public static void downloadImage() {
			
			ImageProcessing service= new ImageProcessingImplService().getImageProcessingImplPort();
			
			String imageName = "doctor.jpg";
			byte[] bytes = service.getImage(imageName);
		     
			InputStream stream =new ByteArrayInputStream(bytes);
			
			try {
				BufferedImage buffImage = ImageIO.read(stream);
				ImageIO.write(buffImage,"jpg",new File("doctor.jpg"));
				System.out.println("image saved");
				
				JFrame frame = new JFrame("show image");
				frame.setSize(300,300);
				
				JLabel label = new JLabel(new ImageIcon(buffImage));
				frame.add(label);
				frame.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		public static void uploadImage() {
			ImageProcessing service= new ImageProcessingImplService().getImageProcessingImplPort();
			
			
			try {
				BufferedImage buffImage = ImageIO.read(new File("doctor.jpg"));
				
				 ByteArrayOutputStream stream= new ByteArrayOutputStream();
		            
				 ImageIO.write(buffImage, "jpg",stream);
					
				 
		            byte[] bytes=stream.toByteArray();
		            
		            System.out.println(service.sendImage(bytes));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		


	public static void main(String[] args) {
		
		//downloadImage();  producer -> consumer
		
		//consumer->producer
		uploadImage();
	}
}
