import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {

        printVideoRegAlram();
        Scanner scan = new Scanner(System.in);
        VideoManager videoManager = new VideoManager();
        registerVideo(scan, videoManager); // 비디오 등록

        System.out.println("비디오를 저장하였습니다");
        System.out.println("사용자를 입력해주세요");
        String user = scan.nextLine();
        CustomerManager customerManager = new CustomerManager();
        registerCustomer(user,customerManager);

        VideoShop videoShop = new VideoShop(customerManager, videoManager);

        System.out.println("[비디오 대여] :: 비디오제목 대여기간 순서로 입력해주세요");
        List<Order> orders = getOrders(scan,videoShop); // 사용자가 빌리고 싶은 비디오들을 입력한다
        Customer customer = videoShop.rent(user, orders.toArray(new Order[0]));
        System.out.println("********************************");
        System.out.println("사용자 정보를 출력합니다");
        System.out.println(customer);

    }

    private static void registerCustomer(String user, CustomerManager customerManager) {
        try{
            customerManager.get(user);
        }catch (IllegalArgumentException e) {
            System.out.println("등록되지않은 고객입니다.");
            System.out.println("시스템에 고객을 등록하겠습니다.");
            customerManager.add(new Customer(user));
        }
    }

    private static void printVideoRegAlram() {
        System.out.println("[비디오 정보 입력] :: 장르 제목 대여가격 최대 대여기간 순서로 입력해주세요");
        System.out.println("입력완료 시 end 를 입력하세요");
    }

    private static List<Order> getOrders(Scanner scan, VideoShop videoShop) {
        List<Order> orders = new ArrayList<Order>();
        while (true) {
            String order = scan.nextLine();
            if (order.contains("end")) break;
            String[] item = order.split(" ");
            orders.add(new Order(videoShop.findVideo(item[0]), Integer.valueOf(item[1])));
            System.out.println("빌릴 비디오를 추가하였습니다");
            System.out.println("대여 종료시 end 를, 입력을 원하는 경우 동일하게 입력해주세요");
        }
        return orders;
    }


    private static void registerVideo(Scanner scan, VideoManager videoManager) {
        while (true) {
            String input = scan.nextLine();
            if (input.contains("end")) break;
            String[] value = input.split(" ");
            Video video = new Video(VideoType.of(value[0]), value[1], Integer.valueOf(value[2]), Integer.valueOf(value[3]));
            System.out.println("등록된 비디오:" + video);
            videoManager.add(video);
        }
    }
}
