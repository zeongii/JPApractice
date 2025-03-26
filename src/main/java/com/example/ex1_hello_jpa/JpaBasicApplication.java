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


            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(4)
                    .setMaxResults(5)
                    .getResultList();

            for (Member m : result) {
                System.out.println("member.name : " + m.getName());
            }

            // 비영속 상태 (멤버객체 생성)
            Member member = new Member();
            member.setId(100L);
            member.setName("helloJPA");


            System.out.println("+++ before ***");

            // 영속 상태
            em.persist(member);

            em.detach(member); // 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
            em.remove(member); // 객체를 삭제한 상태

            System.out.println("*** after ***");

            Member findMember1 = em.find(Member.class, 100L);
            Member findMember2 = em.find(Member.class, 100L);
            // 조회할 때 데이터베이스 SelectQuery가 나오지 않았다 : 1차캐시(영속성 컨텍스트)에 있는 애를 먼저 조회함
            System.out.println("result = " + (findMember1 == findMember2));
            // True 가 나오는 것을 확인할 수 있다. (컬렉션에서 가져올 때 주소가 같은 것처럼 영속Entity의 동일성을 보장해준다.)
            // -> 1차 캐시로 반복 가능한 읽기 등급을 데이터베이스가 아닌 어플리케이션 차원에서 지원해준다 (같은 트랙잭션 안에서는 비교하면 JPA가 True로 뱉어준다.)


            Member member1 = new Member("A",150L);
            Member member2 = new Member("B", 160L);

            em.persist(member1);
            em.persist(member2);


            */

            Member member = em.find(Member.class, 150L);
            member .setName("ZZZZZ");

            System.out.println("=====================");


            transaction.commit();
            // 커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다. (커밋하기 전까지는 그냥 쌓인다)

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            //entity Manager은 내부적으로 데이터베이스 커넥션을 물고 동작하기 때문에 반드시 닫아주어야 한다.
            em.close();
        }

        emf.close();


    }

}
