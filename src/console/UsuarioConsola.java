package console;

import modelo.entity.Usuario;
import modelo.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioConsola {
    private Scanner sc;
    private UsuarioRepository usuarioRepository;

    public UsuarioConsola() {
        sc = new Scanner(System.in);
        usuarioRepository = new UsuarioRepository();
    }

    public void deleteUsuario() {
        System.out.println("eliminar usuariooo");
        System.out.println("id usuario: ");
        int idUsuario = sc.nextInt();
        if(usuarioRepository.eliminarPorId(idUsuario)){
            System.out.println("Se elimino correctamente");
        }else{
            System.out.println("No se pudo eliminar el usuario");
        }
    }

    public void updateUsuario() {
        System.out.println("actualizar usuario");

        System.out.println("nombres:");
        String nombres = sc.nextLine();

        System.out.println("apellidos:");
        String apellidos = sc.nextLine();

        System.out.println("nro celular:");
        int nroCelular = sc.nextInt();

        System.out.println("id del usuario");
        int idUsuario = sc.nextInt();

        Usuario usuario = usuarioRepository.encontrarPorId(idUsuario);
        if (usuario != null) {
            usuario.setNombres(nombres);
            usuario.setApellidos(apellidos);
            usuario.setNroCelular(nroCelular);
            usuarioRepository.actualizar(usuario);
        }
        mostrarUsuarios();
    }

    public void insertarUsuario() {
        System.out.println("nombre del usuario: ");
        sc.nextLine();
        String nombres = sc.nextLine();

        System.out.println("apellidos del usuario: ");
        String apellidos = sc.nextLine();

        System.out.println("ci del usuario: ");
        int ci = sc.nextInt();

        System.out.println("nro celular del usuario: ");
        int nro_celular = sc.nextInt();

        Usuario usuario = new Usuario(nombres, apellidos, ci, nro_celular);
        usuarioRepository.insertar(usuario);

        mostrarUsuarios();
    }

    public void mostrarUsuarios() {
        ArrayList<Usuario> listaUsuarios = usuarioRepository.listarTodos();
        for (Usuario u : listaUsuarios) {
            System.out.println(u.toString());
        }
        System.out.println();
    }

}
