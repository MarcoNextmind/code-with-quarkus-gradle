package it.nextmind.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@ToString(of = {"id"})
@RequiredArgsConstructor
@Entity
@Table(name = "utente", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
//@NamedQueries(
//    value = {@NamedQuery(name = "UtenteEntity.findAll", query = "SELECT u FROM UtenteEntity u"), @NamedQuery(
//        name = "UtenteEntity.findByUsername",
//        query = "SELECT u FROM UtenteEntity u WHERE u.username = :username")})
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UtenteEntity implements Serializable {

  @Id
  @TableGenerator(
      name = "utente_table_gen",
      table = "sequence_table",
      pkColumnName = "entity",
      valueColumnName = "count",
      pkColumnValue = "utente",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "utente_table_gen")
  private Long id;

  @Column(length = 80, nullable = false, unique = true)
  @NonNull
  private String username;

  @Column(length = 80)
  @NonNull
  private String psw;

  @Column(length = 80)
  private String email;

}
