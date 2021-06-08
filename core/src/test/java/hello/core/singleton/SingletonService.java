package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //static 이라고 하면 단 하나만 등록된다.
    //다른 곳에서 new SingletonService라고 하면 참조 에러가 발생

    //조회용
    public static SingletonService getInstance(){
        return instance;
    }

    //3. 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 만든다.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
