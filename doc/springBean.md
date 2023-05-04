springBean
==========
의존성 주입
---------

> springConfig 작성
> > @Configuration

```java
public class springConfig {

    @Bean
    public ProdService prodService() {
        return new ProdService(prodRepository());
    }

    @Bean
    public ProdRepository prodRepository() {
        return new MemoryProdRepository();
    }
}
```

> controller 생성 후 필요한 인스턴스 @Autowired 해주면
> springConfig 에 작성된 인스턴스들 내에서 의존성이 주입됬다고 보고 모두 연결됨.