Controller
-----------
> 말그대로 웹 MVC 컨트롤러

Domain
-----------
> 비지니스 객체 선언소 정도로 이해

Repository
-----------
> 저장소. DB와 연결됨. 도메인 객체 DB 저장가능
> 강의에서는 인터페이스를 따로 제작
> MemoryRepository 라는 구현체를 제작하고 인터페이스를 끌어서 사용

Service
------------
> 핵심 비지니스 로직 구현소
> 비지니스 로직 개념에 대한 이해도 숙련 필요
> 기본 로직보다 유연한 메서드 명을 사용하는 특징

DB
------------
> DB 생성 후 프로젝트와 연결
> JDBC,JPA 등 20년전 DB 연결 후 관리 로직부터 현재의 SpringJPA 까지
> SpringJPA 사용 전 JPA 깊이부터 알고 넘어가야 할듯


###Test
> 메인 메서드, 각각의 메서드가 잘 실행되는지
> 반복, 많은 코드 상관없음
> 테스트 코드 작성 굉장히 중요.
> given, when, then 개념
>  >given : 무언가를 주어졌을 때
>  >when : 이것을 실행했을 때
>  >then : 결과가 이렇게 나와야 한다.
> 테스트는 각각 독립적으로 실행되어야 한다. 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아니다.
> 테스트는 정상 플로우도 중요하지만 예외플로우가 더 중요하다.




<pre>
    <code>
        Assertions.assertEquals(result, prod);
    </code>
</pre>
> org.assertj.core.api 사용 시 assertThat() 사용 가능
> alt + enter 로 static 함수 사용가능

<pre>
    <code>
        assertThat(prod).isEqualTo(result);
    </code>
</pre>
>축약된 형식으로 사용 가능