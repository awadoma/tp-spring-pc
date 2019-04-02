package org.opendevup;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.opendevup.dio.EtudiantRepository;
import org.opendevup.entitys.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@SpringBootApplication
public class TpSpringMvcApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder tpSpringMvcApplication) {
        return tpSpringMvcApplication.sources(TpSpringMvcApplication.class);
    }

	public static void main(String[] args)  {
	
		ApplicationContext ctx =SpringApplication.run(TpSpringMvcApplication.class, args);
	//si tu veux acceder à tous les opjet qui spring le crée tu besoin de declarer ApplicationContext
		EtudiantRepository etudiantRepository 
		=ctx.getBean(EtudiantRepository.class);
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
		try {
			etudiantRepository.save(
			 new Etudiant("Ahmad",df.parse("1990-11-12"),"awad@gmail.com","afd"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			etudiantRepository.save(
					 new Etudiant("ali",df.parse("1995-11-12"),"awad@gmail.com","afd"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			etudiantRepository.save(
					 new Etudiant("adel",df.parse("1992-11-12"),"awad@gmail.com","afd"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	Page<Etudiant> etd= etudiantRepository.findAll(new PageRequest(0,5));
	etd.forEach(e->System.out.println(e.getNom()));
	}

}
