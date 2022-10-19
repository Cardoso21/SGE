package br.com.sge.repositorio;

import br.com.sge.dominio.Evento;
import br.com.sge.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento,Long>, JpaSpecificationExecutor<Evento> {

    boolean existsByMotivo(Long id);

    boolean existsByDataEvento(LocalDate data);

    @Query("SELECT obj FROM Evento obj ORDER BY obj.dataEvento")
    List<Evento> OrderByDate();

    @Query("SELECT obj FROM Evento obj ORDER BY obj.dataEvento")
    List<Evento> OrderByDateAdiamento(LocalDate date);

    boolean existsByUsuario(Usuario usuario);


    List<Evento> getAllByUsuario(Usuario usuario);


    @Query("select e " +
            "from Evento e " +
            "where e.dataEvento = :data")
    Optional<Evento> findTodayEvento(@Param("data") LocalDate data);


}
