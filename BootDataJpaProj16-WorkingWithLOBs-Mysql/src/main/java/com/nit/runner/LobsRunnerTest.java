package com.nit.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.PersonInfo;
import com.nit.service.IPersonInfoMgmtService;

@Component
public class LobsRunnerTest implements CommandLineRunner {

	@Autowired
	private IPersonInfoMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*		
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter name :: ");
				String name = sc.next();
				System.out.println("Is Married :: ");
				boolean isMarried = sc.nextBoolean();
				System.out.println("Enter photo path :: ");
				String photoPath = sc.next();
				System.out.println(photoPath);
				System.out.println("Enter resume path :: ");
				String resumePath = sc.next();
				System.out.println(resumePath);

				//Create byte[] representing photo file content
				InputStream is = new FileInputStream(photoPath);
				byte[] photoContent = new byte[is.available()];
				photoContent = is.readAllBytes();

				//Create char[] representing resume file content
				Reader reader = new FileReader(resumePath);
				File file = new File(resumePath);
				char[] resumeContent = new char[(int) file.length()];
				reader.read(resumeContent);

				//Prepare entity object with data
				PersonInfo info = new PersonInfo(-1, name, LocalDateTime.of(1996, 4, 15, 11, 52), isMarried, photoContent, resumeContent);
				try {
					System.out.println(service.registerPerson(info));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		 */
		System.out.println("========================================");
		try {
			//Logic to retrieve the object
			PersonInfo info = service.fetchPersonDetailsById(2);
			if(info!=null) {
				System.out.println(info.getPid()+" "+info.getPname()+" "+info.getDob());
				byte[] photoContent = info.getPhoto();
				OutputStream os = new FileOutputStream("retrieve_photo.jpg");
				os.write(photoContent);
				os.flush();
				os.close();
				System.out.println("Photo retrieved from db table column");
				char[] resumeContent = info.getResume();
				Writer writer = new FileWriter("retrieve_resume.txt");
				writer.write(resumeContent);
				writer.flush();
				writer.close();
				System.out.println("Resume retrieved from db table column");
			}//if
			else {
				System.out.println("Record not found");
			}
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//run
}//class