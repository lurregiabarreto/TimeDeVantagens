package br.com.zup.gerenciadorCompeticoes.vantagem;

import org.springframework.data.repository.CrudRepository;

public interface VantagemRepository extends CrudRepository<Vantagem,String> {

    Vantagem findByBeneficio(String beneficio);

}
