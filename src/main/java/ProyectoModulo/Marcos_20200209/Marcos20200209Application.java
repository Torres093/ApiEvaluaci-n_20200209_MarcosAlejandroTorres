package ProyectoModulo.Marcos_20200209;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Marcos20200209Application {

	public static void main(String[] args) {
		SpringApplication.run(Marcos20200209Application.class, args);
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
            System.setProperty(entry.getKey(), entry.getValue())
        );
		//configuración inicial en el main
	}

}
