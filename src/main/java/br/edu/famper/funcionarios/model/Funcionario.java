package br.edu.famper.funcionarios.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.boot.registry.selector.StrategyRegistration;

@Entity
@Table(name = "tbl_funcionario")
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "funcionario_id")
    private Long id;

    @Column(name = "name", length = 75)
    private String name;

    @Column(name = "Cargo", length = 150)
    private String Cargo;

    @Column(name = "Departamento", length = 150)
    private String  Departamento;

    @Column(name = "Data de Admissão", length = 150)
    private String DataDeAdmissao;

    @Column(name = "E-mail", length = 150)
    private String Email;

    @Column(name = "Telefone", length = 150)
    private String Telefone;
}