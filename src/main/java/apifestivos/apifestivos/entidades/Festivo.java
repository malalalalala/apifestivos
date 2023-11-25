package apifestivos.apifestivos.entidades;

// package co.edu.udea.ads.apivalidarfestivos.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import apifestivos.apifestivos.vistas.Vista;

@Data
@NoArgsConstructor // Constructor vacío de la clase Festivo - Lombok
@AllArgsConstructor // Constructor con todos los argumentos de la clase
// Festivo - Lombok

@Entity
@Table(name = "festivo")
public class Festivo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonView(Vista.SimplifiedView.class)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "dia")
    private Integer dia;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "diaspascua")
    private Integer diasPascua;

    @JsonView(Vista.SimplifiedView.class)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private Tipo tipo;

    public Festivo(Date fecha, String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
    }
}

// public Festivo() {
// }

// public Festivo(Integer id, String nombre, Integer dia, Integer mes, Integer
// diasPascua, Date fecha, Tipo tipo) {
// this.id = id;
// this.nombre = nombre;
// this.dia = dia;
// this.mes = mes;
// this.diasPascua = diasPascua;
// this.fecha = fecha;
// this.tipo = tipo;
// }
// }
