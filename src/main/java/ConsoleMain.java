import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {

        printVideoRegAlram();
        Scanner scan = new Scanner(System.in);
        VideoDao videoDao = new VideoDao();
        CustomerDao customerDao = new CustomerDao();
        VideoShop videoShop = new VideoShop(customerDao, videoDao); // 비디오 샾은 사용자조회할수 있는 객체 와 비디오를 조회할수 있는 객체를 가지고 있다.
        registerVideo(scan, videoShop); // 비디오 등록

        System.out.println("비디오를 저장하였습니다");
        System.out.println("사용자를 입력해주세요");
        String user = scan.nextLine();


        Customer customer = videoShop.registerCustomer(user);


        while (true) {
            System.out.println("비디오를 빌려주세요");
            System.out.println("입력하시려면 Y 를 지금까지 종료하시려면 N 을 입력해주세요");
            String cmd = scan.nextLine();
            if (!cmd.toLowerCase().contains("y")) break;
            List<Order> orders = getOrders(scan); // 사용자가 빌리고 싶은 비디오들을 입력한다
            videoShop.rent(user, orders.toArray(new Order[0]));
            System.out.println("********************************");
            System.out.println("사용자 정보를 출력합니다");
            videoShop.info(user);
        }
    }

    private static void printVideoRegAlram() {
        System.out.println("비디오 정보들을 입력하시오");
        System.out.println("입력 순서는 장르 제목 대여가격 최대 대여기간 입니다");
        System.out.println("입력완료는 end 를 입력하세요");
    }

    private static List<Order> getOrders(Scanner scan) {
        List<Order> orders = new ArrayList<Order>();
        while (true) {
            System.out.println("비디오 이름 대여기간 순서로 입력해주세요");
            System.out.println("입력이 완료됐으면 end 를 입력해주세요");
            String order = scan.nextLine();
            if (order.contains("end")) break;
            String[] item = order.split(" ");
            orders.add(new Order(item[0], Integer.valueOf(item[1])));
        }
        return orders;
    }


    private static void registerVideo(Scanner scan, VideoShop videoShop) {
        while (true) {
            String input = scan.nextLine();
            if (input.contains("end")) break;
            String[] value = input.split(" ");
            Video video = new Video(VideoType.of(value[0]), value[1], Integer.valueOf(value[2]), Integer.valueOf(value[3]));
            System.out.println("등록된 비디오:" + video);
            videoShop.registerVideo(value[1], video);
        }
    }
}
