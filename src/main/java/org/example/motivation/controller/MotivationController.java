package org.example.motivation.controller;

import org.example.motivation.entity.Motivation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {

    int lastId = 0; // 몇 번까지 썼더라?
    List<Motivation> motivations = new ArrayList<>(); // motivation 저장// 소
    Scanner sc;

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }

    public void add() {

        int id = lastId + 1;
        System.out.print("body : ");
        String body = sc.nextLine();
        System.out.print("source : ");
        String source = sc.nextLine();

        Motivation motivation = new Motivation(id, body, source);

        motivations.add(motivation);

        System.out.printf("%d번 motivation이 등록됨\n", id);
        lastId++;
    }

    public void list() {
        if (motivations.size() == 0) {
            System.out.println("등록된 moti 없어");
            return;
        }

        System.out.println("=".repeat(40));
        System.out.printf("   id    /     source      /      body        \n");

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);

            if (motivation.getSource().length() > 7) {
                System.out.printf("   %d    /     %s     /      %s        \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody());
                continue;
            }
            System.out.printf("   %d    /     %s        /      %s        \n", motivation.getId(), motivation.getSource(), motivation.getBody());
        }

        System.out.println("=".repeat(40));
    }

    public void delete(String cmd) {
        int id = Integer.parseInt(cmd.split(" |\\=")[1]); //
//            int id2 = Integer.parseInt(cmd.split("")[2]);

        Motivation foundMotivation = null;
        int foundIndex = -1;

        for (int i = 0; i < motivations.size(); i++) {
            Motivation motivation = motivations.get(i);
            if (motivation.getId() == id) {
                foundMotivation = motivation;
                foundIndex = i;
                break;
            }
        }


        if (foundMotivation == null) {
            System.out.println("해당 moti는 없던데????");
            return;
        }

// hashmap을 사용하게되면 키밸류마다 예외처리가 가능하기때문에 조금더 용의할수도 있음
// 새{}로운 기능을 하는 클래스를 추가해서 다른 클래스에도 적용이 가능하게끔 용의하게 쓰일 수 있음

        motivations.remove(foundIndex);
        System.out.println(id + "번 moti 삭제됨");
    }
    // 내가하고싶은것 수정기능만을 하는 클래ㅡㅅ 만들기 그리거
    public void edit(String cmd){
        int id = Integer.parseInt(cmd.split(" ")[1]);
        Motivation foundMotivation = null;
        int foundIndex = -1;

        for (int i = 0; i < motivations.size(); i++) {
            Motivation motivation = motivations.get(i);
            if (motivation.getId() == id) {
                foundMotivation = motivation;
                foundIndex = i;
                break;
            }
        }

        motivations.set(id, foundMotivation);

        //암것도안쳣을대 공백이 저장되는거 막어!

    }
}




