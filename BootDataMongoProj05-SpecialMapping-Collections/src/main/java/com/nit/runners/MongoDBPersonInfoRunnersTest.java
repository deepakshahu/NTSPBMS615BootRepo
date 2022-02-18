package com.nit.runners;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.document.PersonInfo;
import com.nit.service.IPersonInfoMgmtService;

@Component
public class MongoDBPersonInfoRunnersTest implements CommandLineRunner {
	@Autowired
	private IPersonInfoMgmtService personService;

	@Override
	public void run(String... args) throws Exception {
		//=============save() method================
		/*try {
			Properties props = new Properties();
			props.put("AadharNo", 52368974);
			props.put("VoterId", 1234578);
			PersonInfo info = new PersonInfo(new Random().nextInt(10000), "Suraj", "Pune", new String[] {"blue","orange","pink"}, 
					List.of("Yogesh","Pranali"), Set.of(7891234568L, 8741256398L), Map.of("SBI",56987412365L,"ICICI",632589741258L),props);
			System.out.println(personService.registerPerson(info));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//============findAll() method==============
		//personService.fetchAllPersons().forEach(System.out::println);
		
		//==============saveAll() method==============
		/*try {
			Properties props1 = new Properties();
			props1.put("AadharNo", 784589658);
			props1.put("Driving License", 74155874);
			PersonInfo info1 = new PersonInfo(new Random().nextInt(100000), "Harsh", "Mumbai", new String[] {"gray","red"}, 
					List.of("Dhruval","Pooja"), Set.of(9652147835L, 8974563214L), Map.of("CANARA",85632147965L,"SBI",963258741L), props1);
			
			Properties props2 = new Properties();
			props2.put("AadharNo", 748596321);
			props2.put("VoterId", 741125863);
			PersonInfo info2 = new PersonInfo();
			info2.setPid(new Random().nextInt(10000));
			info2.setPname("Nikhil");
			info2.setPaddrs("Noida");
			info2.setFavColors(new String[] {"Cyan","Light Blue"});
			info2.setFriends(List.of("Munni","Sheela"));
			info2.setContactNumbers(Set.of(8596741236L,7458963214L));
			info2.setBankAccountDetails(Map.of("KOTAK",63251478978L,"AXIS",41256398745L));
			info2.setIdDetails(props2);
			
			PersonInfo info3 = new PersonInfo(new Random().nextInt(100000), "Harsh", "Mumbai", new String[] {"gray","red"}, null, null, null, null);
			List<PersonInfo> personInfoList = List.of(info1, info2, info3);
			String msg = personService.savePersonGroup(personInfoList);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//==========findAll(sort) method===========
		//personService.fetchAllPersons(true, "pname").forEach(System.out::println);
		
		//==========findById(id) method===========
		/*Optional<PersonInfo> opt = personService.fetchPersonById(3448);
		if(opt.isPresent())
			System.out.println("Document is :: "+opt.get());
		else
			System.out.println("Document not found");*/
		
		//==========modify personInfo==============
		//System.out.println(personService.modifyPersonInfoById(172, List.of("Chaman","Chini")));
		
		//===========delete personInfo=============
		System.out.println(personService.removePersonInfoById(58444));
		
	}//run
}//class