package hello.core.singletone;

public class StatefulService {

    private int price ; //상태를 유지 하는 필드

    // 공유 필드는 항상 조심해야 한다, 무상태로 설계하자! 
    public int order (String name, int price){
        System.out.println("name = " + name +" price = " + price);
        //this.price=price;

        return price;
    }

/*

    public  getPrice(){
        //return price; // 문제
    }
*/

}
