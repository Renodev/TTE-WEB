package utility;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;
import static utility.CommonFunctionality.generateID;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
@Named
@ApplicationScoped
public class ImageUploader {
	

	public static String upload(Part part) {
		if(part !=null) {
			String extension = part.getContentType();
		
		
		if(extension.substring(extension.length()-3,extension.length()).equals("png") ||
				extension.substring(extension.length()-3,extension.length()-1).equals("jpg")||
				extension.substring(extension.length()-4,extension.length()).equals("jpeg")) {
			String imageFolder = "D:\\mavenVersion6\\test\\src\\main\\webapp\\resources\\img";
			String imageFile = generateID("img")+".pgn";
			File image = new File(imageFolder+imageFile);
			try(InputStream in = part.getInputStream();
					OutputStream out = new FileOutputStream(image)){
				int data = -1;
				while ((data = in.read()) != -1) {
					out.write(data);
				}
				} catch (Exception e) {
					
				}
				return "D:\\mavenVersion6\\test\\src\\main\\webapp\\resources\\img"+imageFile;
			}
	
		}
	
			return "D:\\mavenVersion6\\test\\src\\main\\webapp\\resources\\img";
			
			
			
		}
	
	public static String getImageFolder() {
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath("D:\\mavenVersion6\\test\\src\\main\\webapp\\resources\\img");
	}

	
}
