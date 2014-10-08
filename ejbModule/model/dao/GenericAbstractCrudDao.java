package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
*
* @author paulo_2
*/
public abstract class GenericAbstractCrudDao<E,I> {    
    
    protected abstract I getChave(E e);
    
    protected abstract String getSqlConsultaGenerica(E e);
    
    protected abstract E getNovoObjeto();
    
    protected abstract Query populaParametrosSqlGenerico(Query query,E e);
            
    public void salvar(E e,EntityManager entityManager) {  
    	if (getChave(e) != null) {
            e = entityManager.merge(e);
        }
        entityManager.persist(e);
    }
    
    public void excluir(E e,EntityManager entityManager) {        
        e = entityManager.merge(e);
        entityManager.remove(e);               
    }
        
    @SuppressWarnings("unchecked")
    public List<E> pesquisar(E e,EntityManager entityManager) {  
    	System.out.println("Passei pesquisar GenericDao");
        if (e == null) {
            e = getNovoObjeto();
        }
        Query query = entityManager.createQuery(getSqlConsultaGenerica(e));
        query = populaParametrosSqlGenerico(query,e);        
        return query.getResultList();
    }    
    
    public List<E> pesquisarTodos(EntityManager entityManager) {
    	System.out.println("Passei pesquisar todos GenericDao");
        return pesquisar(null,entityManager);
    }
    
}
