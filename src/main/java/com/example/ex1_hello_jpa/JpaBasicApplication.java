package com.example.ex1_hello_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaBasicApplication {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        // 트랜잭션
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            /*
            *** 사용자 생성 쿼리 (CREATE) ***
            Member member = new Member();
            member.setId(2L);
            member.setName("helloB");
            em.persist(member);

            *** 이건 조회 쿼리 (READ) ***
            Member member1 = em.find(Member.class, 2L);
            System.out.println("member1.getId() :" + member1.getId());
            System.out.println("member1.getName() :" + member1.getName());

            *** 이건 수정 쿼리 (UPDATE) -> persist 안해줘도 자동으로 update가 된다!!!! ***
            Member member1 = em.find(Member.class, 2L);
            member1.setName("hello1122");

            *** 이건 삭제 쿼리 (DELETE) ***
            em.remove(member1);

             */


            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(4)
                    .setMaxResults(5)
                    .getResultList();

            for (Member m : result) {
                System.out.println("member.name : " + m.getName());
            }

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            //entity Manager은 내부적으로 데이터베이스 커넥션을 물고 동작하기 때문에 반드시 닫아주어야 한다.
            em.close();
        }

        emf.close();


    }

}
