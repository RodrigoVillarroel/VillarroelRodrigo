import ExceptionSSM.NoHayKitDisponibleException;
import Models.Kit;
import Models.Person;
import Models.Registro;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;

public class SSM {
    //================== PROPERTIES ==========================
    private LinkedHashSet<Person> pacientes;
    private ArrayList<Kit> reactivos;

    private HashMap<Integer, Registro> registros;

    //================== CONSTRUCTORS ========================


    public SSM(LinkedHashSet<Person> pacientes, ArrayList<Kit> react) {
        setPacientes(pacientes);
        setReactivos(react);
    }


    public SSM(LinkedHashSet<Person> pacientes) {
        setPacientes(pacientes);

    }

    public SSM() {
        setPacientes(new LinkedHashSet<>());
    }

    //================== GETTERS & SETTERS ===================


    public ArrayList<Kit> getReactivos() {
        return reactivos;
    }

    public void setReactivos(ArrayList<Kit> react) {
        reactivos = react;
    }

    public HashMap<Integer, Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(HashMap<Integer, Registro> registros) {
        this.registros = registros;
    }

    public LinkedHashSet<Person> getPacientes() {
        return pacientes;
    }

    public void setPacientes(LinkedHashSet<Person> pacientes) {
        this.pacientes = pacientes;
    }

    //================== METHODS =============================

    public void agregarPersonaAEspera(Person p){
        if(getPacientes()!=null){
            boolean respuesta = this.buscarPersona(p);
            if(!respuesta){
                getPacientes().addLast(p);
            }
        }
    }
    public void  listarPersonasEnEspera(){
        if(getPacientes()!=null){
            for (Person p: getPacientes()
                 ) {
                System.out.println(p);
            }
        }
    }

    public void agregarKit(Kit kit){
        if(getReactivos()!=null){
            getReactivos().add(kit);
        }else {
            setReactivos(new ArrayList<>());
            getReactivos().add(kit);
        }
    }

    public void  listarKits(){
        if(getPacientes()!=null){
            for (Kit kit: getReactivos()
            ) {
                System.out.println(kit);
            }
        }
    }

    public void  listarRegistro(){
        if(getRegistros()!=null){
            getRegistros().forEach((key, value) -> {
                System.out.println("key = " + key +"value = " + value);
            });
        }
    }

    public boolean buscarPersona(Person p){
        if(getPacientes()!=null){
            for (Person person: getPacientes()
            ) {
                if(person.equals(p)){
                    return true;
                }
            }
        }
        return false;
    }

    public void testearATodos() throws IOException {
        if(getPacientes()!=null){
            int option = 1;
            do{
                while (!getPacientes().isEmpty()) {
                    System.out.println(getPacientes().getLast());
                    this.testear(getPacientes().removeLast());
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Desea agregar mas kit?");
                System.out.println("1) si");
                System.out.println("2) no");
                option = scanner.nextInt();
                scanner.reset();
                if (option == 1) {
                    System.out.println("Cuantos kit desea cargar?");
                    Integer kitACargar = scanner.nextInt();
                    for (int i = 0; i < kitACargar; i++) {
                        getReactivos().add(new Kit(new Random().nextInt(0, 1000)));
                    }
                    this.testearATodos();
                } else {
                    exit();
                }
            }while (option==1);  // no me salio el bucle para reponer los kit

        }
    }
    public void testear(Person personATestear) throws IOException {
        if (getPacientes() != null) {

            if (!getReactivos().isEmpty()) {
                System.out.println("Hay Reactivos Disponible..");
                System.out.println("testeando..");
                Kit kitAUtilizar = getReactivos().removeFirst();
                System.out.println(kitAUtilizar);
                System.out.println("listarKits");
                this.listarKits();

                personATestear.setTemperatura(new Random().nextInt(36, 39));
                Registro registroAGuardar = new Registro(personATestear.getDni(), personATestear.getTemperatura());
                if(getRegistros()!=null){
                    getRegistros().put(kitAUtilizar.getNroKit(), registroAGuardar);
                }else {
                    setRegistros(new HashMap<>());
                    getRegistros().put(kitAUtilizar.getNroKit(), registroAGuardar);
                }
                System.out.println("ListarRegistros");
                this.listarRegistro();

                System.out.println("personATestear = " + personATestear);
                if(personATestear.getTemperatura()>=38){
                    this.aislar(personATestear, kitAUtilizar.getNroKit());
                }

            } else {
                //lanza exception no hay kit


                /*int option = 0;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Desea agregar mas kit?");
                System.out.println("1) si");
                System.out.println("2) no");
                option = scanner.nextInt();
                if(option == 1){
                    System.out.println("Cuantos kit desea cargar?");
                    Integer kitACargar = scanner.nextInt();
                    for (int i = 0; i < kitACargar; i++) {
                        getReactivos().add(new Kit(new Random().nextInt(0,1000)));
                    }
                    this.testear(personATestear);
                }else{
                    exit();
                }*/
            }

        }
    }

    private void exit() {
        System.out.println("saliendo...");
    }

    public void aislar(Person person, Integer nroTest) throws IOException {
        if(person.getTemperatura()>=38){
            //Lanza Exception lanzaremos una excepción que contendrá el
            //número de test y el barrio
            File file = new File("urgente.dat");
            if(!file.exists()){
                file.createNewFile();
            }
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
                bufferedWriter.write(nroTest.toString().concat("-" + person.getBarrio()));
                bufferedWriter.newLine();
                bufferedWriter.close();
            }catch (IOException e){
                System.out.println(Arrays.toString(e.getStackTrace()));
            }

        }
    }

    /*public void toMapFromJSON(){
        File file = new File("PersonasSanasYAAislar.json"){


            JSONObject jsonObject = new JSONObject();

            public void setJsonObject(JSONObject jsonObject) {
                this.jsonObject = jsonObject;
            }
        }
    }*/
    //================== TO STRING ===========================



    @Override
    public String toString() {
        return "SSM{" +
                "pacientes=" + pacientes +
                ", reactivos=" + reactivos +
                ", registros=" + registros +
                '}';
    }
}
