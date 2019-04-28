import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
//        비디오 정보들을 입력하시오

//        스포츠 월드컵 100000 10

        //고객의 이름을 입력하세요

        //빌릴 비디오 이름 + 대여기간

        //월드컵 10

        //고객이 빌릴 비디오 정보를 출력 + 총 대여가격

        System.out.println("비디오 정보들을 입력하시오");
        System.out.println("입력 순서는 장르 제목 대여가격 최대 대여기간 입니다");
        System.out.println("입력완료는 end 를 입력하세요");
        Scanner scan = new Scanner(System.in);
        VideoDao videoDao = new VideoDao();
        while (true) {
            String input = scan.nextLine();
            if(input.contains("end")) break;
            String[] value = input.split(" ");
            Video video = new Video(VideoType.of(value[0]),value[1],Integer.valueOf(value[2]),Integer.valueOf(value[3]));
            video.info();
            videoDao.add(value[1],video);
        }
        System.out.println("비디오를 저장하였습니다");
        System.out.println("사용자를 입력해주세요");
        String user = scan.nextLine();
        UserDao userDao = new UserDao();
        try {
            userDao.get(user);
        } catch(IllegalArgumentException e) {
            System.out.println("사용자이름이 없어서 등록하겠습니다. 동의하면 Y 를 아니면 N ");
            String agree = scan.nextLine();
            if (agree.contains("N")) return ;
            userDao.add(user,new Customer(user));
        }
        VideoShop videoShop = new VideoShop(userDao, videoDao);
        while(true) {
            System.out.println("비디오를 빌려주세요");
            System.out.println("입력하시려면 Y 를 지금까지 종료하시려면 N 을 입력해주세요");
            String cmd = scan.nextLine();
            if(cmd.contains("Y")) {
                List<Order> orders = new ArrayList<Order>();
                while(true) {
                    System.out.println("비디오 이름 대여기간 순서로 입력해주세요");
                    System.out.println("입력이 완료됐으면 end 를 입력해주세요");
                    String order = scan.nextLine();
                    if(order.contains("end")) break;
                    String[] item = order.split(" ");
                    orders.add(new Order(item[0],Integer.valueOf(item[1])));
                }
                Order[] orderArray = orders.toArray(new Order[0]);
                videoShop.rent(user,orderArray);
                System.out.println("********************************");
                System.out.println("사용자 정보를 출력합니다");
                videoShop.info(user);
            } else return ;
        }

    }
}
