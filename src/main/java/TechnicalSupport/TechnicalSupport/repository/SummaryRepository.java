package TechnicalSupport.TechnicalSupport.repository;

import TechnicalSupport.TechnicalSupport.domain.Summary;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SummaryRepository {

    private final EntityManager em;

    public SummaryRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Summary summary) {
        em.persist(summary);
    }

    public Summary findOne(Long id) {
        return em.find(Summary.class, id);
    }


    public List<Summary> findAllByString(SummarySearch summarySearch) {

            String jpql = "select o from Summary o join o.site m";
            boolean isFirstCondition = true;

        //회원 이름 검색
        if (StringUtils.hasText(summarySearch.getMemberName())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Summary> query = em.createQuery(jpql, Summary.class)
                .setMaxResults(1000);

        if (StringUtils.hasText(summarySearch.getMemberName())) {
            query = query.setParameter("name", summarySearch.getMemberName());
        }

        return query.getResultList();
    }
}

