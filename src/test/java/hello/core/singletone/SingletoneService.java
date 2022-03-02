package hello.core.singletone;

public class SingletoneService {

    private static final SingletoneService instance = new SingletoneService();


    public static SingletoneService getInstance(){
        return instance;
    }


    private SingletoneService(){  //  생성자를 프라이빗으로 외부에서 new 객체 생성을 막는다.

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }



}
