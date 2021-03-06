package com.haoqiang.vpn.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Haoqiang Lyu
 * @date 2019-06-19 13:40
 */

@Repository // new CRUDDaoImpl()
@Transactional
//T=B, ID=IB
public abstract class CRUDDaoImpl<B,IB> implements CRUDDao<B,IB>{
    protected Class<B> hQLEntityClazz;

    public abstract void setHQLEntityClazz();

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public B save(B b) {
        Session session = sessionFactory.getCurrentSession();
        session.save(b);
        return b;
    }

    @Override
    public List<B> saveAll(List<B> t) {
        for(B b : t) {
            save(b);
        }
        return t;
    }

    @Override
    public List<B> findAll() {
        String hql = "FROM "+hQLEntityClazz.getName();
        Session s = sessionFactory.getCurrentSession();
        System.out.println(s);
        TypedQuery<B> query = s.createQuery(hql);
        System.out.println(query);
        return query.getResultList();
    }

    @Override
    public B findById(IB ib) {
        String hql = "FROM "+hQLEntityClazz.getName() +" b where b.id = :iibb";
        TypedQuery<B> query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("iibb",ib);
        return query.getSingleResult();
    }


}
