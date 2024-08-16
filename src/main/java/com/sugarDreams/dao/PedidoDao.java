
package com.sugarDreams.dao;
import com.sugarDreams.domain.Pedido;
import com.sugarDreams.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDao extends JpaRepository<Pedido,Long>{
public List<Pedido> findByUsuario(Usuario usuario);
    
}
