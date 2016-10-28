package bitcamp.java89.ems;
import java.util.Scanner;

public class ClassControl {

  private Scanner scan;
  private int length = 0;
  private ClassRoom[] classes = new ClassRoom[100];
  ClassRoom c1 = new ClassRoom();
  private boolean selectYn = false;
  static String sss;
  static String s0;
  static int s1;
  static int s2;
  static int s3;
  static boolean s4;
  static String update;

  public ClassControl(Scanner scan) {
    this.scan = scan;
  }

  public void service() {

    work:
    while (true) {

      System.out.println("ADD, LIST, VIEW, UPDATE 입력");
      sss = scan.nextLine().toUpperCase();

      if (sss.equals("ADD")) {

        working :
        //while (length < classes.length) {
        while (true) {

          this.addClassRoom();
          System.out.println("계속 입력하시겠습니까?");

          if (!scan.nextLine().equals("Y")) {
            break working;
          }
        }
      }

      else if (sss.equals("LIST")) {
        this.printClassRoom();
      }

      else if (sss.equals("VIEW")) {
        sss = scan.nextLine().toUpperCase();
        this.findClassRoom(sss);
      }
      else if (sss.equals("UPDATE"))  {

        this.printClassRoom();
        //this.updateClassRoom(sss, s0, s1, s2, s3, s4);

        System.out.println("원하는 강의실 이름을 입력하세요.");
        sss = scan.nextLine().toUpperCase();

        this.findClassRoom(sss);

        if (this.selectYn == false) {
          System.out.println("해당 강의실이 없습니다.");
          break;
        }

        System.out.println("바꾸실 데이터를 입력해주세요.");
        System.out.println("층정보");
        s0 = scan.nextLine().toUpperCase();
        System.out.println("수용인원");
        s1 = Integer.parseInt(scan.nextLine());;
        System.out.println("캐비닛 수");
        s2 = Integer.parseInt(scan.nextLine());;
        System.out.println("에어컨 수");
        s3 = Integer.parseInt(scan.nextLine());;
        System.out.println("프로젝트 빔 여부");
        s4 = scan.nextLine().equals("Y") ? true : false;
        System.out.println("최종 저장 하시겠습니까?(Y/N)");
        update = scan.nextLine().toUpperCase();

        if (!update.equals("Y")) {
          System.out.println("저장이 취소되었습니다.");
          continue;
        } else {
          // 업데이트
          this.updateClassRoom(sss, s0, s1, s2, s3, s4);
        }
        System.out.println("결과를 확인하세요.");
        this.printClassRoom();
        continue;
      }

      else if (sss.equals("QUIT")) {
        System.out.println("안농.");
          break work;
      }

      else {
        System.out.print("ADD, VIEW, LIST 중 입력");
        sss = scan.nextLine().toUpperCase();
        continue;
      }
    }
  }

  // 강의실 List 출력
  public void printClassRoom() {

    for (int j = 0; j < this.length; j++) {
      ClassRoom c1 = classes[j];
      System.out.printf("%s, %s, %s, %d, %d, %b\n",
       c1.className
      ,c1.floorInfo
      ,c1.capacity
      ,c1.cabinetQty
      ,c1.airconditionerQty
      ,c1.projectBim);
    }
  }

  // 강의실 정보 업데이트
  public void updateClassRoom(String sss, String s0, int s1, int s2, int s3, boolean s4) {
    for (int i = 0; i < this.length; i++) {
      ClassRoom c1 = classes[i];
      if (c1.className.equals(sss)) {
        c1.floorInfo = s0;
        c1.capacity = s1;
        c1.cabinetQty = s2;
        c1.airconditionerQty = s3;
        c1.projectBim = s4;
      }
    }
  }

  // 강의실 정보 등록
  public void addClassRoom() {
    ClassRoom c2 = new ClassRoom();

    System.out.println("강의실 이름을 입력하세요.");
    c2.className = this.scan.nextLine().toUpperCase();

    System.out.println("강의실 층을 입력하세요.");
    c2.floorInfo = this.scan.nextLine().toUpperCase();

    System.out.println("강의실 수용 인원을 입력하세요.");
    c2.capacity = Integer.parseInt(this.scan.nextLine());

    System.out.println("강의실 캐비닛 수를 입력하세요.");
    c2.cabinetQty = Integer.parseInt(this.scan.nextLine());

    System.out.println("강의실 에어컨 수를 입력하세요.");
    c2.airconditionerQty = Integer.parseInt(this.scan.nextLine());

    System.out.println("강의실 프로젝트 빔 여부 (Y/N)");
    c2.projectBim = this.scan.nextLine().equals("Y") ? true : false;

    classes[length++] = c2;
  }

  // 특정 강의실 찾기
  public void findClassRoom(String sss) {
    //findClassRoom(sss);

    for (int i = 0; i < this.length; i++) {
//      ClassRoom c1 = new ClassRoom();
      //c1 = classes[i];
      //System.out.println(sss);
      if (this.classes[i].className.equals(sss)) {
         System.out.printf("%s, %s, %s, %d, %d, %b\n"
        ,this.classes[i].className
        ,this.classes[i].floorInfo
        ,this.classes[i].capacity
        ,this.classes[i].cabinetQty
        ,this.classes[i].airconditionerQty
        ,this.classes[i].projectBim);
        selectYn = true;
      }
    }
  }


}
