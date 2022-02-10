package com.nit.runner;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.document.Tourist;
import com.nit.service.ITouristMgmtService;

@Component
public class MongoDBRunnerTest implements CommandLineRunner {
	@Autowired
	private ITouristMgmtService touristService;

	@Override
	public void run(String... args) throws Exception {
		//=====================save() method======================
		try {
			Integer idVal = new Random().nextInt(100000);
			Tourist tourist = new Tourist(idVal, "Yogesh", "Pune", 24.3f, "N52125878", 8632545682L, true,25,LocalDateTime.of(2026, 5, 25, 11, 15));  //With 9 fields
			String result = touristService.registerTourist(tourist);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		//=====================findAll() method======================
		//touristService.fetchAllTourists().forEach(System.out::println);

		//====================saveAll() method======================
		/*try {
			Tourist tourist1 = new Tourist(null, "Suraj", "Pune", 24.3f, "N4045623", 9856412374L, true, 25, LocalDateTime.of(2025, 05, 15, 9, 14, 15));
		
			Tourist tourist2 = new Tourist();
			tourist2.setTouristName("Rahul");
			tourist2.setNativePlace("Ahmednagar");   //With 3 fields
		
			Tourist tourist3 = new Tourist(null, "Mintu", "Bihar", 26.7f, "N4523698", 7985462314L, true, null, null);
			List<Tourist> touristList = List.of(tourist1,tourist2,tourist3);
			String msg = touristService.saveTouristGroup(touristList);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//===================findAll(sort) method====================
		//touristService.fetchAllTourists(true, "touristName", "contactNo").forEach(System.out::println);
		
		//===================findById(id) method====================
		/*Optional<Tourist> opt = touristService.fetchTouristById("620392d1a2327a309a43df70");
		if(opt.isPresent())
			System.out.println("Document is :: "+opt.get());
		else
			System.out.println("Document not found");*/
		
		//==================modify tourist information(save method)=================
		//System.out.println(touristService.modifyTouristById("620392d1a2327a309a43df70", 7977779643L));
		
		//==================remove tourist info by id (delete method)==================
		//System.out.println(touristService.removeTouristById("6203a9a4bc4e9f6fc6ed7adc"));
		
	}// run
}// class