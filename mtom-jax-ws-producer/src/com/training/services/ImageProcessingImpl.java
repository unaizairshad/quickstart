package com.training.services;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;

import com.training.ifaces.ImageProcessing;

@WebService(endpointInterface = "com.training.ifaces.ImageProcessing")
public class ImageProcessingImpl implements ImageProcessing {

	@Override
	public Image getImage(String imageName) {
		// TODO Auto-generated method stub
	try {
		return ImageIO.read(new File(imageName));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		}
	}

	@Override
	public String sendImage(Image image) {
		
	
		BufferedImage buffImage = (BufferedImage)image;
		
		try {
			ImageIO.write(buffImage, "jpg", new File("download.jpg"));
			return "Image Upload success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Image Upload failed";
		}
				
		
	}
	
	
	

}
