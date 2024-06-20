import Models.Kit;
import Models.Person;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SSM ssm = new SSM();

        // Creo personas
        Person p1 = new Person("a","A",24,"Aa",111111,"empleado");
        Person p2 = new Person("b","B",28,"Bb",222222,"operario");
        Person p3 = new Person("c","C",20,"Cc",333333,"piloto");
        Person p4 = new Person("d","D",45,"Dd",444444,"empresario");
        Person p5 = new Person("e","E",18,"Ee",555555,"empleado");
        Person p6 = new Person("f","F",37,"Ff",666666,"piloto");

        // agrego a la lista de espera para testearse
        ssm.agregarPersonaAEspera(p1);
        ssm.agregarPersonaAEspera(p2);
        ssm.agregarPersonaAEspera(p3);
        ssm.agregarPersonaAEspera(p4);
        ssm.agregarPersonaAEspera(p5);


        ssm.listarPersonasEnEspera();

        // creo kits para ingresar a ssm
        Kit kit1 = new Kit(new Random().nextInt(1,1000));
        Kit kit2 = new Kit(new Random().nextInt(1,1000));
        Kit kit3 = new Kit(new Random().nextInt(1,1000));
        Kit kit4 = new Kit(new Random().nextInt(1,1000));
        Kit kit5 = new Kit(new Random().nextInt(1,1000));
        Kit kit6 = new Kit(new Random().nextInt(1,1000));

        //agrego los kit a ssm
        ssm.agregarKit(kit1);
        ssm.agregarKit(kit2);
        ssm.agregarKit(kit3);
        //ssm.agregarKit(kit4);
        //ssm.agregarKit(kit5);
        //ssm.agregarKit(kit6);

        ssm.listarKits();

        System.out.println(ssm.buscarPersona(p5));

        try {
            ssm.testearATodos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




    //================== PROPERTIES ==========================
    //================== CONSTRUCTORS ========================
    //================== GETTERS & SETTERS ===================
    //================== METHODS =============================
    //================== TO STRING ===========================

}
