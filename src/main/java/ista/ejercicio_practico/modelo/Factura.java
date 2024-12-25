package ista.ejercicio_practico.modelo;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura", nullable = false)
    private Long idFactura;

    @Column(name = "ruc", nullable = false)
    private String ruc;
    
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @Column(name = "descuento", nullable = false)
    private Double descuento;

    @Column(name = "total", nullable = false)
    private Double total;


    /*
    Relaciones
    */
    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", nullable = false)
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    

    public Long getIdFactura() {
        return idFactura;
    }

    // Setter para idFactura
    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    // Getter para ruc
    public String getRuc() {
        return ruc;
    }

    // Setter para ruc
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    // Getter para fecha
    public Date getFecha() {
        return fecha;
    }

    // Setter para fecha
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Getter para descuento
    public Double getDescuento() {
        return descuento;
    }

    // Setter para descuento
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    // Getter para total
    public Double getTotal() {
        return total;
    }

    // Setter para total
    public void setTotal(Double total) {
        this.total = total;
    }

    // Getter para tipoPago
    public TipoPago getTipoPago() {
        return tipoPago;
    }

    // Setter para tipoPago
    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    // Getter para persona
    public Persona getPersona() {
        return persona;
    }

    // Setter para persona
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
