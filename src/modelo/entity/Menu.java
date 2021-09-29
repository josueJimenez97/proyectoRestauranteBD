package modelo.entity;

public class Menu {
    private Integer idMenu;
    private String dia;

    public Menu(){

    }

    public Menu(Integer idMenu, String dia) {
        this.idMenu = idMenu;
        this.dia = dia;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
