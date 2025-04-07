package hw8;

import java.math.BigInteger;
import java.util.*;

public class hw8 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {


/*
        ┏  ━  ━  ━  ━  ━  ━  ┓
        ┃  ■  Question ━  1  ┃
        ┗  ━  ━  ━  ━  ━  ━  ┛
 */


//        • 請建立一個Collection物件並將以下資料加入:
//        Integer(100)、Double(3.14)、Long(21L)、Short(“100”)、Double(5.1)、“Kitty”、Integer(100)、
//        Object物件、“Snoopy”、BigInteger(“1000”)


//        Collection col = new ArrayList();
//        col.add(new Integer(100));
//        col.add(new Double(3.14));
//        col.add(new Long(21L));
//        col.add(new Short("100"));
//        col.add(new Double(5.1));
//        col.add("Kitty");
//        col.add(new Integer(100));
//        col.add(new Object());
//        col.add("Snoopy");
//        col.add(new BigInteger("1000"));


//        • 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)


//        Iterator iterator = col.iterator();
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//            System.out.print("[ " + next + " ] ");
//
//        }
//
//        Object[] obj = col.toArray();
//        for(int i = 0; i < obj.length; i++) {
//            System.out.print("[ " + obj[i] + " ] ");
//        }

//        for (Object o : col) {
//            System.out.print("[ " + o + " ] ");
//        }


//        • 移除不是java.lang.Number相關的物件


//        Iterator iterator = col.iterator();
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//            if(!(next instanceof Number)) {
//                iterator.remove();
//            }
//        }


//        • 再次印出這個集合物件的所有元素,觀察是否已將非Number相關的物件移除成功


//        for (Object o : col) {
//            System.out.print("[ " + o + " ] ");
//        }


/*
        ┏  ━  ━  ━  ━  ━  ━  ┓
        ┃  ■  Question ━  2  ┃
        ┗  ━  ━  ━  ━  ━  ━  ┛
 */


//        • 請設計一個Train類別,並包含以下屬性:
//        - 班次 number,型別為int - 車種 type,型別為String - 出發地 start,型別為String
//        - 目的地 dest,型別為String - 票價 price,型別為double

//        • 設計對應的getter/setter方法,並在main方法裡透過建構子產生以下7個Train的物件,放到每小題
//          需使用的集合裡
//        - (202, “普悠瑪”, “樹林”, “花蓮”, 400)
//        - (1254, “區間”, “屏東”, “基隆”, 700)
//        - (118, “自強”, “高雄”, “台北”, 500)
//        - (1288, “區間”, “新竹”, “基隆”, 400)
//        - (122, “自強”, “台中”, “花蓮”, 600)
//        - (1222, “區間”, “樹林”, 七堵, 300)
//        - (1254, “區間”, “屏東”, “基隆”, 700)


//        List<Train> trainsList = new ArrayList<Train>();
//
//        trainsList.add(new Train(202, "普悠瑪", "樹林", "花蓮", 400));
//        trainsList.add(new Train(1254, "區間", "屏東", "基隆", 700));
//        trainsList.add(new Train(118, "自強", "高雄", "台北", 500));
//        trainsList.add(new Train(1288, "區間", "新竹", "基隆", 400));
//        trainsList.add(new Train(122, "自強", "台中", "花蓮", 600));
//        trainsList.add(new Train(1222, "區間", "樹林", "七堵", 300));
//        trainsList.add(new Train(1254, "區間", "屏東", "基隆", 700));


//        System.out.println("使用TreeSet");
//        Set<Train> trainsTree = new TreeSet<Train>(trainsList);
//
//        for (Train train : trainsTree) {
//            System.out.println(train);
//        }


//        • 請寫一隻程式,能印出不重複的Train物件


//        Set<Train> trainsSet = new HashSet<Train>(trainsList);
//
//        // 迭代器
//        Iterator<Train> iterator = trainsSet.iterator();
//        while (iterator.hasNext()) {
//            Train next =  iterator.next();
//            System.out.println(next);
//        }
//
//        System.out.println("------");


//        • 請寫一隻程式,讓Train物件印出時,能以班次編號由大到小印出

        // for迴圈
//        Collections.sort(trainsList);
//        for (int i = 0; i < trainsList.size(); i++) {
//            System.out.println(trainsList.get(i));
//        }
//        System.out.println("------");


//        • 承上,不僅能讓班次編號由大排到小印出, 還可以不重複印出Train物件


//        List<Train> trainsEx = new ArrayList<Train>(trainsSet);
//        Collections.sort(trainsEx);
//        // foreach
//        for (Object o : trainsEx) {
//            System.out.println(o);
//        }
//
//        System.out.println("------");


//        • (以上三題請根據使用的集合,練習各種取值寫法,如迭代器、for迴圈或foreach等)


    }
}

class Train implements Comparable<Train> {
    private int number;
    private String type;
    private String start;
    private String dest;
    private double price;

    public Train(int number, String type, String start, String dest, double price) {
        this.number = number;
        this.type = type;
        this.start = start;
        this.dest = dest;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return number == train.number && Double.compare(price, train.price) == 0 && Objects.equals(type, train.type) && Objects.equals(start, train.start) && Objects.equals(dest, train.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, start, dest, price);
    }

    @Override
    public int compareTo(Train o) {
        return o.getNumber() - this.getNumber();
    }

    @Override
    public String toString() {
        return "Train{" +
                "number=" + number +
                ", type='" + type + '\'' +
                ", start='" + start + '\'' +
                ", dest='" + dest + '\'' +
                ", price=" + price +
                '}';
    }
}