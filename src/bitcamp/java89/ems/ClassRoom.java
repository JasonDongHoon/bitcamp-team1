package bitcamp.java89.ems;

public class ClassRoom {

  String className;          // 강의실 이름
  String floorInfo;          // 강의실 층 정보
  int capacity;              // 강의실 수용 인원
  int cabinetQty;            // 캐비닛 수
  int airconditionerQty;     // 에어컨 수
  boolean projectBim;        // 프로젝트 빔 여부

  public ClassRoom() {}

  public ClassRoom(String className, String floorInfo, int capacity
                 , int cabinetQty, int airconditionerQty, boolean projectBim) {

    this.className = className;
    this.floorInfo = floorInfo;
    this.capacity = capacity;
    this.cabinetQty = cabinetQty;
    this.airconditionerQty = airconditionerQty;
    this.projectBim = projectBim;
  }
}

/*
  => #
*/
