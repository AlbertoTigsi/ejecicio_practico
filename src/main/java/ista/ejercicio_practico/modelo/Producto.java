package ista.ejercicio_practico.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_producto", nullable = false)   
    private Long idProducto;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column(name = "unidad", nullable = false)
    private String unidad;
    
    @Column(name = "iva", nullable = false)
    private Boolean iva; 
    
    /**
     * Relaciones
     */
    @ManyToOne
    @JoinColumn(name = "id_clasificacion", nullable = false)
    private Clasificacion clasificacion;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;


    public Long getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getUnidad() {
        return this.unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Boolean isIva() {
        return this.iva;
    }

    public Boolean getIva() {
        return this.iva;
    }

    public void setIva(Boolean iva) {
        this.iva = iva;
    }

    public Clasificacion getClasificacion() {
        return this.clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
}
