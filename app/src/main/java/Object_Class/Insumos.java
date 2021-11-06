package Object_Class;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {
    private int id;
    private String[] insumos = {"Mancuernas","Barras","Press Banca","Puching Bag", "Colchoneta", "Trotadora"};
    private int[] precios = {45000, 22000, 34550, 34560, 10000, 285000};
    private int[] adicional = {2250, 1100, 1720, 1730, 500, 9000};
    private int stock;
    int d = 1;

    public Insumos(){

    }

    public Insumos(int id, String[] insumos, int[] precios, int[] adicional, int stock) {
        this.id = id;
        this.insumos = insumos;
        this.precios = precios;
        this.adicional = adicional;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int[] getAdicional() {
        return adicional;
    }

    public void setAdicional(int[] adicional) {
        this.adicional = adicional;
    }

    public int calcularTotal(int precio, int adicion){
        int resultado = precios[precio]+adicional[adicion];
        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumos insumos1 = (Insumos) o;
        return id == insumos1.id && stock == insumos1.stock && Arrays.equals(insumos, insumos1.insumos) && Arrays.equals(precios, insumos1.precios) && Arrays.equals(adicional, insumos1.adicional);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(insumos);
        result = 31 * result + Arrays.hashCode(precios);
        result = 31 * result + Arrays.hashCode(adicional);
        return result;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "id=" + id +
                ", insumos=" + Arrays.toString(insumos) +
                ", precios=" + Arrays.toString(precios) +
                ", adicional=" + Arrays.toString(adicional) +
                ", stock=" + stock +
                '}';
    }

}
