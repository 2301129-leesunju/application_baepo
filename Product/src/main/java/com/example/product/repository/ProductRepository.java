package com.example.product.repository;

import com.example.product.domain.Product;
import com.example.product.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

//java 의 인터페이스 : 클래스가 어떤 기능을 제공해야 하는지 정해놓은 약속
//class : 그 기능이 실제로 어떻게 동작하게 되는 지 구현
//StudyRepository : Study Entity의 db 접근을 담당
//JpaRepository<Study, Long> : Study - 관리를 할 Entity, Long - Study id의 자료형
//-> Spring Data Jpa 가 CRUD 등의 기본 DB 작업을 제공
public interface ProductRepository extends JpaRepository<Product, Long> {
/*매서드를 직접 작성하지 않아도 Spring Data Jpa 가 아래의 기능들을 자동으로 적용
* save() : 자장 또는 변경
* findAll() : 전체 조회
* findById() : 특정 id 조회
* deleteById() : 특정 Id 삭제
* */


}
